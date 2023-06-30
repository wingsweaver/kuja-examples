package com.example.kuja.idgen.lib;

import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.utils.constants.BufferSizes;
import com.wingsweaver.kuja.common.utils.model.tuple.Tuple3;
import com.wingsweaver.kuja.common.utils.support.idgen.LongIdGenerator;
import com.wingsweaver.kuja.common.utils.support.idgen.snowflake.CachedSnowFlakeIdGenerator;
import com.wingsweaver.kuja.common.utils.support.idgen.snowflake.SnowFlakeIdGenerator;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController {
    @Autowired
    private LongIdGenerator longIdGenerator;

    @Value("${spring.application.name:}")
    private String applicationName;

    private SnowFlakeIdGenerator snowFlakeIdGenerator;

    private Map<String, Object> typeInfo = new HashMap<>(BufferSizes.TINY);

    @RequestMapping
    public ReturnValue test(@RequestParam(name = "count", defaultValue = "1") int count) {
        Map<String, Object> map = new HashMap<>(BufferSizes.TINY);
        map.put("typeInfo", this.typeInfo);
        map.put("timestamp", DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));

        // 生成指定条数的 ID
        List<IdRecord> idRecords = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            IdRecord idRecord = new IdRecord();

            long id = this.longIdGenerator.nextId();
            idRecord.setId(id);

            Tuple3<Long, Long, Long> tuple3 = this.snowFlakeIdGenerator.parse(id);
            IdRecord.Parsed parsed = new IdRecord.Parsed();
            parsed.setTimestamp(new Date(tuple3.getT1()));
            parsed.setWorkerId(tuple3.getT2());
            parsed.setSequenceId(tuple3.getT3());
            idRecord.setParsed(parsed);

            idRecords.add(idRecord);
        }

        map.put("id-records", idRecords);

        // 返回
        return this.success(map);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        CachedSnowFlakeIdGenerator cachedSnowFlakeIdGenerator = (CachedSnowFlakeIdGenerator) this.longIdGenerator;
        this.snowFlakeIdGenerator = (SnowFlakeIdGenerator) cachedSnowFlakeIdGenerator.getIdGenerator();

        this.typeInfo.put("id-generator", this.snowFlakeIdGenerator.getClass());
        this.typeInfo.put("time-stamp-generator", this.snowFlakeIdGenerator.getTimeStampGenerator().getClass());
        this.typeInfo.put("worker-id-resolver", this.snowFlakeIdGenerator.getWorkerIdResolver().getClass());
        this.typeInfo.put("sequence-id-generator", this.snowFlakeIdGenerator.getSequenceIdGenerator().getClass());
    }
}
