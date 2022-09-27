package groupId.artifactId.service;

import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.storage.entity.Product;
import groupId.artifactId.core.mapper.ProductMapper;
import groupId.artifactId.service.api.IProductService;
import groupId.artifactId.storage.api.StorageFactory;
import groupId.artifactId.storage.api.IProductStorage;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    private static ProductService firstInstance =null;
    private final IProductStorage storage;
    private final ProductValidator validator;

    private ProductService(){
        this.storage= StorageFactory.getInstance().getProductStorage();
        this.validator=ProductValidator.getInstance();
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
    public List<Product> getById() {
        return this.storage.get();
    }

    @Override
    public Optional<Product> getById(int id) {
        return this.storage.getById(id);
    }

    @Override
    public void add(ProductCreationDto productCreationDto) {
       this.validator.validate(productCreationDto);
       this.storage.save(ProductMapper.productMapping(productCreationDto));
    }

}
