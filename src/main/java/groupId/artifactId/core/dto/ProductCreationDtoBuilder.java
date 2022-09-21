package groupId.artifactId.core.dto;

public class ProductCreationDtoBuilder {
    private String name;

    private int price;

    private int discount;

    private String description;

    private ProductCreationDtoBuilder() {
    }

    public static ProductCreationDtoBuilder create() {
        return new ProductCreationDtoBuilder();
    }

    public ProductCreationDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductCreationDtoBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductCreationDtoBuilder setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public ProductCreationDtoBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductCreationDto build() {
        return new ProductCreationDto(name, price, discount, description);
    }
}

