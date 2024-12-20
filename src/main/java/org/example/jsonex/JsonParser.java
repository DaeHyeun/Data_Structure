package org.example.jsonex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

// Event 클래스
class Event {
    public String eventType;
    public String time;
    public Map<String, Object> details;
}

// Resource 클래스
class Resource {
    public String resourceID;
    public String type;
    public int capacity;
    public double currentUtilization;
}

// Simulation 클래스
class Simulation {
    public String name;
    public String startTime;
    public String endTime;
    public List<Event> events;
    public List<Resource> resources;
}

// Root 클래스 (Simulation을 포함하는 최상위 객체)
class Root {
    public Simulation simulation;
}

public class JsonParser {
    public static void main(String[] args) {
        // JSON 파일 경로
        File jsonFile = new File("C:\\Users\\HCNC\\Desktop\\data2.json");

        // Jackson ObjectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 자바 객체로 변환
            Root root = objectMapper.readValue(jsonFile, Root.class);

            // 시뮬레이션 정보 출력
            System.out.println("Simulation Name: " + root.simulation.name);
            System.out.println("Start Time: " + root.simulation.startTime);
            System.out.println("End Time: " + root.simulation.endTime);

            // 이벤트 목록 출력
            System.out.println("\nEvents:");
            for (Event event : root.simulation.events) {
                System.out.println("Event Type: " + event.eventType);
                System.out.println("Time: " + event.time);
                System.out.println("Details: " + event.details);
            }

            // 자원 목록 출력
            System.out.println("\nResources:");
            for (Resource resource : root.simulation.resources) {
                System.out.println("Resource ID: " + resource.resourceID);
                System.out.println("Type: " + resource.type);
                System.out.println("Capacity: " + resource.capacity);
                System.out.println("Current Utilization: " + resource.currentUtilization);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
