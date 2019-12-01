package tests;

import com.company.interfaces.ICozyConeHotel;
import com.company.utils.CozyConeHotel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSingleton {

    private ICozyConeHotel hotel  = null;

    @Before
    public void setUp(){
        hotel = CozyConeHotel.getHotel();
    }

    @Test
    public void testInstanciaVálida(){
        String esperado = null;
        String encontrado = hotel.toString();
        assertEquals(esperado, encontrado, "O valor esperado era " + esperado + " e foi encontrado " + encontrado);
    }
}
