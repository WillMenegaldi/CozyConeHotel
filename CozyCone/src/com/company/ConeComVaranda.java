package com.company;

public class ConeComVaranda extends Cone
{
    public ConeComVaranda()
    {
        System.out.println("Cone com Varanda");
    }

    public Cone reservarCone()
    {
        return new ConeComVaranda();
    }
}
