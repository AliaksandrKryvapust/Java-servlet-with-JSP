package groupId.artifactId.storage.api;

import java.util.List;
import java.util.Optional;

public interface IEssenceStorage<TYPE> {
    List<TYPE> get();

    Optional<TYPE> getById(int id);

    void save(TYPE type);
}
