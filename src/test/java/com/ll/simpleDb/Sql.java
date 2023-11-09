package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.*;

public class Sql {
    private String query = "";

    public Sql appendIn(String query, List ids) {
        ArrayList<Object> list = (ArrayList<Object>) ids;
        String range = "(`" + list.get(0) + "`";
        for (int i = 1; i < list.size(); i++) {
            range += ",`" + list.get(i) + "`";
        }
        range += ")";
        System.out.println(query);
        return this;
    }

    public Sql append(String query) {
        this.query += query;
        System.out.println("not yet");
        return this;
    }

    public Sql append(String query, String content) {
        this.query += query.replace("= ?", "= " + content);
        System.out.println("not yet");
        return this;
    }

    public Sql append(String str, Object... Id) {
        String Ids = Arrays.toString(Id)
                .replace("(", "(`")
                .replaceAll(", ", ",`")
                .replace(")", "`)");
        this.query += Ids;
        System.out.println("not yet");
        return this;
    }

    public long insert() {
        //query문을 입력하고 table에 insert하고 Id를 받아옴
        this.query = "";
        System.out.println("not yet");
        return 1;
    }

    public long update() {
        //업데이트된 row 갯수 return
        this.query = "";
        System.out.println("not yet");
        return 1;
    }

    public long delete() {
        //삭제된 row 갯수 return
        this.query = "";
        System.out.println("not yet");
        return 1;
    }

    public LocalDateTime selectDatetime() {
        System.out.println("not yet");
        return LocalDateTime.now();
    }

    public long selectLong() {
        System.out.println("not yet");
        return 1;
    }

    public ArrayList<Long> selectLongs() {
        System.out.println("not yet");
        return new ArrayList<>();
    }

    public String selectString() {
        System.out.println("not yet");
        return "";
    }

    public Map selectRow() {
        System.out.println("not yet");
        return new HashMap();
    }

    public Article selectRow(Class<Article> clas) {
        System.out.println("not yet");
        return new Article();
    }

    public ArrayList<Article> selectRows(Class<Article> clas) {
        System.out.println("not yet");
        return new ArrayList<>();
    }


}
