package com.mpdeveloper.cardstudy.controller;

import java.util.List;
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
import com.mpdeveloper.cardstudy.service.CardService;

@RestController
@RequestMapping({"/api/v1/card"})
public class CardController {
    private CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping
    public List<Card> findAll(){
        return service.getALL();
    }

    @PostMapping
    public Card CreateCard(@RequestBody Card card){
        return service.Create(card);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Card card){
        return service.update(id, card);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
