package by.alexey.services;

import by.alexey.dto.BookDto;
import by.alexey.mappers.BookMapper;
import by.alexey.persistance.dao.BookRepository;
import by.alexey.persistance.entities.Book;
import by.alexey.services.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto create(BookDto bookDto) {
        Book entity = bookMapper.toBook(bookDto);
        Book savedEntity = bookRepository.save(entity);
        return bookMapper.toBookDto(savedEntity);
    }

    @Override
    public BookDto get(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toBookDto)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void update(Long id, BookDto articleUpdateDto) {
        // TODO: finish it
    }

    @Override
    public void delete(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new BookNotFoundException(id);
        }
    }

    @Override
    public List<BookDto> getAll() {
        Iterable<Book> books = bookRepository.findAll();
        List<Book> booksList = new ArrayList<>();
        books.iterator().forEachRemaining(booksList::add);

        // need to map list of books -> list of bookDtos and return it
        return bookMapper.toBookDtos(booksList);
    }
}
 