package cn.proxy;

public class SealComputerimpl implements SealComputer {
    @Override
    public String seal(double money) {
        System.out.println("花了" + money + "块购买电脑");
        return "坠机堡垒";
    }

    @Override
    public String show() {
        return "show一下坠机堡垒";
    }
}
