package wg.kafka.avro.reflection;

import java.io.File;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.file.CodecFactory;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;

public class ReflectionExamples {

    public static void main(String[] args) {

        Schema schema = ReflectData.get().getSchema(CustomerForReflection.class);

        System.out.println("Schema: \n" + schema.toString(true));

        try {
            System.out.println("Writing customer-for-reflection.avro");
            File file = new File("customer-for-reflection.avro");
            DatumWriter<CustomerForReflection> writer = new ReflectDatumWriter<>(CustomerForReflection.class);
            DataFileWriter<CustomerForReflection> out = new DataFileWriter<>(writer)
                .setCodec(CodecFactory.deflateCodec(9))
                .create(schema, file);

            out.append(new CustomerForReflection("Bruce", "Willis", 60));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
