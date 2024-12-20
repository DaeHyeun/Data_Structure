package org.example.jsonex;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class GsonExample {
    public static void main(String[] args) {
        // JSON 파일을 자바 객체로 변환
        Gson gson = new Gson();

        try {
            // JSON 파일을 Map으로 변환
            FileReader reader = new FileReader("C:\\Users\\HCNC\\Desktop\\data.json");
            Map<String, Object> jsonData = gson.fromJson(reader, Map.class);

            // 변환된 자료구조 출력
            System.out.println(jsonData);

            // 예시로 특정 값을 가져오는 방법
            System.out.println("Name: " + jsonData.get("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
