package com.interfacePart.Test03;

public class SmartPhone extends Phone implements Game,Music,Video,Photo{
    private double screenSize;

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public SmartPhone() {
    }

    public SmartPhone(String brand, String type, double price, double screenSize) {
        super(brand, type, price);
        this.screenSize = screenSize;
    }

    @Override
    public void playGames(String game) {
        System.out.println("智能手机打游戏，体验很丝滑：" + game);
    }

    @Override
    public void playMusic(String audioName) {
        System.out.println("智能手机播放音频，音质很棒：" + audioName);
    }

    @Override
    public void call() {
        System.out.println("智能手机打电话，语音拨号，体验很不错");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("智能手机发短信，手写输入，体验很棒：" + message);
    }

    @Override
    public void playVideo(String videoName) {
        System.out.println("智能手机播放视频，很清晰：" + videoName);
    }

    @Override
    public void playPhoto() {
        System.out.println("光学长焦镜头，咔嚓一下记录美好，记录你我");
    }
}
