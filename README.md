# kafka_avro_schema_registry

Simple examples of kafka producers and consumers using apache avro format and schema registry with the full compatibility
(schema evolution)

1) Run environment:
- go to docker directory and run landoop/fast-data-dev image -> docker-compose up
- go to http://localhost:3030/ -> the kafka UI

2) Use maven plugin for auto-generation avro classes:
- maven -> lifecycle -> clean
- maven -> lifecycle -> package

Maven plugin will create them based on avro schema from resources/avro directory.
Classes will be seen in target directory. 

3) Run KafkaAvroProducerV1 to generate data based on avro schema in version 1, KafkaAvroProducerV2 for schema v2.
ConsumerV1 can read data from producer v1 and v2, the same as consumer v2. Both avro schemas are full compatibility!


More information you can find here:
https://medium.com/@stephane.maarek/introduction-to-schemas-in-apache-kafka-with-the-confluent-schema-registry-3bf55e401321
