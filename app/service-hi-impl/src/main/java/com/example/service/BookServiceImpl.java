package com.example.service;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Override
    public Map<String, Book> getBooks() {
        Map<String, Book> map = new HashMap<String,Book>();
        map.put("wa",new Book("wa","moyan"));
        map.put("x",new Book("xyrx","dygw"));
        return map;
    }
}
