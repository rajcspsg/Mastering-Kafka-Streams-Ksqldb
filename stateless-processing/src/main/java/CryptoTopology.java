import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.Topology;

public class CryptoTopology {

  public static Topology build() {
    StreamsBuilder builder = new StreamsBuilder();

    KStream<byte[], byte[]> stream = builder.stream("tweets");

    //stream.print(Printed.<byte[], byte[]>)toSysOut().withLabel("tweets-stream");
    stream.print(Printed.<byte[], byte[]>toSysOut().withLabel("tweets-stream"));
    return builder.build();
  }
}
