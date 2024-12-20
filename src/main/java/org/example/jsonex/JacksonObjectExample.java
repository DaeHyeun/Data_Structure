package org.example.jsonex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class Address {
    public String city;
    public String zipcode;
}

class Person {
    public String name;
    public int age;
    public Address address;
    public String[] phones;
}

public class JacksonObjectExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 Person 객체로 변환
            File jsonFile = new File("C:\\Users\\HCNC\\Desktop\\data.json");
            Person person = objectMapper.readValue(jsonFile, Person.class);

            // 객체 출력
            System.out.println("Name: " + person.name);
            System.out.println("Age: " + person.age);
            System.out.println("City: " + person.address.city);
            System.out.println("Phones: " + String.join(", ", person.phones));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
