package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.*;

public class Sql {
    private String query = "";
    public Sql appendIn(String query, List ids){
        ArrayList<Object> list = (ArrayList<Object>) ids;
        String range = "(`"+list.get(0)+"`";
        for (int i = 1; i < list.size(); i++) {
            range += ",`"+list.get(i)+"`";
        }
        range += ")";
        System.out.println(query);
        return this;
    }

    public Sql append(String str) {
        System.out.println("not yet");
        return this;
    }

    public Sql append(String title, String str) {
        System.out.println("not yet");
        return this;
    }

    public Sql append(String str, int a) {
        System.out.println("not yet");
        return this;
    }

    public Sql append(String str, int a, int b) {
        System.out.println("not yet");
        return this;
    }
    public Sql append(String str, int a, int b, int c) {
        System.out.println("not yet");
        return this;
    }

    public Sql append(String str, int a, int b, int c, int d) {
        System.out.println("not yet");
        return this;
    }

    public long insert() {
        System.out.println("not yet");
        return 1;
    }

    public long update() {
        System.out.println("not yet");
        return 1;
    }

    public long delete() {
        System.out.println("not yet");
        return 1;
    }

    public LocalDateTime selectDatetime(){
        System.out.println("not yet");
        return LocalDateTime.now();
    }

    public long selectLong(){
        System.out.println("not yet");
        return 1;
    }

    public ArrayList<Long> selectLongs(){
        System.out.println("not yet");
        return new ArrayList<>();
    }

    public String selectString(){
        System.out.println("not yet");
        return "";
    }

    public Map selectRow(){
        System.out.println("not yet");
        return new HashMap();
    }

    public Article selectRow(Class<Article> clas){
        System.out.println("not yet");
        return new Article();
    }

    public ArrayList<Article> selectRows(Class<Article> clas){
        System.out.println("not yet");
        return new ArrayList<>();
    }


}
