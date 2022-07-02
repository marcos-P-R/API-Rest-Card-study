package com.mpdeveloper.cardstudy.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpdeveloper.cardstudy.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{
    
}
