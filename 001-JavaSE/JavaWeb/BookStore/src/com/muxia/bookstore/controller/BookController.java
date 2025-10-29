package com.muxia.bookstore.controller;

import com.muxia.bookstore.pojo.Book;
import com.muxia.bookstore.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

public class BookController {
    private BookService bookService ;
    public String list(HttpSession session){
        // 获取图书列表
        List<Book> bookList = bookService.getBookList();
        // 把数据放在session中
        session.setAttribute("bookList",bookList);
        System.out.println("list方法执行了");
        return "index";
    }
}
