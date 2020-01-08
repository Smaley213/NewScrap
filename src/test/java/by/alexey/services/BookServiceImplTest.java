package by.alexey.services;

import by.alexey.dto.BookDto;
import by.alexey.mappers.BookMapper;
import by.alexey.persistance.dao.BookRepository;
import by.alexey.persistance.entities.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @Mock
    private BookRepository bookRepositoryMock;

    @Mock
    private BookMapper bookMapperMock;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void create() {
    }

    @Test
    public void get() {
        final Long ID = 123L;
        final Book book = new Book();
        final BookDto bookDto = new BookDto();
        Optional<Book> optionalBook = Optional.of(book);
        Mockito.when(bookRepositoryMock.findById(ID)).thenReturn(optionalBook);
        Mockito.when(bookMapperMock.toBookDto(book)).thenReturn(bookDto);

        BookDto result = bookService.get(ID);

        Mockito.verify(bookRepositoryMock).findById(ID);
        Mockito.verify(bookMapperMock).toBookDto(book);
        assertThat(result, is(bookDto));
    }

    @Test
    public void getAbsentBook() {
        // TODO: add test
    }

    @Test
    void update() {
        // TODO: add test
    }

    @Test
    void updateAbsentBook() {
        // TODO: add test
    }

    @Test
    void delete() {
        // TODO: add test
    }

    @Test
    void deleteAbsentBook() {
        // TODO: add test
    }

    @Test
    void getAll() {
        // TODO: add test
    }
}
