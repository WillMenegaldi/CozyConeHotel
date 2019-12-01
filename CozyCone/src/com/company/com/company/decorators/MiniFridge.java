package com.company.com.company.decorators;

import com.company.com.company.abstracts.ShapeConeDecorator;
import com.company.com.company.interfaces.IShapeCone;

public class MiniFridge extends ShapeConeDecorator {
    public MiniFridge(IShapeCone decoratedIShapeCone) {
        super(decoratedIShapeCone);
    }

    @Override
    public double getPrecoDiaria() {
        return super.getPrecoDiaria() + 40D;
    }

    @Override
    public String toString() {
        return super.toString() + "     :: FrigoBar! \n";
    }
}
