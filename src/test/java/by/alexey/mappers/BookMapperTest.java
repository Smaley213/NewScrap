package by.alexey.mappers;

import by.alexey.dto.BookDto;
import by.alexey.persistance.entities.Book;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BookMapperTest {

    private BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @Test
    void toBookDto() {
        Book book = buildBook();

        BookDto bookDto = mapper.toBookDto(book);
        checkCompareAssertions(bookDto, book);
    }

    @Test
    void toBookDtos() {
        // TODO: add test
    }

    @Test
    void toBook() {
        // TODO: add test
    }

    private Book buildBook() {
        Book book = new Book();
        book.setId(1235L);
        book.setTitle("Kolobok");
        book.setCost(25.5);
        return book;
    }

    private void checkCompareAssertions(BookDto bookDto, Book book) {
        assertThat("Wrong id", bookDto.getId(), is(book.getId()));
        assertThat("Wrong title", bookDto.getTitle(), is(book.getTitle()));
        assertThat("Wrong cost", bookDto.getCost(), is(book.getCost()));
    }
}
