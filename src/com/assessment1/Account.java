package com.assessment1;

import java.util.Objects;
import java.util.Scanner;

public class Account {
    private int id;
    private String name;
    private double balance;
    private boolean isFrozen;

    //构造方法
    public Account(int aid, String aname, double abalnce, boolean aisFrozen) {
        id = aid;
        name = aname;
        balance = abalnce;
        isFrozen = aisFrozen;
    }

    //toString方法
    public String toString() {
        return "Account{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                ", isFrozen=" + getIsFrozen() +
                '}';
    }

    //Getter和Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(boolean isFrozen) {
        this.isFrozen = isFrozen;
    }

    //transfer方法
    public void transfer(Account target, double money) {
        if (money < 0 || target.getIsFrozen() || this.getIsFrozen() || money > this.getBalance())
            System.out.println("转账失败，请检查:\n1.转账额是否大于等于0\n2.转账账户余额是否充足\n3.双方账户是否都未被冻结");
        else {
            this.setBalance(this.getBalance() - money);
            target.setBalance(target.getBalance() + money);
            System.out.println("转账成功，现在双方账户状态为:\n" + "转账" + this.toString() + "\n目标" + target.toString());
        }
    }

    //静态方法payoff():向所有未被冻结的账户发工资
    public static void payoff(Account[] accounts, double salary) {
        for (Account e : accounts) {
            if (!e.getIsFrozen()) {
                e.setBalance(e.getBalance() + salary);
                System.out.println(e.toString());
            }
        }
    }

    //id唯一性,乱写的，不是很懂怎么实现
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return name.equals(account.name);
    }

    //方法inputInstance:用用户输入的信息来实例化对象
    public void inputInstance() {
        Scanner in = new Scanner(System.in);

        System.out.println("name:");
        if (in.hasNextLine())
            this.setName(in.nextLine());
        else
            System.out.println("Wrong input!");
        System.out.println("id:");
        if (in.hasNextInt())
            this.setId(in.nextInt());
        else
            System.out.println("Wrong input!");
        System.out.println("balance:");
        if (in.hasNextDouble())
            this.setBalance(in.nextDouble());
        else
            System.out.println("Wrong input!");
        System.out.println("isFrozen:");
        if (in.hasNextBoolean())
            this.setIsFrozen(in.nextBoolean());
        else
            System.out.println("Wrong input!");

        System.out.println(this.toString());

    }
}
