package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.storage.entity.Product;

public interface IProductService extends IEEssenceService<Product> {
    void add(ProductCreationDto productCreationDto);
}
