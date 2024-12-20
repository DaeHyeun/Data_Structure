package org.example.jsonex;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonExample {
    public static void main(String[] args) {
        // JSON 파일을 자바 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 Map으로 변환
            File jsonFile = new File("C:\\Users\\HCNC\\Desktop\\data.json");
            Map<String, Object> jsonData = objectMapper.readValue(jsonFile, Map.class);

            /*for (Map.Entry<String ,Object> entryset : jsonData.entrySet()){
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
                System.out.println(entryset.toString());
                System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            }*/


            // 변환된 자료구조 출력
            //System.out.println(jsonData);
            //System.out.println("jsonData - class" + jsonData.getClass());

            // 예시로 특정 값을 가져오는 방법
            //System.out.println("Name: " + jsonData.get("name"));
            System.out.println("zipcode : " + ((HashMap<String, Object>)jsonData.get("address")).get("zipcode"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
