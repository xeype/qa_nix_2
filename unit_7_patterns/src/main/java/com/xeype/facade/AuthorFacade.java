package com.xeype.facade;

import com.xeype.dto.AuthorRequestDto;
import com.xeype.dto.AuthorResponseDto;

import java.util.List;

public interface AuthorFacade {

    void create(AuthorRequestDto dto);
    void update(AuthorRequestDto dto, String id);
    void delete(String id);
    AuthorResponseDto findById(String id);
    List<AuthorResponseDto> findAll();
}
