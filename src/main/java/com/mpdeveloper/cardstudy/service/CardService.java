package com.mpdeveloper.cardstudy.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mpdeveloper.cardstudy.entity.Card;
import com.mpdeveloper.cardstudy.model.CardRepository;

@Service
public class CardService {
    private CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List getALL(){
        return repository.findAll();
    }

    public Card Create(@RequestBody Card card){
        return repository.save(card);
    }

    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Card card){
        return repository.findById(id)
        .map(e -> {
            e.setTitulo(card.getTitulo());
            e.setConteudo(card.getConteudo());
            Card update = repository.save(e);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity delete(@PathVariable Integer id){
        return repository.findById(id)
        .map(e -> {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
