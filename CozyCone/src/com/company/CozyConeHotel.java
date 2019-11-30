package com.company;

import com.company.interfaces.ICozyConeHotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CozyConeHotel implements ICozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static final int QUANTIDADE_TOTAL_CONES = 1;
    private static List<Carro> listaCarros = new ArrayList<Carro>();
    private static int quantidadeConesOcupados;

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

    public void adicionarCarro(Carro carro)
    {
        carro.setStatus(Status.EsperandoCheckIn);
        listaCarros.add(carro);
        quantidadeConesOcupados++;
    }

    public static boolean possuiVagasDisponiveis()
    {
        return quantidadeConesOcupados <= QUANTIDADE_TOTAL_CONES;
    }

    public void realizarCheckOut(Carro carro)
    {
        for(Carro c : listaCarros)
        {
            if(c.getId().equals(carro.getId()));
                c.setStatus(Status.CheckoutRealizado);
        }
    }

    @Override
    public void notificarCarros()
    {
        List<Carro> carrosEspera = obterCarrosEmEspera();
        for(Carro carro : carrosEspera) {
            carro.setStatus(Status.Hospedado);
            carro.update();
        }
    }
}