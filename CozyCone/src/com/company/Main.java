package com.company;

import com.company.interfaces.ICone;

public class Main
{
    private static final int quantidadeCones = 10;

    public static void main(String[] args)
    {
        CozyConeHotel hotel = CozyConeHotel.getHotel();

        ICone cone = new Cone();
        cone.reservarCone(TipoCone.ConeSimples);
        System.out.println("--------------");
        cone.reservarCone(TipoCone.ConeComVaranda);
    }
}
