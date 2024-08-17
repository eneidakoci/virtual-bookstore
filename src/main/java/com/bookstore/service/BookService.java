package com.bookstore.service;

import com.bookstore.domain.dto.BookDto;
import com.bookstore.domain.dto.BookRequest;
import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.UserEntity;

import java.util.List;

public interface BookService {
    BookDto createBook(BookRequest bookRequest);
    BookDto updateBook(Long id, BookDto bookDto);
    void deleteBook(Long id);
    BookDto getBookById(Long id);
    List<BookDto> getAllBooks();
    List<BookDto> searchBooksByTitle(String title);
}
