package groupId.artifactId.core.entity;

public class Product {
    private int id;
    private final String name;
    private final int price;
    private final int discount;
    private final String description;
    Product(String name, int price, int discount, String description) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
