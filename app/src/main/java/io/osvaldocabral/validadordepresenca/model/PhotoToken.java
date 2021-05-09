package io.osvaldocabral.validadordepresenca.model;

public class PhotoToken {

    private long id;
    private String data;
    private String descricacao;
    private String photo;


    public PhotoToken(long id, String data, String descricacao, String photo) {
        this.id = id;
        this.data = data;
        this.descricacao = descricacao;
        this.photo = photo;
    }


    public PhotoToken(String data, String descricacao, String photo) {
        this.data = data;
        this.descricacao = descricacao;
        this.photo = photo;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }


    public String getDescricacao() {
        return descricacao;
    }


    public void setDescricacao(String descricacao) {
        this.descricacao = descricacao;
    }


    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
