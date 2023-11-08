package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    App app;
    int next_id;

    private String run(final String cmd) {
        final Scanner scanner = TestUtil.genScanner(cmd.stripIndent().trim() + "\n종료");
        final ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        app = new App();
        next_id = app.command.next_id;
        app.command.sc = scanner;
        app.run();
        final String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
        return out.trim();
    }

    @Test
    @DisplayName("프로그램 시작 시 \"== 명언 앱 ==\" 출력")
    void t1() {
        final String out = run("""
                종료
                """);
        assertThat(out)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("종료")
    void t2() {
        final String out = run("""
                종료
                """);
    }

    @Test
    @DisplayName("등록")
    void t3() {
        final String out = run("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);


        assertThat(out)
                .contains("명언 :")
                .contains("작가 :")
                .contains(next_id + "번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록할 때 마다 번호가 1씩 증가")
    void t4() {

        final String out = run("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);
        assertThat(out)
                .contains(next_id + "번 명언이 등록되었습니다.")
                .doesNotContain((next_id + 1) + "번 명언이 등록되었습니다.");

        final String out2 = run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);

        assertThat(out2)
                .contains((next_id) + "번 명언이 등록되었습니다.")
                .contains((next_id + 1) + "번 명언이 등록되었습니다.")
                .doesNotContain((next_id + 2) + "번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    void t5() {

        final String out = run("""
                목록
                종료
                """);
        System.out.println(out);

        assertThat(out)
                .contains("1 / 작자미상 / 현재를 사랑하라.")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.");

    }
}