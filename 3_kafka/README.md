# Start kafka in docker 
Using [official docker images](https://github.com/wurstmeister/kafka-docker).

```
docker-compose up -d
```

Bash to container:

```
$ docker exec -it <kafka container ID> bash
bash-4.4# find . -type f -name  kafka-topics.sh
./opt/bitnami/kafka/bin/kafka-topics.sh
bash-4.4# cd /opt/kafka_2.13-2.7.0/bin
```

# Simple usage
## Producer and consumer using external client
These clients, from the host, will use localhost to connect to Kafka.
```bash
kafka-console-producer.sh --broker-list 127.0.0.1:9093 --topic test
kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9093 --topic test --from-beginning
```
## Producer and consumer using internal client
These clients, from other containers on the same Docker network, will use the kafka container service hostname to connect to Kafka.
```bash
kafka-console-producer.sh --broker-list kafka:9092 --topic test
kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic test --from-beginning
```
## Quick start
[https://kafka.apache.org/quickstart](https://kafka.apache.org/quickstart)
```
kafka_2.13-2.7.0$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:909
kafka_2.13-2.7.0$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
Created topic quickstart-events.

kafka_2.13-2.7.0$ bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
Topic: quickstart-events        PartitionCount: 1       ReplicationFactor: 1    Configs: segment.bytes=1073741824
        Topic: quickstart-events        Partition: 0    Leader: 1       Replicas: 1     Isr: 1
```

References:
https://medium.com/@marcelo.hossomi/running-kafka-in-docker-machine-64d1501d6f0b