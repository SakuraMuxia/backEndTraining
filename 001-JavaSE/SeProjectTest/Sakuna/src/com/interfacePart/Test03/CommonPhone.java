package com.interfacePart.Test03;

public class CommonPhone extends Phone implements Game,Music,Photo,Video{
    private String keyboardType;

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public CommonPhone() {
    }

    public CommonPhone(String brand, String type, double price, String keyboardType) {
        super(brand, type, price);
        this.keyboardType = keyboardType;
    }

    @Override
    public void call() {
        System.out.println("普通手机打电话，按键拨号，体验还行");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("普通手机发短信，按键打字，体验一般：" + message);
    }

    @Override
    public void playGames(String game) {
        System.out.println("普通手机打游戏，体验一般：" + game);
    }

    @Override
    public void playMusic(String audioName) {
        System.out.println("普通手机播放音乐，音质感人：" + audioName);
    }

    @Override
    public void playPhoto() {
        System.out.println("普通手机拍照画质很感人");
    }

    @Override
    public void playVideo(String videoName) {
        System.out.println("普通手机看视频,像素很低" + videoName);
    }
}
