package com.company.decorators;

import com.company.abstracts.ShapeConeDecorator;
import com.company.interfaces.IShapeCone;

public class SpaSpace extends ShapeConeDecorator {
    public SpaSpace(IShapeCone decoratedIShapeCone) {
        super(decoratedIShapeCone);
    }

    @Override
    public double getPrecoDiaria() {
        return super.getPrecoDiaria() + 120D;
    }

    @Override
    public String toString() {
        return super.toString() + "     :: Espado de SPA! \n";
    }
}
