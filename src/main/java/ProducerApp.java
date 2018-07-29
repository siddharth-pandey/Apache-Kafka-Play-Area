import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerApp {
    public static void main(String[] args){

        KafkaProducer<String, String> producer = null;
        Properties properties = new Properties();

        properties.put("bootstrap.servers", "localhost:9092"); // specify more than one to provide fallback broker access.
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        try{

            producer = new KafkaProducer<String, String>(properties);

            for (int i = 1; i <= 100; i++){
                producer.send(new ProducerRecord<String, String>("kafka-training", Integer.toString(i), "Message: " + Integer.toString(i)));
                producer.send(new ProducerRecord<String, String>("kafka-training-2", Integer.toString(i), "Message: " + Integer.toString(i)));
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            producer.close();
        }
    }
}
