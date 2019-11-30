package com.company;

import com.company.interfaces.ICone;

public class Cone implements ICone
{
    @Override
    public Cone reservarCone(TipoCone tipoCone)
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
