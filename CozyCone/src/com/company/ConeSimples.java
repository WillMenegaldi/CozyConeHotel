package com.company;

public class ConeSimples extends Cone
{
    public ConeSimples()
    {
        System.out.println("Cone Simples");
    }

    public Cone reservarCone()
    {
        return new ConeSimples();
    }
}
