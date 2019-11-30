package com.company.models;

import com.company.abstracts.Cone;
import com.company.enums.ETipoCone;

import static com.company.enums.ETipoCone.CONE_SIMPLES;

public class ConeSimples extends Cone
{
    public ConeSimples()
    {
        System.out.println("Cone Simples");
    }

    @Override
    public ETipoCone getTipoCone() {
        return CONE_SIMPLES;
    }

    @Override
    public double getPrecoDiaria() {
        return 480D;
    }
}
