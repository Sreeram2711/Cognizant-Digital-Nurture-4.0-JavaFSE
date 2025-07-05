package com.library.LibraryManagementt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
	public static void main(String[] args) {
        
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");

        
        BookService bookService = (BookService) context.getBean("bookService");

       
        bookService.addBook("The Pilgrim’s Progress by John Bunyan (1678)");
        bookService.addBook("Robinson Crusoe by Daniel Defoe (1719)");
        bookService.addBook("Gulliver’s Travels by Jonathan Swift (1726)");
    }
    }
