package co.myLibrary;

import co.myLibrary.model.Book;
import co.myLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class myLibraryApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(myLibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Book book = bookService.getBook();
        //System.out.println("MyLibrary with spring boot : " + book);

    }

}
