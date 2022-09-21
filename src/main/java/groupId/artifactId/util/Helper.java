package groupId.artifactId.util;

import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.core.dto.ProductCreationDtoBuilder;

public class Helper {

    public static ProductCreationDto createProductDTO(String name, String price, String discount, String description){
        return ProductCreationDtoBuilder.create().setName(name).setPrice(Integer.parseInt(price)).
                setDiscount(Integer.parseInt(discount)).setDescription(description).build();
    }
}
