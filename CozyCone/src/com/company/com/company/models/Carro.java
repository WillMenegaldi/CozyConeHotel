package com.company.com.company.models;

import com.company.com.company.enums.EStatus;
import com.company.interfaces.ICarro;

import java.util.UUID;

public class Carro implements ICarro
{
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

    public Carro(String modelo, String cor)
    {
        this.modelo = modelo;
        this.cor = cor;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public void update()
    {
        System.out.println("Pronto para ser hospedado em CozyCone.");
    }
}
