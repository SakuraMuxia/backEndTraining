package com.muxia.bookstore.service.impl;

import com.muxia.bookstore.dao.BookDao;
import com.muxia.bookstore.pojo.Book;
import com.muxia.bookstore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }
}
