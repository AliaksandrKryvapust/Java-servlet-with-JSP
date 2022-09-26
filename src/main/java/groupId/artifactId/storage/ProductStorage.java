package groupId.artifactId.storage;

import groupId.artifactId.core.entity.Product;
import groupId.artifactId.storage.api.IProductStorage;

import java.util.*;

public class ProductStorage implements IProductStorage {
    private static ProductStorage firstInstance = null;
    private final List<Product> productList = new ArrayList<>();
    private int id =1;

    private ProductStorage(){

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
    public List<Product> get() {
        return this.productList;
    }

    @Override
    public Optional<Product> getById(int id) {
        return this.productList.stream().filter((i) -> i.getId() == id).findFirst();
    }

    @Override
    public void save(Product product) {
        product.setId(id++);
        this.productList.add(product);
    }
}
