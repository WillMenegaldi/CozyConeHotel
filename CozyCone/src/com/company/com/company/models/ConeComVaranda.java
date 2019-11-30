package com.company.models;

import com.company.abstracts.Cone;
import com.company.enums.ETipoCone;

import static com.company.enums.ETipoCone.CONE_COM_VARANDA;

public class ConeComVaranda extends Cone
{
    public ConeComVaranda()
    {
        System.out.println("Cone com Varanda");
    }

    @Override
    public ETipoCone getTipoCone() {
        return CONE_COM_VARANDA;
    }

    @Override
    public double getPrecoDiaria() {
        return 620D;
    }
}
