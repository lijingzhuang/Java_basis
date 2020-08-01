package com.lagou.homework2;

public class CallPackage extends Abstract {

    //私有化套餐类特征变量
    private int talkTime;
    private int SMSNum;       //短信条数
    private int PMoney;
    //无参构造
    public CallPackage() {
    }
    //有参构造


    public CallPackage(int talkTime, int SMSNum, int PMoney) {
        setTalkTime(talkTime);
        setSMSNum(SMSNum);
        setPMoney(PMoney);
    }

    //通话时长
    public int getTalkTime() {
        return talkTime;
    }
    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }
    //短信条数
    public int getSMSNum() {
        return SMSNum;
    }
    public void setSMSNum(int SMSNum) {
        this.SMSNum = SMSNum;
    }
    //每月资费
    public int getPMoney() {
        return PMoney;
    }
    public void setPMoney(int PMoney) {
        this.PMoney = PMoney;
    }

    @Override
    public void callpackageAbstract(int talkTime, SIMCard CardNum) {
        SIMCard.show();
        setTalkTime(talkTime);
    }

    @Override
    public void onlinepackageAbstract(int onlineFlow, SIMCard CardNum) {
        SIMCard.show();
        setTalkTime(talkTime);
    }

    public void show(){
        System.out.println("短信条数：" + getSMSNum() + "，通话时长：" + getTalkTime() + "，本月资费为：" +
                getPMoney());
    }
}
