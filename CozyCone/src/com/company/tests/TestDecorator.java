package com.company.tests;

import com.company.com.company.decorators.BreakFast;
import com.company.com.company.decorators.MiniFridge;
import com.company.com.company.decorators.SpaSpace;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.interfaces.IShapeCone;
import com.company.com.company.utils.ConeFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDecorator {

    private static final ConeFactory factory = new ConeFactory();
    private static IShapeCone cone = null;

    @Before
    public void setUp(){
    }

    @Test
    public void addComponentConeSimples(){
        cone = factory.reservarCone(ETipoCone.ConeSimples);

        IShapeCone coneDecorado = new BreakFast(cone); // diaria480 + 20 do cafe
        Double esperado = 500D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addComponentConeVaranda(){
        cone = factory.reservarCone(ETipoCone.ConeComVaranda);

        IShapeCone coneDecorado = new MiniFridge(cone); // diaria480 + 20 do cafe
        Double esperado = 660D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addMoreComponentConeSimples(){
        cone = factory.reservarCone(ETipoCone.ConeSimples);

        IShapeCone coneDecorado = new BreakFast(cone); // diaria480 + 20 do cafe
        coneDecorado = new SpaSpace(coneDecorado);

        Double esperado = 620D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addMoreComponentConeVaranda(){
        cone = factory.reservarCone(ETipoCone.ConeComVaranda);

        IShapeCone coneDecorado = new MiniFridge(cone); // diaria480 + 20 do cafe
        coneDecorado = new SpaSpace(coneDecorado);

        Double esperado = 780D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }
}
