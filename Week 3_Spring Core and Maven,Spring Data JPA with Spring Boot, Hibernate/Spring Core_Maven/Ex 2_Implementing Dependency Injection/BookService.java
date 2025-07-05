package com.library.LibraryManagementt;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBookRepository() {
        if (bookRepository != null) {
            System.out.println("BookRepository is injected successfully!!!!!!!!!");
        } else {
            System.out.println("BookRepository is not injected..............");
        }
    }
}
