package groupId.artifactId.service.api;

import groupId.artifactId.core.entity.Product;

public interface IProductService extends IEEssenceService<Product> {

    void addNewProduct(int id, String name, int price, int discount, String description);
}
