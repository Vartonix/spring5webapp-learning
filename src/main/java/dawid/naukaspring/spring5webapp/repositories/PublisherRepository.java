package dawid.naukaspring.spring5webapp.repositories;

import dawid.naukaspring.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
