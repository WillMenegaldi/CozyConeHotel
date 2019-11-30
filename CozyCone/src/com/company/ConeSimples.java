package com.company;

public class ConeSimples extends Cone
{
    public Cone reservarCone()
    {
        return new ConeSimples();
    }
}
