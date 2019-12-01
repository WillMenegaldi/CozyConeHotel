package com.company.com.company.utils;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.models.ConeComVaranda;
import com.company.com.company.models.ConeSimples;

public class ConeFactory implements ICone
{
    @Override
    public Cone reservarCone(ETipoCone tipoCone) {
        switch (tipoCone)
        {
            case CONE_SIMPLES:
                return new ConeSimples();
            case CONE_COM_VARANDA:
                return new ConeComVaranda();
            default:
                return null;
        }
    }
}
