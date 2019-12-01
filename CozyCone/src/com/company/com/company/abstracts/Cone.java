package com.company.com.company.abstracts;

import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.ICone;
import com.company.interfaces.IShapeCone;

public class Cone implements IShapeCone, ICone
{
    private ETipoCone tipoCone;

    public ETipoCone getTipoCone()
    {
        return tipoCone;
    }

    @Override
    public double getPrecoDiaria()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "Tipo : " + this.getTipoCone().getDescricao() + "\nAdicionais :::: \n";
    }

    @Override
    public Cone reservarCone(ETipoCone ETipoCone) {
        return null;
    }
}
