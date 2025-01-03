package org.example.fileIntegrityCheck;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class FileIntegrityCheck {

    // 파일의 해시값을 계산하는 메소드
    public static String getFileHash(File file, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        try (InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }
        }
        byte[] hashBytes = digest.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    // 파일의 크기를 얻는 메소드
    public static long getFileSize(File file) {
        return file.length();
    }

    // 두 파일의 내용을 비교하는 메소드
    public static boolean compareFiles(File file1, File file2) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String line1, line2;
            while ((line1 = reader1.readLine()) != null) {
                line2 = reader2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    return false;  // 내용이 다르면 false
                }
            }
            return reader2.readLine() == null;  // 파일 크기가 다르면 false
        }
    }

    // JPEG 파일의 시그니처 검사
    public static boolean isValidJpeg(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] signature = new byte[2];
            fis.read(signature);
            // JPEG 파일은 0xFF 0xD8으로 시작해야 합니다.
            return signature[0] == (byte) 0xFF && signature[1] == (byte) 0xD8;
        }
    }

    // 파일 확장자가 .txt인지 확인하는 메소드
    public static boolean isTxtFileByExtension(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".txt");
    }

    // 파일 내용이 텍스트 파일에 적합한지 확인하는 메소드
    public static boolean isTxtFileByContent(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            int character;
            while ((character = reader.read()) != -1) {
                // 텍스트 파일에서는 주로 ASCII나 유니코드 문자가 포함됩니다.
                // ASCII 범위 (0x20 ~ 0x7E) 외의 문자가 포함되면 텍스트 파일이 아닐 가능성 있음.
                if (character < 0x20 || character > 0x7E) {
                    // 텍스트가 아닌 파일 내용으로 판단할 수 있습니다.
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 파일이 텍스트 파일인지 확인하는 메소드 (확장자 + 내용 확인)
    public static boolean isTextFile(File file) {
        // 확장자 확인
        if (!isTxtFileByExtension(file)) {
            return false;
        }

        // 내용 확인
        return isTxtFileByContent(file);
    }

    public static void main(String[] args) {
        try {
            File originalFile = new File("D:/big.txt");
            File receivedFile = new File("D:/big.txt");
            File biga = new File("D:/biga.txt");

            // 원본 파일과 수신 파일의 해시값 비교
            System.out.println("HASH 비교");
            String originalFileHash = getFileHash(originalFile, "SHA-256");
            String receivedFileHash = getFileHash(receivedFile, "SHA-256");
            System.out.println(originalFileHash);
            String fileHash = getFileHash(biga, "SHA-256");
            System.out.println(fileHash);
            if (originalFileHash.equals(receivedFileHash)) {
                System.out.println("파일이 손실 없이 전송되었습니다.");
            } else {
                System.out.println("파일 손실 또는 손상이 발생했습니다.");
            }

            System.out.println();

            System.out.println("크기비교");
            // 원본 파일과 수신 파일의 크기 비교
            long originalFileSize = getFileSize(originalFile);
            long receivedFileSize = getFileSize(receivedFile);
            long bigasize = getFileSize(biga);
            System.out.println(bigasize);
            System.out.println(originalFileSize);
            System.out.println(receivedFileSize);

            System.out.println();
            System.out.println("파일 내용 비교");
            // 파일 내용 비교
            if (compareFiles(originalFile, receivedFile)) {
                System.out.println("파일 내용이 동일합니다.");
            } else {
                System.out.println("파일 내용이 달라졌습니다.");
            }


            System.out.println();
            System.out.println("파일 시그니처 검사");
            if (isValidJpeg(originalFile)) {
                System.out.println("유효한 JPEG 파일입니다.");
            } else if (isTextFile(originalFile)){
                System.out.println("txt파일 입니닷");
            }else {
                System.out.println("JPEG 파일 시그니처가 일치하지 않습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
