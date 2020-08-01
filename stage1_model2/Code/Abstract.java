package com.lagou.homework2;

public abstract class Abstract implements CallPackageAbstract,OnlinepackageAbstract {

    private int PMoney;

    public Abstract() {
    }

    public Abstract(int PMoney) {
        setPMoney(PMoney);
    }

    public int getPMoney() {
        return PMoney;
    }
    public void setPMoney(int PMoney) {
        this.PMoney = PMoney;
    }

    public abstract void show();
}
