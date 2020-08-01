package com.lagou.homework2;
//手机卡类3.1
public class SIMCard {


    //私有化特征
    private String cardType;
    private static int cardNum;
    private static String userName;
    private String passwd;
    private static int overAge;
    private int talkTime;
    private int onlineFlow;   //上网流量
    //无参构造

    public SIMCard() {
    }

    //有参构造：卡号、用户名、余额


    public SIMCard(int cardNum, String userName, int overAge) {
        setCardNum(cardNum);
        setUserName(userName);
        setOverAge(overAge);
    }

    //卡号
    public static int getCardNum() {
        return cardNum;
    }
    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    //用户名
    public static String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    //账户余额
    public static int getOverAge() {
        return overAge;
    }
    public void setOverAge(int overAge) {
        this.overAge = overAge;
    }
    //卡类型
    public String getCardType() {
        return cardType;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    //密码
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    //通话时长
    public int getTalkTime() {
        return talkTime;
    }
    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }
    //上网流量
    public int getOnlineFlow() {
        return onlineFlow;
    }
    public void setOnlineFlow(int onlineFlow) {
        this.onlineFlow = onlineFlow;
    }
    static void show(){
        System.out.println("卡号是：" + getCardNum() + "，用户名为： " + getUserName() + "，余额为： " +
                getOverAge());

    }
}
