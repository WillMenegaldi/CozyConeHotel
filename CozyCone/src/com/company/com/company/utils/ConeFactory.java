package com.company.utils;

import com.company.abstracts.Cone;
import com.company.enums.ETipoCone;
import com.company.interfaces.ITypeCone;
import com.company.models.ConeComVaranda;
import com.company.models.ConeSimples;

public class ConeFactory implements ITypeCone {
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
