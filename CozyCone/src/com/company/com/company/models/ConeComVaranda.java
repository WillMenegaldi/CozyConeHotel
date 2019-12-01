package com.company.com.company.models;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.ETipoCone;

public class ConeComVaranda extends Cone
{
    public ConeComVaranda()
    {
        System.out.println("Cone com Varanda");
    }

    @Override
    public ETipoCone getTipoCone() {
        return ETipoCone.CONE_COM_VARANDA;
    }

    @Override
    public double getPrecoDiaria() {
        return 620D;
    }
}
