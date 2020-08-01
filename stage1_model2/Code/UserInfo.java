package com.lagou.homework2;

public class UserInfo {
    //私有化变量
    private int cnttalkTime;
    private int cntonlineFlow;
    private int conPMoney;   //每月消费金额
    //构造无参
    public UserInfo() {
    }
    //构造有参方法

    public UserInfo(int cnttalkTime, int cntonlineFlow, int conPMoney) {
        setCnttalkTime(cnttalkTime);
        setCntonlineFlow(cntonlineFlow);
        setConPMoney(conPMoney);
    }

    //统计通话时长
    public int getCnttalkTime() {
        return cnttalkTime;
    }
    public void setCnttalkTime(int cnttalkTime) {
        this.cnttalkTime = cnttalkTime;
    }
    //统计上网流量
    public int getCntonlineFlow() {
        return cntonlineFlow;
    }
    public void setCntonlineFlow(int cntonlineFlow) {
        this.cntonlineFlow = cntonlineFlow;
    }
    //统计每月花费
    public int getConPMoney() {
        return conPMoney;
    }
    public void setConPMoney(int conPMoney) {
        this.conPMoney = conPMoney;
    }
}
