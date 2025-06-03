package com.group.libraryapp.dto.book.request;

public class BookRequest {

    private String name;
    private String type;

    public BookRequest(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
