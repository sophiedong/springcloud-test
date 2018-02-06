package com.example;

import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.stereotype.Component;

@Component
public class HessianService {

    @Autowired
    private BookService bookService;

    @Bean("/hello/bookService")
    public HessianServiceExporter exporter(){
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(bookService);
        exporter.setServiceInterface(BookService.class);
        return exporter;
    }
}
