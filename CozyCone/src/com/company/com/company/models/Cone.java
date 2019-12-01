package com.company.models;

import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.IShapeCone;

public class Cone implements IShapeCone {
    private ETipoCone tipoCone;

    public ETipoCone getTipoCone() {
        return tipoCone;
    }

    @Override
    public double getPrecoDiaria() {
        return 0;
    }

    @Override
    public String toString() {
        return "Tipo : " + this.getTipoCone().getDescricao() + "\nAdicionais :::: \n";
    }
}
