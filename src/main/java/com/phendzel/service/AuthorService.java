package com.phendzel.service;

import com.jooq.example.public_.tables.Author;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final DSLContext create;

    @Autowired
    public AuthorService(DSLContext create) {
        this.create = create;
    }

    public List<Author> getAllAuthors() {
        return null;
    }

}
