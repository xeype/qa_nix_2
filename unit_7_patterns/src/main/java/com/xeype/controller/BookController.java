package com.xeype.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.xeype.dto.BookRequestDto;
import com.xeype.dto.BookResponseDto;
import com.xeype.dto.ResponseContainer;
import com.xeype.facade.BookFacade;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookFacade bookFacade;

    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody BookRequestDto dto) {
        bookFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody BookRequestDto dto, @PathVariable String id) {
        bookFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        bookFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<BookResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(bookFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<BookResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(bookFacade.findAll()));
    }
}