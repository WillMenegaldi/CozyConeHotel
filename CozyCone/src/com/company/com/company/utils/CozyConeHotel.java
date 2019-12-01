package com.company.com.company.utils;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.EStatus;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.models.Carro;
import com.company.interfaces.ICozyConeHotel;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CozyConeHotel implements ICozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static final int QUANTIDADE_TOTAL_CONES = 2;
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
            .filter(c -> c.getStatus().equals(EStatus.EsperandoCheckIn))
            .collect(Collectors.toList());
    }

    public void adicionarCarro(Carro carro)
    {
        carro.setStatus(EStatus.EsperandoCheckIn);
        listaCarros.add(carro);
        quantidadeConesOcupados++;
    }

    public static boolean possuiVagasDisponiveis()
    {
        return quantidadeConesOcupados <= QUANTIDADE_TOTAL_CONES;
    }

    public String realizarCheckOut(Carro carro)
    {
        for(Carro c : listaCarros)
        {
            if(c.getId().equals(carro.getId()))
                c.setStatus(EStatus.CheckoutRealizado);
        }
        notificarCarros();

        return "CheckOut realizado";
    }

    public String realizarCheckIn(Carro carro, ETipoCone tipoCone)
    {
        if(CozyConeHotel.possuiVagasDisponiveis())
        {
            ICone cone = new ConeFactory();
            cone.reservarCone(tipoCone);
            carro.setStatus(EStatus.Hospedado);

            return "CheckIn realizado com sucesso!";
        }
        else
        {
            carro.setStatus(EStatus.EsperandoCheckIn);
            return "Todos os cones estao ocupados. Voce sera encaminhado para uma lista de espera.";
        }
    }

    @Override
    public void notificarCarros()
    {
        List<Carro> carrosEmEspera = obterCarrosEmEspera();

        for(Carro carro : carrosEmEspera)
        {
            carro.setStatus(EStatus.Hospedado);
            carro.update();
        }
    }
}