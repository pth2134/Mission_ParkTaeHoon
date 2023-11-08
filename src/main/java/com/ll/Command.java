package com.ll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Command {
    Scanner sc = new Scanner(System.in);
    StringTokenizer st;
    App_data data = new App_data();
    int last_id = 1;

    private final String WRONG_INPUT = "올바르지 못한 명령입니다.";
    private final String NOT_FILE = "파일을 읽을 수 없습니다. data.json을 생성합니다.";

    Command() {
        loadCheck();
        read_command();
    }

    public void read_command() {
        System.out.print("명령) ");
        st = new StringTokenizer(sc.nextLine(), "?");
        String command = st.nextToken();
        int quoteId = 0;
        if (st.hasMoreTokens()) {
            try {
                quoteId = Integer.parseInt(st.nextToken().replace("id=", ""));
            } catch (NumberFormatException nfe) {
                System.out.println(WRONG_INPUT);
            }
        }
        switch (command) {
            case "등록":
                addQuote();
                break;
            case "목록":
                System.out.println(data.selectList());
                break;
            case "삭제":
                deleteByQuoteId(quoteId);
                break;
            case "수정":
                updateByQuoteId(quoteId);
                break;
            case "빌드":
                if (data.save()) System.out.println("data.json 파일의 내용이 갱신되었습니다.");
                break;
            case "종료":
                System.out.println("프로그램이 종료됩니다.");
                return;
        }
        read_command();
    }

    private String readContent() {
        System.out.print("명언 : ");
        return sc.nextLine();
    }

    private String readAuthor() {
        System.out.print("작가 : ");
        return sc.nextLine();
    }

    private void addQuote() {
        String content = readContent();
        String author = readAuthor();
        data.getData().put(last_id, createTable(author, content, LocalDateTime.now()));
        System.out.println(last_id + "번 명언이 등록되었습니다.");
        last_id++;
    }

    private void deleteByQuoteId(int quoteId) {
        try {
            if (data.removeByQuoteId(quoteId)) {
                System.out.println(quoteId + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(quoteId + "번 명언은 존재하지 않습니다.");
            }
        } catch (NumberFormatException nfe) {
            System.out.println(WRONG_INPUT);
        }
    }

    private void updateByQuoteId(int quoteId) {
        if (data.getData().containsKey(quoteId)) {
            Quote quote = data.selectById(quoteId);
            String author = quote.getAuthor();
            String content = quote.getContent();

            System.out.println("명언(기존) : " + content);
            content = readContent();
            System.out.println("작가(기존) : " + author);
            author = readAuthor();
            data.updateByQuoteId(quoteId, createTable(author, content, LocalDateTime.now()));
            System.out.println(quoteId + " / " + author + " / " + content + " / "
                    + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        } else {
            System.out.println(quoteId + "번 명언은 존재하지 않습니다.");
        }
    }

    private Quote createTable(String author, String content, LocalDateTime localDateTime) {
        Quote table = new Quote();
        table.setContent(content);
        table.setAuthor(author);
        table.setLocalDateTime(LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd.HH:mm"))); //String으로 변환 후 저장
        //userid
        return table;
    }

    private void loadCheck() {
        try {
            boolean check = data.load();
            if (!check) System.out.println(NOT_FILE);
        } catch (NullPointerException npe) {
            System.out.println(NOT_FILE);
        }
    }

}
