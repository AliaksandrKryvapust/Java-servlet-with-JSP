package groupId.artifactId.service;

import groupId.artifactId.core.entity.Product;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.storage.ProductStorage;
import groupId.artifactId.storage.api.IProductStorage;

import java.util.List;

public class ProductService implements IProductService {
    private static ProductService firstInstance =null;
    private final IProductStorage storage;

    private ProductService(){
        this.storage= ProductStorage.getInstance();
    }
    public static ProductService getInstance() {
        synchronized (ProductService.class) {
            if (firstInstance == null) {
                firstInstance = new ProductService();
            }
        }
        return firstInstance;
    }

    @Override
    public List<Product> get() {
        return this.storage.getEssences();
    }

    @Override
    public Product get(int id) {
        return this.storage.getEssenceById(id);
    }

    @Override
    public void validate(Product item) {
        if (item == null) {
            throw new IllegalStateException("None of Products have been sent as an input");
        }
        for ( Product product: this.storage.getEssences()) {
            if (product.getId()==item.getId()){
                throw new IllegalArgumentException("This id is already exist");
            }
        }
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Product`s name is not valid");
        }
        if(item.getPrice()<=0){
            throw new IllegalArgumentException("Product`s price is negative or zero");
        }
        if (item.getDiscount()<0){
            throw  new IllegalArgumentException("Product`s discount is negative");
        }
        if (item.getDescription()==null || item.getDescription().isBlank()){
            throw new IllegalArgumentException("Product`s description is not valid");
        }
    }

    @Override
    public void addNewProduct(int id, String name, int price, int discount, String description) {
       this.validate(new Product(id, name, price, discount, description));
       this.storage.save(new Product(id, name, price, discount, description));
    }

}
