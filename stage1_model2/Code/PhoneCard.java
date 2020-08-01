package com.lagou.homework2;
//3.2
public enum PhoneCard {
    BigCard("大卡"), SmallCard("小卡"), MicroCard("微型卡");

    private final String phoneCard;

    PhoneCard(String phoneCard){
        this.phoneCard = phoneCard;
    }
    public String getPhoneCard(){
        return phoneCard;
    }
}
