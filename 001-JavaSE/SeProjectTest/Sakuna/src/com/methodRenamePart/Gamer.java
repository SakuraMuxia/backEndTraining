package com.methodRenamePart;

public class Gamer extends Vtuber{
    String games;

    public Gamer(String games) {
        this.games = games;
    }

    public Gamer(String name, int age, char gender, String height, String games) {
        super(name, age, gender, height);
        this.games = games;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }
    // 子类方法重写
    public void info(){
        // 调用父类的方法
        super.toString();
        System.out.println("爱好的游戏是" + this.games);
    }
}
