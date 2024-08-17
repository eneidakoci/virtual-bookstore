package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.BookDto;
import com.bookstore.domain.dto.BookRequest;
import com.bookstore.domain.entity.BookEntity;
import org.springframework.stereotype.Component;


@Component
public class BookMapper {
    public static BookDto todto(BookEntity entity) {
        if (entity == null) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setAuthor(entity.getAuthor());
        bookDto.setId(entity.getId());
        bookDto.setCategoryId(entity.getCategoryId());
        bookDto.setIsbn(entity.getIsbn());
        bookDto.setPrice(entity.getPrice());
        bookDto.setDescription(entity.getDescription());
        bookDto.setTitle(entity.getTitle());
        bookDto.setPublishedDate(entity.getPublishedDate());
        bookDto.setPublisher(entity.getPublisher());

        return bookDto;
    }

    public BookEntity toEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setIsbn(bookDto.getIsbn());
        bookEntity.setDescription(bookDto.getDescription());
        bookEntity.setPrice(bookDto.getPrice());
        bookEntity.setCategoryId(bookDto.getCategoryId());
        bookEntity.setPublisher(bookDto.getPublisher());
        bookEntity.setPublishedDate(bookDto.getPublishedDate());
        return bookEntity;
    }

    public BookEntity updateEntityFromRequest(BookRequest bookRequest) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setAuthor(bookRequest.getAuthor());
        bookEntity.setIsbn(bookRequest.getIsbn());
        bookEntity.setDescription(bookRequest.getDescription());
        bookEntity.setPrice(bookRequest.getPrice());
        bookEntity.setCategoryId(bookRequest.getCategoryId());
        bookEntity.setPublishedDate(bookRequest.getPublishedDate());
        bookEntity.setPublisher(bookRequest.getPublisher());
        return bookEntity;
    }
}
