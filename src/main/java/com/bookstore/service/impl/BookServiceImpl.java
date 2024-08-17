package com.bookstore.service.impl;

import com.bookstore.domain.dto.BookDto;
import com.bookstore.domain.dto.BookRequest;
import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.mapper.BookMapper;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto createBook(BookRequest bookRequest) {
        BookEntity bookEntity = bookMapper.updateEntityFromRequest(bookRequest);
        bookEntity = bookRepository.save(bookEntity);
        return BookMapper.todto(bookEntity);
    }


//    @Override
//    public BookDto updateBook(Long id, BookDto bookDto) {
//        BookEntity existingBook = bookRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
//
//        bookMapper.toEntity(bookDto);
//        BookEntity updatedBook = bookRepository.save(existingBook);
//        return BookMapper.todto(updatedBook);
//    }
    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Optional<BookEntity> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            BookEntity existingBook = bookOptional.get();
            existingBook.setTitle(bookDto.getTitle());
            BookEntity updatedCategory = bookRepository.save(existingBook);
            return BookMapper.todto(updatedCategory);
        } else {
            return null;
        }
    }
    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public BookDto getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
        return BookMapper.todto(bookEntity);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return bookEntities.stream()
                .map(BookMapper::todto)
                .toList();
    }

    @Override
    public List<BookDto> searchBooksByTitle(String title) {
        List<BookEntity> bookEntities = bookRepository.findByTitleContaining(title);
        return bookEntities.stream()
                .map(BookMapper::todto)
                .toList();
    }
}
