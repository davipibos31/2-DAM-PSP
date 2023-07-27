public class Company {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private double money;
    private String name;
    public Company(String name, double money) {
        this.name = name;
        this.money = money;
    }
}
