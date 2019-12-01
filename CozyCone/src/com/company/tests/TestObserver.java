package tests;

import com.company.com.company.decorators.SpaSpace;
import com.company.com.company.models.Carro;
import com.company.com.company.models.ConeComVaranda;
import com.company.utils.CozyConeHotel;
import com.company.utils.Menu;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestObserver {

    Menu menu = new Menu();
    private static CozyConeHotel hotel = CozyConeHotel.getHotel();
    com.company.com.company.models.Carro carro;

    @Before
    public void setUp(){
        hotel = CozyConeHotel.getHotel();
        carro = new com.company.com.company.models.Carro(com.company.com.company.models.Carro.gerarModeloCarro(),
                com.company.com.company.models.Carro.gerarCorCarro());

    }

    @Test
    public void testHaVagas(){
        boolean esperado = true;
        boolean resultado = CozyConeHotel.possuiVagasDisponiveis();
        assertTrue(resultado, "Era esperado " + esperado + " mas resultou em " + resultado);
    }



    @Test
    public void testChechoutValido(){
        boolean esperado, resultado;
        populate();

        esperado = false;
        resultado = CozyConeHotel.possuiVagasDisponiveis();
        assertFalse(resultado, "Era esperado " + esperado + " resultou em " + resultado + " e notificou");

        esperado = true;
        hotel.realizarCheckOut();
        resultado = CozyConeHotel.possuiVagasDisponiveis();
        assertTrue(resultado, "Era esperado " + esperado + " resultou em " + resultado + " e notificou");
    }

    @Test
    public void testObserverInValido(){
        populate();

        boolean esperado = false;
        boolean resultado = CozyConeHotel.possuiVagasDisponiveis();
        assertFalse(resultado, "Era esperado " + esperado + " resultou em " + resultado + " e notificou");
    }

    public void populate(){
        Carro carro = new Carro();

        Map<String, com.company.com.company.interfaces.IShapeCone> list = CozyConeHotel.getCarrosCones();

        com.company.com.company.interfaces.IShapeCone cone = new SpaSpace(new ConeComVaranda());
        list.put(new Carro().getId(), cone);
        hotel.adicionarCarro(carro);
        list.put(new Carro().getId(), cone);
        hotel.adicionarCarro(carro);
        list.put(new Carro().getId(), cone);
        hotel.adicionarCarro(carro);
    }
}
