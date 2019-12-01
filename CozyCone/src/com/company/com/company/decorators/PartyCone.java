package com.company.com.company.decorators;

import com.company.com.company.abstracts.ShapeConeDecorator;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.IShapeCone;

public class PartyCone extends ShapeConeDecorator
{
    private ETipoCone tipoCone;

    public PartyCone(IShapeCone decoratedIShapeCone)
    {
        super(decoratedIShapeCone);
    }

    public PartyCone(IShapeCone decoratedIShapeCone, ETipoCone tipoCone)
    {
        super(decoratedIShapeCone);
        this.tipoCone = tipoCone;
    }

    @Override
    public double getPrecoDiaria()
    {
        switch (tipoCone)
        {
            case ConeSimples:
                return (super.getPrecoDiaria() * 1.4D);
            case ConeComVaranda:
                return (super.getPrecoDiaria() * 1.3D);
            default:
                return super.getPrecoDiaria();
        }
    }
    @Override
    public String toString()
    {
        return super.toString() + "Preço total : " + this.getPrecoDiaria();
    }
}
