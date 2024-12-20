package org.example.jsonex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JacksonExample {
    public static void main(String[] args) {
        // JSON 파일을 자바 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 Map으로 변환
            File jsonFile = new File("C:\\Users\\HCNC\\Desktop\\data.json");
            Map<String, Object> jsonData = objectMapper.readValue(jsonFile, Map.class);

            // 변환된 자료구조 출력
            System.out.println(jsonData);

            // 예시로 특정 값을 가져오는 방법
            System.out.println("Name: " + jsonData.get("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
