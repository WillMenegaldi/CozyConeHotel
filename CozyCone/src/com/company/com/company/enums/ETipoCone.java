package com.company.com.company.enums;

public enum ETipoCone
{
    ConeSimples("Cone Simples"),
    ConeComVaranda("Cone com Varanda");

    private String descricao;

    private ETipoCone(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }
}
