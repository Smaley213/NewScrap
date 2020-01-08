
create table BOOK (
    ID int not null,
    TITLE varchar(50) not null,
    COST real not null,
    primary key (ID)
);

create sequence BOOK_ID_SEQ START WITH 1 INCREMENT BY 1;
