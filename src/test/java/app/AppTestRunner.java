package app;

import com.back.App;
import com.back.global.AppConfig;
import com.back.global.AppContext;
import test.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "\n종료"); //종료 자동화

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();

        AppConfig.setTestMode();
        AppContext.init(sc, false);
        new App().run();

        // App 을 다 돌리면 다시 모니터로 출력을 변경
        try{
            TestUtil.clearSetOutToByteArray(outputStream);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return outputStream.toString();
    }
}
