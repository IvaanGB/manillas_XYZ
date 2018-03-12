package manillas_xyz.com.manillas_xyz;

import android.widget.Spinner;

/**
 * Created by ivang on 12/3/2018.
 */

public class metodos {
    private Spinner material;



    public static int valorAPagar(int precio, int cantidad){ return precio*cantidad; }

    public static int valorCop(int precio, int cantidad){ return (precio*cantidad)*3200; }

}
