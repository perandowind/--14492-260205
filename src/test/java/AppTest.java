import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("'== 명언 앱 ==' 출력")
    void t1() throws Exception {
        Scanner sc = TestUtil.genScanner("종료");

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        new App(sc).run();

        String out = outputStream.toString();

        // 굳이 출력해서 볼 필요없다면 생략해도됨
//        TestUtil.clearSetOutToByteArray(outputStream);
//        System.out.println(out);

        assertThat(out).contains("== 명언 앱 ==");
    }
}
