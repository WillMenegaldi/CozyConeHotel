package com.company.com.company.models;

import com.company.models.Cone;
import com.company.com.company.enums.ETipoCone;

public class ConeSimples extends Cone
{
    public ConeSimples()
    {
        System.out.println("Escolha Realizada: Cone Simples");
    }

    @Override
    public ETipoCone getTipoCone() {
        return ETipoCone.ConeSimples;
    }

    @Override
    public double getPrecoDiaria() {
        return 480D;
    }
}
