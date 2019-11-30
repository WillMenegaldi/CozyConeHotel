package tests;

import com.company.decorators.BreakFast;
import com.company.decorators.MiniFridge;
import com.company.decorators.SpaSpace;
import com.company.enums.ETipoCone;
import com.company.interfaces.IShapeCone;
import com.company.utils.ConeFactory;
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
        cone = factory.reservarCone(ETipoCone.CONE_SIMPLES);

        IShapeCone coneDecorado = new BreakFast(cone); // diaria480 + 20 do cafe
        Double esperado = 500D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addComponentConeVaranda(){
        cone = factory.reservarCone(ETipoCone.CONE_COM_VARANDA);

        IShapeCone coneDecorado = new MiniFridge(cone); // diaria480 + 20 do cafe
        Double esperado = 660D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addMoreComponentConeSimples(){
        cone = factory.reservarCone(ETipoCone.CONE_SIMPLES);

        IShapeCone coneDecorado = new BreakFast(cone); // diaria480 + 20 do cafe
        coneDecorado = new SpaSpace(coneDecorado);

        Double esperado = 620D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }

    @Test
    public void addMoreComponentConeVaranda(){
        cone = factory.reservarCone(ETipoCone.CONE_COM_VARANDA);

        IShapeCone coneDecorado = new MiniFridge(cone); // diaria480 + 20 do cafe
        coneDecorado = new SpaSpace(coneDecorado);

        Double esperado = 780D;
        Double encontrado = coneDecorado.getPrecoDiaria();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }
}
