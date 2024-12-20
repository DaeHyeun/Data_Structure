package org.example;

import java.util.*;

public class QuizGame {
    public static void main(String[] args) {

        Map<String, String> quizQuestions = new HashMap<>();
        quizQuestions.put("What is the capital of France?", "Paris");
        quizQuestions.put("What is 2 + 2?", "4");
        quizQuestions.put("Who wrote 'Romeo and Juliet'?", "Shakespeare");

        Queue<String> players = new LinkedList<>();
        players.add("Player1");
        players.add("Player2");
        players.add("Player3");

        Set<String> correctAnswers = new HashSet<>();
        int score = 0;

        while (!players.isEmpty()) {
            String player = players.poll();
            System.out.println(player + "'s turn:");

            for (Map.Entry<String, String> entry : quizQuestions.entrySet()) {
                System.out.println(entry.getKey());
                String answer = new Scanner(System.in).nextLine();
                if (answer.equalsIgnoreCase(entry.getValue())) {
                    correctAnswers.add(player);
                    score++;
                    break;
                }
            }
        }

        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Final score: " + score);
    }
}
