package by.alexey.services;

import by.alexey.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto create(BookDto articleDto);

    BookDto get(Long id);

    void update(Long id, BookDto articleUpdateDto);

    void delete(Long id);

    List<BookDto> getAll();
}
