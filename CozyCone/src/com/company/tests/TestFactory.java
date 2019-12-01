package tests;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.utils.ConeFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactory {
    private static final ConeFactory factory = new ConeFactory();
    private static Cone cone;

    @Before
    public void setUp(){
    }

    @Test
    public void createConeSimples(){
        helper(ETipoCone.ConeSimples);
    }

    @Test
    public void createConeComVaranda(){
        helper(ETipoCone.ConeComVaranda);
    }

    private void helper(ETipoCone tipo){
        this.cone = factory.reservarCone(tipo);
        ETipoCone esperado = tipo ;
        ETipoCone encontrado = cone.getTipoCone();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado.getDescricao() + " e foi encontrado " + encontrado.getDescricao());
    }
}
