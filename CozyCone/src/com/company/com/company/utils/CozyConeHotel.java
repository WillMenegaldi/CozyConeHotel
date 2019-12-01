package com.company.com.company.utils;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.abstracts.ShapeConeDecorator;
import com.company.com.company.decorators.PartyCone;
import com.company.com.company.decorators.*;
import com.company.com.company.enums.EStatus;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.com.company.interfaces.IShapeCone;
import com.company.com.company.models.Carro;
import com.company.interfaces.ICozyConeHotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CozyConeHotel implements ICozyConeHotel
{
    private static CozyConeHotel cozyCone = new CozyConeHotel();
    private static final int QUANTIDADE_TOTAL_CONES = 2;
    private static List<Carro> listaCarros = new ArrayList<Carro>();
    HashMap<String, IShapeCone> mapCarroCone = new HashMap<String, IShapeCone>();
    private static int quantidadeConesOcupados;

    private CozyConeHotel() {}

    public static CozyConeHotel getHotel()
    {
        return cozyCone;
    }

    private static List<Carro> obterCarrosPorStatus(EStatus status)
    {
        return listaCarros
            .stream()
            .filter(c -> c.getStatus().equals(status))
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
    } // '<=' pois o carro ja foi adicionado à lista

    public void realizarCheckIn(Carro carro, ETipoCone tipoCone)
    {
        if(CozyConeHotel.possuiVagasDisponiveis())
        {
            ICone cone = new ConeFactory();
            IShapeCone coneDecorator = cone.reservarCone(tipoCone);
            carro.setStatus(EStatus.Hospedado);

            IShapeCone coneDecorado = adicionarServicos(coneDecorator);
            mapCarroCone.put(carro.getId(), coneDecorado);

            System.out.println("\nCheckIn realizado com sucesso!\n");
        }
        else
        {
            carro.setStatus(EStatus.EsperandoCheckIn);
            System.out.println("\nTodos os cones estao ocupados. Voce sera encaminhado para uma lista de espera e notificado quando for sua vez.\n");
        }
    }

    public void realizarCheckOut()
    {
        Carro carro = obterCarroHospedadoAleatorio();

        for(Carro c : listaCarros)
            if(c.getId().equals(carro.getId()))
                c.setStatus(EStatus.CheckoutRealizado);

        getPartyCone(carro);
        notificarCarros();
    }

    public static Carro obterCarroHospedadoAleatorio()
    {
        List<Carro> carrosHospedados = obterCarrosPorStatus(EStatus.Hospedado);
        int posicao = (int) (Math.random() * carrosHospedados.size());

        return carrosHospedados.get(posicao);
    }

    @Override
    public void notificarCarros()
    {
        for(Carro carro : obterCarrosPorStatus(EStatus.EsperandoCheckIn))
        {
            carro.setStatus(EStatus.Hospedado);
            carro.update(carro.getModelo(), carro.getCor());
        }
    }

    private IShapeCone adicionarServicos(IShapeCone cone)
    {
        String resposta = "";
        System.out.println("\nDigite (Sim) para aceitar os acrescimos ou (Nao) para rejeitar");

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

    private void getPartyCone(Carro carro)
    {
        IShapeCone cone = new Cone();
        String resposta = "";
        IShapeCone coneDecorado = obterCone(carro);

        resposta = Menu.receberString("Digite (Sim) caso tenha dado uma festa ou (Nao) para caso não tenha realizado!");

        if(resposta.equalsIgnoreCase("Sim"))
        {
            int opcao = Menu.receberInt("Qual tipo de cone você está hospedado:\n1 - Cone Simples\n2 - Cone Com Varanda");

            if(opcao == 1)
                cone = new PartyCone(coneDecorado, ETipoCone.ConeSimples);
            else
                cone = new PartyCone(coneDecorado, ETipoCone.ConeComVaranda);
        }

        System.out.println("\nValor total da hospedagem: " + cone.getPrecoDiaria() + "\n");
    }

    private IShapeCone obterCone(Carro carro)
    {
        for (Map.Entry<String, IShapeCone> map : mapCarroCone.entrySet())
            if(map.getKey().equals(carro.getId()))
                return map.getValue();
        return null;
    }
}