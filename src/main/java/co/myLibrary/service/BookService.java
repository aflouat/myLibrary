/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary.service;

import co.myLibrary.model.Book;
import co.myLibrary.repository.IBookRepository;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author itpm
 */
@Data
@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository; 

    public Optional<Book> getBook(final Long id) {
        return bookRepository.findById(id);
    }
    
    public Book saveBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }
    public void deleteBook(final Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBookAttributes(Optional<Book> bookToUpdate, Book book) {
        Book currentBook = bookToUpdate.get();
        if(book.getTitle() != null) 
            currentBook.setTitle(book.getTitle());
        if(book.getYear() != 0)
            currentBook.setYear(book.getYear());
        
         return bookRepository.save(currentBook);
    }
    
   
    
}
