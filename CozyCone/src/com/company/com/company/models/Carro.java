package com.company.com.company.models;

import com.company.com.company.enums.EStatus;
import com.company.interfaces.ICarro;

import java.util.*;

public class Carro implements ICarro
{
    private static List<String> modelos = Arrays.asList("Ferrari F8", "Porsche 911", "Lamborghini Veneno", "Lamborghini Veneno",
        "Bugatti Chiron Sport", "Mercedes Exelero", "Bugatti La Voiture Noire", "Aston Martin Valkyrie", "McLaren P1 GTR");
    private static List<String> cores = Arrays.asList("preto", "branco", "prata", "vermelho");
    private String modelo;
    private String cor;
    private EStatus status;
    private String id;

    public String getModelo()
    {
        return modelo;
    }

    public String getCor()
    {
        return cor;
    }

    public EStatus getStatus()
    {
        return status;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public void setCor(String cor)
    {
        this.cor = cor;
    }

    public void setStatus(EStatus status)
    {
        this.status = status;
    }

    public String getId()
    {
        return id;
    }

    public Carro(){}

    public Carro(String modelo, String cor)
    {
        this.modelo = modelo;
        this.cor = cor;
        this.id = UUID.randomUUID().toString();
    }

    public static String gerarModeloCarro()
    {
        int posicao = (int) (Math.random() * modelos.size());
        return modelos.get(posicao);
    }

    public static String gerarCorCarro()
    {
        int posicao = (int) (Math.random() * cores.size());
        return cores.get(posicao);
    }

    @Override
    public void update()
    {
        System.out.println("Pronto para ser hospedado em CozyCone.");
    }
}
