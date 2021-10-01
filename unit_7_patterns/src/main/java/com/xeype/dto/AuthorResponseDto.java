package com.xeype.dto;

import com.xeype.entity.Author;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthorResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private List<String> bookIds = new ArrayList<>();


    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.birthDay = author.getBirthDay();
        this.bookIds = author.getBookIds();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public List<String> getBookIds() {return bookIds;}

}
