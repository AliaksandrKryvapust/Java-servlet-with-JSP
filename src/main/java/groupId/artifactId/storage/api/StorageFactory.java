package groupId.artifactId.storage.api;

import groupId.artifactId.storage.ProductStorage;

public class StorageFactory implements IStorageFactory {
    private static StorageFactory firstInstance = null;
    private final IProductStorage productStorage;
    public StorageFactory(){
        this.productStorage= new ProductStorage();
    }

    public static StorageFactory getInstance() {
        synchronized (StorageFactory.class) {
            if (firstInstance == null) {
                firstInstance = new StorageFactory();
            }
        }
        return firstInstance;
    }
    @Override
    public IProductStorage getProductStorage() {
        return productStorage;
    }
}
