package com.company.com.company.utils;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.decorators.PartyCone;
import com.company.com.company.decorators.*;
import com.company.com.company.enums.EStatus;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.interfaces.IShapeCone;
import com.company.com.company.models.Carro;
import com.company.interfaces.ICozyConeHotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CozyConeHotel implements ICozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static final int QUANTIDADE_TOTAL_CONES = 5;
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

    public void realizarCheckOut(Carro carro)
    {
        for(Carro c : listaCarros)
        {
            if(c.getId().equals(carro.getId()))
                c.setStatus(EStatus.CheckoutRealizado);
        }
        getPartyCone();
        System.out.println("CheckOut realizado");

        notificarCarros();
    }

    public void realizarCheckIn(Carro carro, ETipoCone tipoCone)
    {
        if(CozyConeHotel.possuiVagasDisponiveis())
        {
            ICone cone = new ConeFactory();
            IShapeCone coneDecorator = cone.reservarCone(tipoCone);
            carro.setStatus(EStatus.Hospedado);

            addComponentes(coneDecorator);

            System.out.println("CheckIn realizado com sucesso!");
        }
        else
        {
            carro.setStatus(EStatus.EsperandoCheckIn);
            System.out.println("Todos os cones estao ocupados. Voce sera encaminhado para uma lista de espera.");
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

    private IShapeCone addComponentes(IShapeCone cone)
    {
        String resposta = "";
        System.out.println("Digite (Sim) para aceitar os acrescimos ou (Nao) para rejeitar");

        resposta = Menu.receberString("Café da manhã:\t+ R$ 20,00 ?");

        if(resposta.equalsIgnoreCase("Sim"))
            cone = new BreakFast(cone);

        resposta = Menu.receberString("FrigoBar:\t+ R$ 40,00 ?");

        if(resposta.equalsIgnoreCase("Sim"))
            cone = new MiniFridge(cone);

        resposta = Menu.receberString("Espaço de SPA:\t+ R$ 120,00 ?");

        if(resposta.equalsIgnoreCase("Sim"))
            cone = new SpaSpace(cone);

        return cone;
    }

    private IShapeCone getPartyCone()
    {
        IShapeCone cone = new Cone();
        String resposta = "";

        resposta = Menu.receberString("Digite (Sim) caso tenha dado uma festa ou (Nao) para caso não tenha realizado!");

        if(resposta.equalsIgnoreCase("Sim"))
        {
            int opcao = Menu.receberInt("Qual tipo de cone você está hospedado:\n1 - Cone Simples\n2 - Cone Com Varandas");

            if(opcao == 1)
                cone = new PartyCone(cone, ETipoCone.ConeSimples);
            else
                cone = new PartyCone(cone, ETipoCone.ConeComVaranda);
        }
        return cone;
    }
}