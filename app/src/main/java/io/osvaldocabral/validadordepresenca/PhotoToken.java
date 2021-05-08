package io.osvaldocabral.validadordepresenca;

import android.net.Uri;

public class PhotoToken {

    private String data;
    private String descricacao;
    private String photo;


    public PhotoToken() {
    }


    public PhotoToken(String data, String descricacao, String photo) {
        this.data = data;
        this.descricacao = descricacao;
        this.photo = photo;
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
