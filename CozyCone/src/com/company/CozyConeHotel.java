package com.company;

public class CozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private CozyConeHotel() {}

    public static CozyConeHotel getHotel()
    {
        return cozyCone;
    }
}