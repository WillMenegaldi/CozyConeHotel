package com.company.abstracts;

import com.company.enums.ETipoCone;
import com.company.interfaces.IShapeCone;

public abstract class Cone implements IShapeCone {
    private ETipoCone tipoCone;

    protected Cone() {
    }

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
