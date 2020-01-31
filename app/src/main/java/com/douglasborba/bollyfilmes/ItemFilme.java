package com.douglasborba.bollyfilmes;

import java.net.URI;

public class ItemFilme {

    private String id;
    private String titulo;
    private String descricao;
    private String dataLancamento;
    private URI imagem;
    private float avaliacao;

    public ItemFilme(String titulo, String descricao, String dataLancamento, float avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.avaliacao = avaliacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public URI getImagem() {
        return imagem;
    }

    public void setImagem(URI imagem) {
        this.imagem = imagem;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
}
