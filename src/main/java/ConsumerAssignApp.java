//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.TopicPartition;
//
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class ConsumerAssignApp {
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
//        TopicPartition firstTopicPartition = new TopicPartition("kafka-training", 0);
//        TopicPartition secondTopicPartition = new TopicPartition("kafka-training-2", 2);
//
//        ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
//        partitions.add(firstTopicPartition);
//        partitions.add(secondTopicPartition);
//
//        try{
//
//            consumer = new KafkaConsumer<String, String>(properties);
//
//            consumer.assign(partitions);
//
//            while (true){
//                ConsumerRecords<String, String> records = consumer.poll(10);
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
