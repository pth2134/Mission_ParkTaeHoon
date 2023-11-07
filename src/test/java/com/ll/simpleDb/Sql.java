package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sql {

    public Sql appendIn(String str, List ids){
        System.out.println("not yet");
        return new Sql();
    }

    public Sql append(String str) {
        System.out.println("not yet");
        return new Sql();
    }

    public Sql append(String title, String str) {
        System.out.println("not yet");
        return new Sql();
    }

    public Sql append(String str, int a) {
        System.out.println("not yet");
        return new Sql();
    }

    public Sql append(String str, int a, int b) {
        System.out.println("not yet");
        return new Sql();
    }
    public Sql append(String str, int a, int b, int c) {
        System.out.println("not yet");
        return new Sql();
    }

    public Sql append(String str, int a, int b, int c, int d) {
        System.out.println("not yet");
        return new Sql();
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
