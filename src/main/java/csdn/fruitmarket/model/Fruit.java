package csdn.fruitmarket.model;

public class Fruit {
    private int id;
    private String name;
    private double price;
    private String unit;

    public Fruit(){}

    public Fruit(int number, String name, double price, String unit) {
        super();
        this.id = number;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public int getNumber() {
        return id;
    }

    public void setNumber(int number) {
        this.id = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
    }
}
