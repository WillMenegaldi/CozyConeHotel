package com.company.com.company.decorators;

import com.company.com.company.abstracts.ShapeConeDecorator;
import com.company.com.company.interfaces.IShapeCone;

public class BreakFast extends ShapeConeDecorator
{
    public BreakFast(IShapeCone decoratedIShapeCone)
    {
        super(decoratedIShapeCone);
    }

    @Override
    public double getPrecoDiaria()
    {
        return super.getPrecoDiaria() + 20D;
    }

    @Override
    public String toString()
    {
        return super.toString() + "     :: Café da manhã!\n";
    }
}
