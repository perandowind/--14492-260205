package com.back.global;

import lombok.Getter;

/**앱의 전역적인 설정값을 정하는 클래스*/
public class AppConfig {

    @Getter
    private static String mode;

    public static void setTestMode() {
        AppConfig.mode = "test";
    }

    public static void setDevMode() {
        AppConfig.mode = "dev";
    }
}
