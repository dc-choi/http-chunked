package com.server.chucked.global.common.util;

public class Util {
    /**
     * MethodArgumentNotValidException 부분에서 발생하는 에러 메시지 추출
     */
    public static String extractMessage(String input) {
        String[] str = String.join("", input.trim()
                        .replaceAll("\\[", "")
                        .replaceAll("\\]", "")
                        .split(",")
        ).trim().split(":");

        // 배열의 첫 번째 값 제거
        String[] newArray = new String[str.length - 1];
        System.arraycopy(str, 1, newArray, 0, str.length - 1);

        // 각 요소에서 "." 뒤의 문자열 제거
        for (int i = 0; i < newArray.length; i++) {
            int dotIndex = newArray[i].indexOf(".");
            if (dotIndex != -1) {
                newArray[i] = newArray[i].substring(0, dotIndex).trim();
            }
        }

        return String.join(",", newArray);
    }
}
