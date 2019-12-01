package tests;

import com.company.com.company.abstracts.Cone;
import com.company.com.company.enums.ETipoCone;
import com.company.com.company.utils.ConeFactory;
import org.junit.Before;
import org.junit.Test;

import static com.company.com.company.enums.ETipoCone.CONE_COM_VARANDA;
import static com.company.com.company.enums.ETipoCone.CONE_SIMPLES;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFactory {
    private static final ConeFactory factory = new ConeFactory();
    private static Cone cone;

    @Before
    public void setUp(){
    }

    @Test
    public void createConeSimples(){
        helper(CONE_SIMPLES);
    }

    @Test
    public void createConeComVaranda(){
        helper(CONE_COM_VARANDA);
    }

    private void helper(ETipoCone tipo){
        this.cone = factory.reservarCone(tipo);
        ETipoCone esperado = tipo ;
        ETipoCone encontrado = cone.getTipoCone();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado.getDescricao() + " e foi encontrado " + encontrado.getDescricao());
    }
}
