package com.muxia.bookstore.service;

import com.muxia.bookstore.pojo.Book;

import java.util.List;

public interface BookService {
    // 获取图书列表
    List<Book> getBookList();
    // 根据 图书Id获取 图书
    Book getBook(Integer bookId);
}
