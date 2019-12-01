package com.company.com.company.models;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.ETipoCone;

public class ConeSimples extends Cone
{
    public ConeSimples()
    {
        System.out.println("Cone Simples");
    }

    @Override
    public ETipoCone getTipoCone() {
        return ETipoCone.CONE_SIMPLES;
    }

    @Override
    public double getPrecoDiaria() {
        return 480D;
    }
}
