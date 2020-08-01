package com.lagou.homework2;

public class InternetPackage {

    //私有化成员变量
    private int onlineFlow;
    private int PMoney;

    public InternetPackage() {
    }

    public InternetPackage(int onlineFlow, int PMoney) {
        setOnlineFlow(onlineFlow);
        setPMoney(PMoney);
    }

    public int getOnlineFlow() {
        return onlineFlow;
    }
    public void setOnlineFlow(int onlineFlow) {
        this.onlineFlow = onlineFlow;
    }

    public int getPMoney() {
        return PMoney;
    }
    public void setPMoney(int PMoney) {
        this.PMoney = PMoney;
    }


    public void show(int i, SIMCard simCard) {
        System.out.println("上网流量： " + getOnlineFlow());
        System.out.println("资费为： " + getPMoney());
    }
}
