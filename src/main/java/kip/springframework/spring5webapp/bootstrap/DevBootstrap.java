package kip.springframework.spring5webapp.bootstrap;

import kip.springframework.spring5webapp.model.Author;
import kip.springframework.spring5webapp.model.Book;
import kip.springframework.spring5webapp.repositories.AuthorRepository;
import kip.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Amon
        Author amon = new Author("Amon", "Kiprotich");
        Book ddd = new Book("Domain Driven Design", "12345", "Tech Books");
        amon.getBooks().add(ddd);
        ddd.getAuthors().add(amon);

        authorRepository.save(amon);
        bookRepository.save(ddd);

        //Daniel
        Author daniel = new Author("Daniel", "Smith");
        Book msp = new Book("Microservices Patterns", "54321", "Tech Republic");
        daniel.getBooks().add(msp);
        msp.getAuthors().add(daniel);

        authorRepository.save(daniel);
        bookRepository.save(msp);
    }
}
