package org.example.jsonex;

import java.util.List;
import java.util.Map;

public class SimulationProcessor {
    class Event {
        String eventType;
        String time;
        Map<String, Object> details;
    }

    class Resource {
        String resourceID;
        String type;
        int capacity;
        double currentUtilization;
    }

    class Simulation {
        String name;
        String startTime;
        String endTime;
        List<Event> events;
        List<Resource> resources;
    }

    public void processSimulation(Simulation simulation) {
        for (Event event : simulation.events) {
            switch (event.eventType) {
                case "Arrival":
                    handleArrival(event);
                    break;
                case "ProcessStart":
                    handleProcessStart(event, simulation);
                    break;
                case "ProcessEnd":
                    handleProcessEnd(event, simulation);
                    break;
            }
        }
    }

    private void handleArrival(Event event) {
        System.out.println("Handling arrival of product: " + event.details.get("productID"));
    }

    private void handleProcessStart(Event event, Simulation simulation) {
        String resourceID = (String) event.details.get("workStation");
        Resource resource = findResourceById(simulation.resources, resourceID);
        if (resource != null) {
            resource.currentUtilization += 0.1;  // 예시로, 작업이 시작될 때 자원의 활용도를 10% 증가시킴
            System.out.println("Process started at " + resource.resourceID);
        }
    }

    private void handleProcessEnd(Event event, Simulation simulation) {
        String resourceID = (String) event.details.get("workStation");
        Resource resource = findResourceById(simulation.resources, resourceID);
        if (resource != null) {
            resource.currentUtilization -= 0.1;  // 예시로, 작업이 끝날 때 자원의 활용도를 10% 감소시킴
            System.out.println("Process ended at " + resource.resourceID);
        }
    }

    private Resource findResourceById(List<Resource> resources, String resourceID) {
        for (Resource resource : resources) {
            if (resource.resourceID.equals(resourceID)) {
                return resource;
            }
        }
        return null;
    }
}
