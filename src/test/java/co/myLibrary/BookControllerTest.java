/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.myLibrary;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import co.myLibrary.controller.BookController;
import co.myLibrary.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;



/**
 *
 * @author itpm
 */
@WebMvcTest(controllers = BookController.class)

public class BookControllerTest {
    
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books"))
            .andExpect(status().isOk());
        /*
        mockMvc.perform(get("/books"))
            .andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(1)) );
        */
    }

}
    
