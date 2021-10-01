package com.xeype.controller;

import com.xeype.dto.ResponseContainer;
import com.xeype.dto.AuthorRequestDto;
import com.xeype.dto.AuthorResponseDto;
import com.xeype.facade.AuthorFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class AuthorController {

    private final AuthorFacade authorFacade;

    public AuthorController(AuthorFacade authorFacade) {
        this.authorFacade = authorFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody AuthorRequestDto dto) {
        authorFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody AuthorRequestDto dto, @PathVariable String id) {
        authorFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        authorFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<AuthorResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(authorFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<AuthorResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(authorFacade.findAll()));
    }
}
