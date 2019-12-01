package com.company.com.company.enums;

public enum ETipoCone
{
    CONE_SIMPLES("Cone Simples"),
    CONE_COM_VARANDA("Cone com Varanda");

    private String descricao;
    private ETipoCone(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
