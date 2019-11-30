package com.company;

import com.company.interfaces.ICone;

public class ConeSimples extends Cone implements ICone
{
    @Override
    public Cone criarCone(TipoCone tipoCone)
    {
        return new ConeSimples();
    }
}
