package com.ll;

public class App {
    Command command;
    public App(){
        command = new Command();
    }
    public void run(){
        command.run();
    }
}