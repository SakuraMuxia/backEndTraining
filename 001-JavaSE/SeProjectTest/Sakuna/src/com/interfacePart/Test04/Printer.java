package com.interfacePart.Test04;

public class Printer {
    // 接口也可以作为一种数据类型
    private InkBox inkBox;
    private Paper paper;

    public InkBox getInkBox() {
        return inkBox;
    }

    public void setInkBox(InkBox inkBox) {
        this.inkBox = inkBox;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Printer() {

    }

    public Printer(InkBox inkBox, Paper paper) {
        this.inkBox = inkBox;
        this.paper = paper;
    }
    // 定义实例打印方法
    public void print(){
        System.out.println("使用" + this.getInkBox().getInkBoxType() + "墨盒在" + this.getPaper().getPaperSize() + "纸张上打印");
    }
}
