package com.company;

import java.util.List;

public class CozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static List listaCones;
    private static List listaEspera;

    private CozyConeHotel() {}

    public static CozyConeHotel getHotel()
    {
        return cozyCone;
    }
}