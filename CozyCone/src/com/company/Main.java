package com.company;

import com.company.interfaces.ICone;

public class Main
{
    private static CozyConeHotel hotel = CozyConeHotel.getHotel();

    public static void main(String[] args)
    {
        Carro corsa = new Carro("corsa", "vermelho");
        Carro palio = new Carro("palio", "prata");
        Carro uno = new Carro("uno", "preto");
        Carro argo = new Carro("argo", "branco");

        realizarCheckIn(palio);
        realizarCheckIn(argo);
        realizarCheckIn(uno);
        realizarCheckIn(corsa);

        realizarCheckOut(palio);
        realizarCheckIn(corsa);
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
            cone.reservarCone(TipoCone.ConeComVaranda);
            carro.setStatus(Status.Hospedado);
        }
        else
        {
            carro.setStatus(Status.EsperandoCheckIn);
            System.out.println("Todos os cones estao ocupados. Voce sera encaminhado para uma lista de espera.");
        }
    }
}
