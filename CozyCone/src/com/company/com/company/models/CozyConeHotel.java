package com.company.models;

import com.company.interfaces.IShapeCone;

import java.util.ArrayList;
import java.util.List;

public class CozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private List<IShapeCone> listaCones;
    private List listaEspera;

    private CozyConeHotel() {
        listaCones = new ArrayList<>();
    }

    public static CozyConeHotel getHotel()
    {
        return cozyCone;
    }

    public void addCone(IShapeCone cone){
        this.listaCones.add(cone);
    }

    public List<IShapeCone> getListaCones() {
        return listaCones;
    }
}