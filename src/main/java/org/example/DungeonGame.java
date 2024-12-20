package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class DungeonGame {
    static class Room {
        String description;
        Map<String, String> items;

        Room(String description) {
            this.description = description;
            this.items = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        // 던전 맵 생성
        Map<Integer, Room> dungeonMap = new HashMap<>();
        dungeonMap.put(1, new Room("You are in a dark room. A treasure chest is here."));
        dungeonMap.put(2, new Room("You are in a narrow hallway."));
        dungeonMap.put(3, new Room("A monster appears!"));

        // 아이템 설정
        dungeonMap.get(1).items.put("Treasure", "Golden Sword");

        // Stack을 사용하여 이동 경로 추적
        Stack<Integer> playerPosition = new Stack<>();
        playerPosition.push(1);

        // 게임 진행
        Scanner scanner = new Scanner(System.in);
        while (!playerPosition.isEmpty()) {
            int currentRoom = playerPosition.peek();
            System.out.println(dungeonMap.get(currentRoom).description);

            // 아이템이 있다면 출력
            if (!dungeonMap.get(currentRoom).items.isEmpty()) {
                System.out.println("Items found: " + dungeonMap.get(currentRoom).items);
            }

            System.out.print("Where to go? (2 or 3, or 0 to quit): ");
            int nextRoom = scanner.nextInt();
            if (nextRoom == 0) {
                System.out.println("Game Over!");
                break;
            } else if (dungeonMap.containsKey(nextRoom)) {
                playerPosition.push(nextRoom);
            } else {
                System.out.println("Invalid room!");
            }
        }
    }
}
