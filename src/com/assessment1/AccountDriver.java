package com.assessment1;

public class AccountDriver {

    private Account target;

    public static void main(String[] args) {
        //创建测试用的两个账户对象payer和target
        Account payer = new Account(832003325, "朱丹清", 1000, false);
        Account target = new Account(123456789, "目标", 2000, false);
        //测试toString()
        System.out.println("----------toString()测试----------");
        System.out.println(payer.toString());
        System.out.println(target.toString());
        //测试transfer()
        payer.transfer(target, 2000);
        //创建测试用Account引用数组employees
        Account[] employees = {payer, target};
        //测试payoff()
        Account.payoff(employees, 200);
        //测试inputInstance()
        Account inputAccount = new Account(0, "a", 0, false);
        inputAccount.inputInstance();
    }
}