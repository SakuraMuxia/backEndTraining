package com.muxia.bookstore.dao;

import com.muxia.bookstore.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBookList();

    Book getBook(Integer bookId);
}
