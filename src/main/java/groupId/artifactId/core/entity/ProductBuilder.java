package groupId.artifactId.core.entity;

public class ProductBuilder {
    private String name;

    private int price;

    private int discount;

    private String description;

    private ProductBuilder() {
    }

    public static ProductBuilder create() {
        return new ProductBuilder();
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        return new Product(name, price, discount, description);
    }
}
