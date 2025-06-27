package com.object.pet;

public class Cat extends Pet{
    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 0){
            System.out.println("重量输入有误，将使用默认值100g");
            this.weight = 100;
        }else{
            this.weight = weight;
        }
    }

    public Cat() {
    }
}
