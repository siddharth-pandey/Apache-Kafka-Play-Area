//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class ConsumerSubscribeApp {
//    public static void main(String[] args){
//
//        // Following properties are mandatory to create ConsumerConfig which is then used to create a kafka consumer
//
//        KafkaConsumer<String, String> consumer = null;
//        Properties properties = new Properties();
//
//        properties.put("bootstrap.servers", "localhost:9092"); // specify more than one to provide fallback broker access.
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("group.id", "test");
//
//        ArrayList<String> topics = new ArrayList<String>();
//        topics.add("kafka-training");
//        topics.add("kafka-training-2");
//
//        try{
//
//            consumer = new KafkaConsumer<String, String>(properties);
//
//            consumer.subscribe(topics);
//
//            while (true){
//
//                ConsumerRecords<String, String> records = consumer.poll(10);
//                // poll process is a single-threaded operation, one poll per consumer 1:1
//
//                for (ConsumerRecord<String, String> record : records) {
//                    System.out.println((String.format("Topics:  %s, Partition: %d, Offset: %d, Keys: %s, Value: %s",
//                            record.topic(), record.partition(), record.offset(), record.key(), record.value())));
//                }
//            }
//
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//        finally {
//            consumer.close();
//        }
//    }
//}
