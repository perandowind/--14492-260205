package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {

//    public static String run(String input) {
//
//        // 입력값
//        Scanner sc = new Scanner(input);
//
//        // 명언 프로그램 실행
//
//        // 출력값
//
//
//
//        return "";
//    }

    private static PrintStream ORIGINAL_OUT = System.out;
    private static PrintStream CURRENT_OUT = System.out;

    public static Scanner genScanner(String input){
        return new Scanner(input);
    }

    public static ByteArrayOutputStream setOutByteArray() {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);
        CURRENT_OUT = printStream;

        return byteArrayOutputStream;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream outputStream) throws Exception {
        System.setOut(ORIGINAL_OUT);
        outputStream.close();
        CURRENT_OUT.close();
    }
}
