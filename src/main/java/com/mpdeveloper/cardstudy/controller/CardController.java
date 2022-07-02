package com.mpdeveloper.cardstudy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpdeveloper.cardstudy.entity.Card;
import com.mpdeveloper.cardstudy.model.CardRepository;

@RestController
@RequestMapping({"/api/v1/card"})
public class CardController {
    private CardRepository repository;

    public CardController(CardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @PostMapping
    public Card CreateCard(@RequestBody Card card){
        return repository.save(card);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Card card){
        return repository.findById(id)
        .map(e -> {
            e.setTitulo(card.getTitulo());
            e.setConteudo(card.getConteudo());
            Card update = repository.save(e);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return repository.findById(id)
        .map(e -> {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
