package groupId.artifactId.storage;

import groupId.artifactId.storage.api.IProductStorage;
import groupId.artifactId.storage.entity.Product;

import java.util.*;

public class ProductStorage implements IProductStorage {

    private final List<Product> productList = new ArrayList<>();

    public ProductStorage() {

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
        if (product.getId() != null){
            throw new IllegalStateException("Error code 500. id should be empty");
        }
        product.setId(productList.size()+1);
        this.productList.add(product);
    }
}
