package groupId.artifactId.storage.api;

import java.util.List;

public interface IEssenceStorage<TYPE> {
    List<TYPE> getEssences();

    TYPE getEssenceById(int id);

    void save(TYPE type);
}
