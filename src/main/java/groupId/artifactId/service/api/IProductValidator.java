package groupId.artifactId.service.api;

import groupId.artifactId.core.dto.ProductCreationDto;

public interface IProductValidator {
    void validate(ProductCreationDto item);
}
