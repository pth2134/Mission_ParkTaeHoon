package com.ll.simpleDb;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sql {

    public Sql appendIn(String str, List ids){
        return new Sql();
    }

    public Sql append(String str) {
        return new Sql();
    }

    public Sql append(String title, String str) {
        return new Sql();
    }

    public Sql append(String str, int a) {
        return new Sql();
    }

    public Sql append(String str, int a, int b) {
        return new Sql();
    }
    public Sql append(String str, int a, int b, int c) {
        return new Sql();
    }

    public Sql append(String str, int a, int b, int c, int d) {
        return new Sql();
    }

    public long insert() {
        return 1;
    }

    public long update() {
        return 1;
    }

    public long delete() {
        return 1;
    }

    public LocalDateTime selectDatetime(){
        return LocalDateTime.now();
    }

    public long selectLong(){
        return 1;
    }

    public ArrayList<Long> selectLongs(){
        return new ArrayList<>();
    }

    public String selectString(){
        return "";
    }

    public Map selectRow(){
        return new HashMap();
    }

    public Article selectRow(Class<Article> clas){
        return new Article();
    }

    public ArrayList<Article> selectRows(Class<Article> clas){
        return new ArrayList<>();
    }


}
