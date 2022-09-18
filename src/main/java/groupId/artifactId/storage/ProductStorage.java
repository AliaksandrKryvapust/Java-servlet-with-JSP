package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Product;
import groupId.artifactId.storage.api.IProductStorage;

import java.util.*;

import static groupId.artifactId.core.entity.ProductBuilder.create;

public class ProductStorage implements IProductStorage {
    private static ProductStorage firstInstance = null;
    private final List<Product> productList = new ArrayList<>();

    private ProductStorage(){
        this.productList.add(create().setId(1).setName("PC").setPrice(1500).setDiscount(200).setDescription("Nice and shiny").build());
        this.productList.add(create().setId(2).setName("Laptop").setPrice(1200).setDiscount(100).setDescription("light weight").build());
        this.productList.add(create().setId(3).setName("Headphones").setPrice(350).setDiscount(50).setDescription("Cool").build());
        this.productList.add(create().setId(4).setName("Smartphone").setPrice(800).setDiscount(100).setDescription("New and fashionable").build());
    }
    public static ProductStorage getInstance() {
        synchronized (ProductStorage.class) {
            if (firstInstance == null) {
                firstInstance = new ProductStorage();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Product> getEssences() {
        return this.productList;
    }

    @Override
    public Product getEssenceById(int id) {
        return this.productList.stream().filter((i)->i.getId()==id).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        this.productList.add(product);
    }
}
