package com.company.utils;

import com.company.models.Cone;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.models.ConeComVaranda;
import com.company.com.company.models.ConeSimples;

public class ConeFactory implements ICone
{
    @Override
    public Cone reservarCone(ETipoCone tipoCone)
    {
        switch (tipoCone)
        {
            case ConeSimples:
                return new ConeSimples();
            case ConeComVaranda:
                return new ConeComVaranda();
            default:
                return null;
        }
    }
}
