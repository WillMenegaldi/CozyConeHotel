package com.company;

public class ConeComVaranda extends Cone
{
    public Cone reservarCone()
    {
        return new ConeComVaranda();
    }
}
