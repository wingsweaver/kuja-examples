package com.example.error.reporting.demo;

import com.wingsweaver.kuja.common.boot.errorreporting.ErrorRecord;
import com.wingsweaver.kuja.common.boot.errorreporting.ErrorReporter;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import com.wingsweaver.kuja.common.utils.model.AbstractComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@Component
public class CustomErrorReporter extends AbstractComponent implements ErrorReporter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomErrorReporter.class);

    @Override
    public void report(ErrorRecord record) {
        LogUtil.info(LOGGER, "Saving ErrorRecord: {}", record.getId());

        try {
            this.reportInternal(record);
        } catch (Exception ex) {
            LogUtil.error(LOGGER, "Failed to save ErrorRecord: {}", record.getId(), ex);
        }
    }

    private void reportInternal(ErrorRecord record) throws Exception {
        Path path = Paths.get("./logs/records", record.getId() + ".txt");
        Files.createDirectories(path.getParent());

        try (OutputStream outputStream = Files.newOutputStream(path)) {
            try (OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)) {
                try (PrintWriter printWriter = new PrintWriter(writer)) {
                    // 输出 id
                    printWriter.println("record id: ");
                    printWriter.append("\t");
                    printWriter.append(record.getId());
                    printWriter.println();
                    printWriter.println();

                    // 输出错误信息
                    printWriter.println("error:");
                    record.getError().printStackTrace(printWriter);
                    printWriter.println();

                    // 输出 tags
                    printWriter.println("tags:");
                    Map<String, Object> tags = record.getTags();
                    if (!CollectionUtils.isEmpty(tags)) {
                        for (Map.Entry<String, Object> entry : tags.entrySet()) {
                            printWriter.append("\t");
                            printWriter.append(entry.getKey());
                            printWriter.append(" = ");
                            printWriter.append(String.valueOf(entry.getValue()));
                            printWriter.append("\n");
                        }
                    }
                    printWriter.println();

                    // 输出 tags
                    printWriter.println("temps:");
                    Map<String, Object> temps = record.getTemps(false);
                    if (!CollectionUtils.isEmpty(temps)) {
                        for (Map.Entry<String, Object> entry : temps.entrySet()) {
                            printWriter.append("\t");
                            printWriter.append(entry.getKey());
                            printWriter.append(" = ");
                            printWriter.append(String.valueOf(entry.getValue()));
                            printWriter.append("\n");
                        }
                    }
                }
            }
        }
    }
}