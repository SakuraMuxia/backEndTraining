package com.enumPart.Test01;

// 枚举类实现接口
public enum Employee implements Work{
    // ";" 之前表示 枚举类 表示常量的位置
    // 创建一个 枚举类型对象 常量 作为 枚举类属性
    CEO("001","总裁","aqua"), // 相当于 new CEO();调用有参构造方法
    CTO("002","总监","sakuna"), // 相当于 new CEO();调用有参构造方法
    MANAGE("003","经理","yousa")
    ;
    // 定义属性
    private String id; // 编号
    private String job; // 职位
    private String name; // 名称

    // 封装
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 无参构造方法，默认使用private修饰，默认不写就是私有的，所以不能new对象
    Employee() {
    }

    // 有参构造方法，默认使用private修饰，默认不写就是私有的，所以不能new对象
    Employee(String id, String job, String name) {
        this.id = id;
        this.job = job;
        this.name = name;
    }

    // 实现这个接口
    @Override
    public void doWork() {
        System.out.println(name+"在工作");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // 根据员工ID返回员工员工对象
    public static Employee getEmployeeById(String employeeId){
        // 使用 values() 方法，得到枚举类属性数组
        Employee[] values = Employee.values();
        // 遍历枚举类中的属性
        for (int i = 0; i < values.length; i++) {
            // 查找id一样的 返回这个 属性对象
            if (employeeId.equals(values[i].getId())){
                return values[i];
            };
        }
        // 没有找到则返回空
        return null;
    }
}
