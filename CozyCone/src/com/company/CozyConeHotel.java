package com.company;

import com.company.interfaces.ICozyConeHotel;

import java.util.List;
import java.util.stream.Collectors;

public class CozyConeHotel implements ICozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static List<Carro> listaCarros;
    private static final int QUANTIDADE_CONES = 10;

    private CozyConeHotel() {}

    public static CozyConeHotel getHotel()
    {
        return cozyCone;
    }

    private static List<Carro> obterCarrosEmEspera()
    {
        return listaCarros
            .stream()
            .filter(c -> c.getStatus().equals(Status.EsperandoCheckIn))
            .collect(Collectors.toList());
    }

    @Override
    public void notificarCarros()
    {
        for(Carro carro : obterCarrosEmEspera()) {
            carro.setStatus(Status.Hospedado);
            carro.update();
        }
    }
}