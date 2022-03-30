package dawid.naukaspring.spring5webapp.repositories;

import dawid.naukaspring.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
