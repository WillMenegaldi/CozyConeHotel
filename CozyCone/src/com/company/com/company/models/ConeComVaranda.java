package com.company.com.company.models;

import com.company.models.Cone;
import com.company.com.company.enums.ETipoCone;

public class ConeComVaranda extends Cone
{
    public ConeComVaranda()
    {
        System.out.println("Escolha Realizada: Cone com Varanda");
    }

    @Override
    public ETipoCone getTipoCone()
    {
        return ETipoCone.ConeComVaranda;
    }

    @Override
    public double getPrecoDiaria()
    {
        return 620D;
    }
}
