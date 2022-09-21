package groupId.artifactId.service;

import groupId.artifactId.core.dto.ProductCreationDto;
import groupId.artifactId.service.api.IProductValidator;


public class ProductValidator implements IProductValidator {
    private static ProductValidator firstInstance =null;

    public static ProductValidator getInstance() {
        synchronized (ProductValidator.class) {
            if (firstInstance == null) {
                firstInstance = new ProductValidator();
            }
        }
        return firstInstance;
    }
    @Override
    public void validate(ProductCreationDto item) {
        if (item == null) {
            throw new IllegalStateException("Error code 500. None of Products have been sent as an input");
        }

        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Error code 400. Product`s name is not valid");
        }
        if(item.getPrice()<=0){
            throw new IllegalArgumentException("Error code 400. Product`s price is negative or zero");
        }
        if (item.getDiscount()<0){
            throw  new IllegalArgumentException("Error code 400. Product`s discount is negative");
        }
        if (item.getDescription()==null || item.getDescription().isBlank()){
            throw new IllegalArgumentException("Error code 400. Product`s description is not valid");
        }
    }
}
