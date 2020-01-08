package by.alexey.mappers;

import by.alexey.dto.BookDto;
import by.alexey.persistance.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {
    BookDto toBookDto(Book book);

    List<BookDto> toBookDtos(List<Book> books);

    Book toBook(BookDto bookDto);

}
