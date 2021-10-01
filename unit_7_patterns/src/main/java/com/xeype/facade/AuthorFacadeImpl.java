package com.xeype.facade;

import com.xeype.dto.AuthorRequestDto;
import com.xeype.dto.AuthorResponseDto;
import com.xeype.entity.Author;
import com.xeype.service.AuthorService;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorFacadeImpl implements AuthorFacade {

    private final AuthorService authorService;

    public AuthorFacadeImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void create(AuthorRequestDto dto) {
        createOrUpdate(dto, null);
    }

    @Override
    public void update(AuthorRequestDto dto, String id) {
        createOrUpdate(dto, id);
    }

    @Override
    public void delete(String id) {
        authorService.delete(id);
    }

    @Override
    public AuthorResponseDto findById(String id) {
        return new AuthorResponseDto(authorService.findById(id));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        List<Author> authors = authorService.findAll();
        List<AuthorResponseDto> dtoList = new ArrayList<>();
        for (Author author: authors) {
            dtoList.add(new AuthorResponseDto(author));
        }
        return dtoList;
    }

    private void createOrUpdate(AuthorRequestDto dto, String id) {
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setBirthDay(dto.getBirthDay());
        if (id == null) {
            authorService.create(author);
        } else {
            author.setId(id);
            authorService.update(author);
        }
    }
}
//        User user = User.newUser()
//                .setFirstName(dto.getFirstName())
//                .setLastName(dto.getLastName())
//                .setEmail(dto.getEmail())
//                .setBirthDay(dto.getBirthDay())
//                .build();
