package groupId.artifactId.core.dto;

public class ProductCreationDto {
    private final String name;
    private final int price;
    private final int discount;
    private final String description;
    ProductCreationDto ( String name, int price, int discount, String description) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
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

}
