package com.interfacePart.Test03;

public class TestPhone {
    public static void main(String[] args) {
        // 创建一个 智能手机 对象
        SmartPhone sp = new SmartPhone("一加","OnePlus 12 Prp",4299,6.3);
        // 智能手机打电话
        sp.call();
        // 智能手机发短信
        sp.sendMessage("睡了吗");
        sp.playVideo("《小猪佩奇成人版》");
        sp.playMusic("《最炫民族风》");
        sp.playGames("《原神》");
        sp.playPhoto();

        System.out.println("----------------------------------");

        CommonPhone cp = new CommonPhone("诺基亚", "N97", 8.8, "九键");

        cp.sendMessage("有内鬼取消交易");
        cp.call();
        cp.playMusic("《发如雪》");
        cp.playGames("《贪吃蛇》");
        cp.playVideo("密码的周一能不能放过我这一次");

    }
}
