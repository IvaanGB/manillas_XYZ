package manillas_xyz.com.manillas_xyz;

import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

import org.junit.Test;

import java.sql.Array;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class pruebas{

    @Test
    public void cueroMOro(){
        //Cuero-Martillo-Oro
        int precio=metodos.preciosCuero(1,1);
        assertEquals(100, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cueroMOR(){
        //Cuero-Martillo-Oro Rosa
        int precio=metodos.preciosCuero(1,2);
        assertEquals(100, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cueroMPlata(){
        //Cuero-Martillo-Plata
        int precio=metodos.preciosCuero(1,3);
        assertEquals(80, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cueroMNiquel(){
        //Cuero-Martillo-Niquel
        int precio=metodos.preciosCuero(1,4);
        assertEquals(70, metodos.valorAPagar(precio, 1));
    }


    @Test
    public void cueroAOro(){
        //Cuero-Ancla-Oro
        int precio=metodos.preciosCuero(2,1);
        assertEquals(120, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cueroAORosa(){
        //Cuero-Ancla-Oro Rosa
        int precio=metodos.preciosCuero(2,2);
        assertEquals(120, metodos.valorAPagar(precio, 1));
    }


    @Test
    public void cueroAPlata(){
        //Cuero-Ancla-Plata
        int precio=metodos.preciosCuero(2,3);
        assertEquals(100, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cueroANiquel(){
        //Cuero-Ancla-Niquel
        int precio=metodos.preciosCuero(2,4);
        assertEquals(90, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaMOro(){
        //Cuerda-Martillo-Oro
        int precio=metodos.preciosCuerda(1,1);
        assertEquals(90, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaMORosa(){
        //Cuerda-Martillo-Oro Rosa
        int precio=metodos.preciosCuerda(1,2);
        assertEquals(90, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaMPlata(){
        //Cuerda-Martillo-Plata
        int precio=metodos.preciosCuerda(1,3);
        assertEquals(70, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaMNiquel(){
        //Cuerda-Martillo-Niquel
        int precio=metodos.preciosCuerda(1,4);
        assertEquals(50, metodos.valorAPagar(precio, 1));
    }


    @Test
    public void cuerdaAOro(){
        //Cuerda-Ancla-Oro
        int precio=metodos.preciosCuerda(2,1);
        assertEquals(110, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaAORosa(){
        //Cuerda-Ancla-Oro Rosa
        int precio=metodos.preciosCuerda(2,2);
        assertEquals(110, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaAPlata(){
        //Cuerda-Ancla-Plata
        int precio=metodos.preciosCuerda(2,3);
        assertEquals(90, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaANiquel(){
        //Cuerda-Ancla-Niquel
        int precio=metodos.preciosCuerda(2,4);
        assertEquals(80, metodos.valorAPagar(precio, 1));
    }

    @Test
    public void cuerdaANiquelCOP(){
        int precio=metodos.preciosCuerda(2,4);
        assertEquals(256000, metodos.valorCop(metodos.valorAPagar(precio, 1)));
    }

    @Test
    public void cuerdaANiquelCOP2(){
        int precio=metodos.preciosCuerda(2,4);
        assertEquals(768000, metodos.valorCop(metodos.valorAPagar(precio, 3)));
    }
}