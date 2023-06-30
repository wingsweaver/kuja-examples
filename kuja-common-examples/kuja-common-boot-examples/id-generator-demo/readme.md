# kuja-common-boot 的 id-generator 示例程序

| 项目名称         | 项目内容                                                                                     |
| ---------------- |------------------------------------------------------------------------------------------|
| lib-id-generator | 示例程序中通用的组件库。<br>包含：<br>- 使用 `LongIdGenerator`  生成 ID 的 `Controller`<br>- 以及对于 ID 的逆向解析   |
| id-gen-test1     | 使用默认的 `WorkerIdResolver` 生成的 `SnowFlakeIdGenerator`                                      |
| id-gen-test2     | 使用 `FixedWorkerIdResolver` 生成的 `SnowFlakeIdGeneartor`                                    |
| id-gen-test3     | 使用 `LocalPidWorkerIdResolver` 生成的 `SnowFlakeIdGenerator`                                 |
| id-gen-test4     | 使用 `JdbcWorkerIdResolver` 生成的 `SnowFlakeIdGenerator`<br>使用了 H2 内存数据库，数据定义参照 `schema.sql` |
| id-gen-test5     | 使用 `RedisWorkerIdResolver` 生成的 `SnowFlakeIdGenerator`<br>需要先启动本地的 `Redis` 服务器            |
| id-gen-test6     | 使用 `RedissonWorkerIdResolver` 生成的 `SnowFlakeIdGenerator`<br/>需要先启动本地的 `Redis` 服务器        |



