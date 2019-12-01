package com.company.com.company.decorators;

import com.company.abstracts.ShapeConeDecorator;
import com.company.com.company.enums.ETipoCone;
import com.company.interfaces.IShapeCone;

public class PartyCone extends ShapeConeDecorator
{
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
        if(tipoCone == ETipoCone.CONE_SIMPLES)
            return super.getPrecoDiaria() * 1.4D;
        if(tipoCone == ETipoCone.CONE_COM_VARANDA)
            return super.getPrecoDiaria() * 1.3D;
        return super.getPrecoDiaria();
    }
    @Override
    public String toString() {
        return super.toString() + "Preço total : " + this.getPrecoDiaria();
    }
}
