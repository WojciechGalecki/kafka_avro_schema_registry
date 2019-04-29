package wg.kafka.avro.specific;

import wg.kafka.Customer;

public class SpecificRecordExamples {

    public static void main(String[] args) {

        Customer customer = Customer.newBuilder()
            .setFirstName("John")
            .setLastName("McLane")
            .setAge(40)
            .setHeight(1.80f)
            .setWeight(80.5f)
            .setAutomatedEmail(false)
            .build();

        System.out.println(customer);

    }
}
