package com.company.com.company;

import com.company.com.company.enums.EStatus;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.models.Carro;
import com.company.com.company.utils.CozyConeHotel;
import com.company.com.company.utils.Menu;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.abstracts.*;

public class Main
{
    private static final int quantidadeCones = 10;
    private static final Menu menuDeOpcoes = new Menu();
    private static CozyConeHotel hotel = CozyConeHotel.getHotel();

    public static void main(String[] args)
    {
       menuDeOpcoes.menuAplicacao();
    }

    private static void realizarCheckOut(Carro carro)
    {
        hotel.realizarCheckOut(carro);
        hotel.notificarCarros();
    }

    private static void realizarCheckIn(Carro carro)
    {
        hotel.adicionarCarro(carro);

        if(CozyConeHotel.possuiVagasDisponiveis())
        {
            ICone cone = new Cone();
            cone.reservarCone(ETipoCone.CONE_COM_VARANDA);
            carro.setStatus(EStatus.Hospedado);
        }
        else
        {
            carro.setStatus(EStatus.EsperandoCheckIn);
            System.out.println("Todos os cones estao ocupados. Voce sera encaminhado para uma lista de espera.");
        }
    }
}
