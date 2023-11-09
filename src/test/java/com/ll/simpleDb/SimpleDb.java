package com.ll.simpleDb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleDb {
    String localhost;
    String root;
    String blank;
    String simpleDb__test;
    boolean devMode;


    SimpleDb(String localhost,String root, String blank, String simpleDb_test){
        this.localhost = localhost;
        this.root = root;
        this.blank = blank;
        this.simpleDb__test = simpleDb_test;
        System.out.println("not yet");
    }

    public void run(String query){
        System.out.println(query);
    }

    public void run(String query, String title, String body, boolean isBlind){
        query = query
                .replace(" = ?"," = "+title)
                .replace(" = ?"," = "+body)
                .replace(" = ?"," = "+isBlind);
        System.out.println(query);
    }

    public Sql genSql() {
        System.out.println("not yet");
        return new Sql();
    };


}
