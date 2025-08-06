package com.ThreadPart;

/**
 *  模拟多人爬山
 *  分析：将run方法体的内容,作为两个角色共同执行的爬山过程,爬山的速度不一样,所以表示休眠的时间不同;
 *  爬山的高度是相同的,角色名称不同,表示线程名不同,同时创建两个线程对象,分别 start方法,表示开始;
 *  同时爬山,因为爬山速度不同,所以到达山顶时间是不同的.
 */

public class ClimbMountain extends Thread{
    private String name;
    private int length; // 长度 高度
    private int time; // 每爬100米耗时
    // 全参构造方法
    public ClimbMountain(String name, int length, int time) {
        // 通过父类的Thread构造方法设置线程名称
        super(name);
        this.name = name;
        this.length = length;
    }
    // 重写run方法
    @Override
    public void run() {
        // 循环遍历
        while (length > 0){
            // 不同通过 throws 的方式声明异常，因为是方法重写，不能超出父类的声明异常的范围
            // 所以只能通过trycatch的方式捕获异常
            try {
                // 进程休眠，模拟爬山时间
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 每次爬山 高度降低100米
            length -= 100;
            // 提示信息
            System.out.println(Thread.currentThread().getName() + "爬了100米，剩余" + length +"米");
        }
        // 循环结束
        System.out.println(Thread.currentThread().getName() + "到达了山顶");
    }
    // 测试方法-同时也是主线程
    public static void main(String[] args) {
        // 创建爬山线程
        ClimbMountain caixukun = new ClimbMountain("蔡徐坤",3000,200);
        ClimbMountain mabaoguo = new ClimbMountain("马宝国",3000,400);

        // 开启线程
        caixukun.start();
        mabaoguo.start();
    }
}
