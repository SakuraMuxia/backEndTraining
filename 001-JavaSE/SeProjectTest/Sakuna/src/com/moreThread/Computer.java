package com.moreThread;

public class Computer {
    // 主机和显示器属性
    private String host;
    private String monitor;
    // 不用再设置 标记

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public Computer(String host, String monitor) {
        this.host = host;
        this.monitor = monitor;
    }

    public Computer() {

    }

    @Override
    public String toString() {
        return "Computer{" +
                "host='" + host + '\'' +
                ", monitor='" + monitor + '\'' +
                '}';
    }
}
