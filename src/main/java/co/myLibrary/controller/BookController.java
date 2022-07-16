/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.controller;

import co.myLibrary.model.Book;
import co.myLibrary.service.BookService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author itpm
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/book/{id}")

    public Optional<Book> getBook(@PathVariable("id") Long id) {
        Optional<Book> book = bookService.getBook(id);
        return book;

    }

    @PutMapping("/book/{id}")

    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Optional<Book> bookToUpdate = bookService.getBook(id);
        if (bookToUpdate != null) {
            Book updatedBook = bookService.updateBookAttributes(bookToUpdate,book);
            return updatedBook;
        }
                  
        else return null;

    }
    
    @DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable("id") final Long id) {
		bookService.deleteBook(id);
	}

}
