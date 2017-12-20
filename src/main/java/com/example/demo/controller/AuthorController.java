package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Review;
import com.example.demo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authors")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthorController {

    private final AuthorRepository repository;

    @RequestMapping(method = RequestMethod.PUT)
    public void update() {
        Author author = new Author();
        author.setName("Kathy Sierra");

        author = repository.save(author);

        Book book = new Book();
        book.setAuthor(author);
        book.setTitle("Head First Java");
        author.getBooks().add(book);

        Review review = new Review();
        review.setDescription("It's fast, irreverent, fun and engaging!");
        review.setBook(book);

        book.getReviews().add(review);

        repository.save(author);
    }
}
