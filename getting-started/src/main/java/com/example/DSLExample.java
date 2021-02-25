package com.example;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import java.util.Properties;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;

public class DSLExample {
  public static void main(String[] args) {
    System.out.println("Hello World!!!");

    StreamsBuilder builder = new StreamsBuilder();
    KStream<String, String> stream = builder.stream("users");

    stream.foreach((key, value) -> System.out.println("(DSL) Hello, " + value));

    // set the required properties for running Kafka Streams
    Properties config = new Properties();
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "dev1");
    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

    // build the topology and start streaming
    KafkaStreams streams = new KafkaStreams(builder.build(), config);
    streams.start();

    // close Kafka Streams when the JVM shuts down (e.g. SIGTERM)
    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
  }
}
