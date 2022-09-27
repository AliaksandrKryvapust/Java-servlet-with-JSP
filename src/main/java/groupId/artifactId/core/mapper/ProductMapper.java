package groupId.artifactId.core.mapper;

import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.storage.entity.Product;
import groupId.artifactId.storage.entity.ProductBuilder;

public class ProductMapper {
    public static Product productMapping(ProductCreationDto productCreationDto){
        return ProductBuilder.create().setName(productCreationDto.getName()).
                setPrice(productCreationDto.getPrice()).setDiscount(productCreationDto.getDiscount()).
                setDescription(productCreationDto.getDescription()).build();
    }
}
