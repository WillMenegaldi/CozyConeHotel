package com.company;

import com.company.interfaces.ICarro;

public class Carro implements ICarro
{
    private String modelo;
    private String cor;
    private Status status;

    public String getModelo()
    {
        return modelo;
    }

    public String getCor()
    {
        return cor;
    }

    public Status getStatus()
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

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Carro(String modelo, String cor)
    {
        this.modelo = modelo;
        this.cor = cor;
    }

    @Override
    public void update()
    {
        status = Status.Hospedado;
    }
}
