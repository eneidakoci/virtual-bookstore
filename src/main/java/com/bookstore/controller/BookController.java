package com.bookstore.controller;

import com.bookstore.domain.dto.BookDto;
import com.bookstore.domain.dto.BookRequest;
import com.bookstore.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks() {
        List<BookDto> bookDtos = bookService.getAllBooks();
        if (bookDtos == null) {
            throw new EntityNotFoundException("Books not found.");
        }
        return ResponseEntity.ok(bookDtos);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findBookById(@PathVariable Long bookId) {
        BookDto bookDto = bookService.getBookById(bookId);
        if (bookDto != null) {
            return ResponseEntity.ok(bookDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookDto> createComment(@RequestBody BookRequest bookRequest) {
        BookDto createdBook = bookService.createBook(bookRequest);
        if (createdBook != null) {
            URI locationOfCreatedBook = URI.create("/api/books/" + createdBook.getId());
            return ResponseEntity.created(locationOfCreatedBook).body(createdBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId,
                                              @RequestBody BookDto bookDto) {
        BookDto updatedBook = bookService.updateBook(bookId, bookDto);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

}
