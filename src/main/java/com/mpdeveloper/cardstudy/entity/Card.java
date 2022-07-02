package com.mpdeveloper.cardstudy.entity;

public class Card {
    private Integer id;
    private String titulo;
    private String conteudo;
    public Card() {
    }
    public Card(Integer id, String titulo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
}
