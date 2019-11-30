package com.company.decorators;

import com.company.abstracts.ShapeConeDecorator;
import com.company.enums.ETipoCone;
import com.company.interfaces.IShapeCone;

import static com.company.enums.ETipoCone.CONE_COM_VARANDA;
import static com.company.enums.ETipoCone.CONE_SIMPLES;

public class PartyCone extends ShapeConeDecorator {
    private ETipoCone tipoCone;

    public PartyCone(IShapeCone decoratedIShapeCone) {
        super(decoratedIShapeCone);
    }

    public PartyCone(IShapeCone decoratedIShapeCone, ETipoCone tipoCone) {
        super(decoratedIShapeCone);
        this.tipoCone = tipoCone;
    }

    @Override
    public double getPrecoDiaria() {
        if(tipoCone == CONE_SIMPLES)
            return super.getPrecoDiaria() * 1.4D;
        if(tipoCone == CONE_COM_VARANDA)
            return super.getPrecoDiaria() * 1.3D;
        return super.getPrecoDiaria();
    }
    @Override
    public String toString() {
        return super.toString() + "Preço total : " + this.getPrecoDiaria();
    }
}
