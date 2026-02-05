import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        lab2();


    }

    public static void lab1(){
        Scanner sc  = new Scanner("""
                등록
                과거에 집착하지 마라.
                작자미상
                """);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void lab2(){
        PrintStream ORIGINAL_OUT = System.out; // 모니터로 가는 출력

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        System.out.println("hihi"); /**화면에 출력은 안되지만, byteArrayOutputStream에 쌓이고 있음*/
        System.out.println("byebye");
        System.out.println("ok");

        System.setOut(ORIGINAL_OUT); //모니터로 출력 복원

        String result = byteArrayOutputStream.toString();

        if (result.equals("1번 명언이 등록되었습니다.")) {
            System.out.println(result);
        }


    }


}
