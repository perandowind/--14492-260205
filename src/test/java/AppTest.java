import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("'== 명언 앱 ==' 출력")
    void t1() throws Exception {
        String out = AppTestRunner.run("""
                종료
                """
        );

        // 굳이 출력해서 볼 필요없다면 생략해도됨
//        TestUtil.clearSetOutToByteArray(outputStream);
//        System.out.println(out);

        assertThat(out).contains("== 명언 앱 ==");
    }
}
