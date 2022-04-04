package dawid.naukaspring.spring5webapp.bootstrap;

import dawid.naukaspring.spring5webapp.domain.Author;
import dawid.naukaspring.spring5webapp.domain.Book;
import dawid.naukaspring.spring5webapp.domain.Publisher;
import dawid.naukaspring.spring5webapp.repositories.AuthorRepository;
import dawid.naukaspring.spring5webapp.repositories.BookRepository;
import dawid.naukaspring.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("UKNOW Punblisher", "Kwiatowa 63", "Warsaw", "Mazowieckie", "10-010");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3243636554");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publisher: "+ publisherRepository.count());
        System.out.println("Publisher number of books: "+ publisher.getBooks().size());
        System.out.println(publisher);

    }
}
