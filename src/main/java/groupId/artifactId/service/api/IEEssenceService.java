package groupId.artifactId.service.api;

import java.util.List;
import java.util.Optional;

public interface IEEssenceService<TYPE> {
    List<TYPE> getById();
    Optional<TYPE> getById(int id);

}
