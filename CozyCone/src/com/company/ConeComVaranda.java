package com.company;

import com.company.interfaces.ICone;

public class ConeComVaranda extends Cone implements ICone
{
    @Override
    public Cone criarCone(TipoCone tipoCone) {
        return new ConeComVaranda();
    }
}
