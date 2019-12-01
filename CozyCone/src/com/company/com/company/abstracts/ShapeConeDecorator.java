package com.company.com.company.abstracts;

import com.company.com.company.interfaces.IShapeCone;

public abstract class ShapeConeDecorator implements IShapeCone
{
    protected IShapeCone decoratedIShapeCone;

    public ShapeConeDecorator(){}

    public ShapeConeDecorator(IShapeCone decoratedIShapeCone)
    {
        this.decoratedIShapeCone = decoratedIShapeCone;
    }

    public double getPrecoDiaria()
    {
        return decoratedIShapeCone.getPrecoDiaria();
    }

    @Override
    public String toString()
    {
        return decoratedIShapeCone + "";
    }
}
