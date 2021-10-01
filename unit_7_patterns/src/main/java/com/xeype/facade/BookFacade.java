package com.xeype.facade;

import com.xeype.dto.BookRequestDto;
import com.xeype.dto.BookResponseDto;

import java.util.List;

public interface BookFacade {

    void create(BookRequestDto dto);
    void update(BookRequestDto dto, String id);
    void delete(String id);
    BookResponseDto findById(String id);
    List<BookResponseDto> findAll();
}
