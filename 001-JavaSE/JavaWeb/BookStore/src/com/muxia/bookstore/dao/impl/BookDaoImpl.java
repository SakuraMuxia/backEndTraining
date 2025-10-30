package com.muxia.bookstore.dao.impl;

import com.muxia.bookstore.dao.BookDao;
import com.muxia.bookstore.myssm.dao.BaseDao;
import com.muxia.bookstore.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book");
    }

    @Override
    public Book getBook(Integer bookId) {
        return load("select * from t_book where id = ? " , bookId);
    }
}
