package groupId.artifactId.service.api;

import java.util.List;

public interface IEEssenceService<TYPE> {
    List<TYPE> get();
    TYPE get(int id);
    void validate(TYPE item);
}
