package org.example.exceoption;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionExample {
    public static void main(String[] args) {
        // 여러 예외를 처리하기 위한 try-catch 문
        try {
            // 1. IOException 예외 발생 (파일이 없어서)
            FileReader fr = new FileReader("nonexistent_file.txt");

            // 2. SQLException 예외 발생 (잘못된 DB 연결)
            Connection conn = DriverManager.getConnection("jdbc:invalid_url", "user", "password");

            // 3. NullPointerException 예외 발생 (null 객체 참조)
            String str = null;
            int length = str.length();

            // 4. ArrayIndexOutOfBoundsException 예외 발생 (배열 인덱스 범위 초과)
            int[] arr = new int[3];
            arr[5] = 10;

            // 5. ArithmeticException 예외 발생 (0으로 나누기)
            int result = 10 / 0;

        } catch (IOException e) {
            System.out.println("IOException 발생: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException 발생: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException 발생: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException 발생: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException 발생: " + e.getMessage());
        } catch (Exception e) {
            // 그 외 다른 예외들 처리
            System.out.println("기타 예외 발생: " + e.getMessage());
        }
    }
}
