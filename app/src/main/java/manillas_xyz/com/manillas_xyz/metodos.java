package manillas_xyz.com.manillas_xyz;

import android.content.res.Resources;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by ivang on 12/3/2018.
 */

public class metodos {


    public static int valorAPagar(int precio, int cantidad){ return precio*cantidad; }
    public static int valorCop(int pr){ return pr*3200; }

    public static TextView errorSpinner(Spinner spinner, String error) {
        TextView errorText = (TextView) spinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(error);
        return errorText;
    }

    public static boolean validarSpinner(Spinner spinner, String error){
        if (spinner.getSelectedItemPosition() == 0) {
            spinner.requestFocus();
            errorSpinner(spinner, error);
            return false;
        }
        return true;
    }

    public static int preciosCuero(int posicionDije, int posicionTipo) {
        int precios = 0;
        if (posicionDije == 1) {
            if (posicionTipo == 1 || posicionTipo == 2) {
                precios = 100;
            }
            if (posicionTipo == 3) {
                precios = 80;
            }
            if (posicionTipo == 4) {
                precios = 70;
            }
        }

        if (posicionDije == 2) {
            if (posicionTipo == 1 || posicionTipo == 2) {
                precios = 120;
            }
            if (posicionTipo == 3) {
                precios = 100;
            }
            if (posicionTipo == 4) {
                precios = 90;
            }
        }
        return precios;
    }

    public static int preciosCuerda(int posicionDije, int posicionTipo) {
        int precios = 0;
        if ( posicionDije == 1) {
            if (posicionTipo == 1 || posicionTipo == 2) {
                precios = 90;
            }

            if (posicionTipo == 3) {
                precios = 70;
            }
            if (posicionTipo == 4) {
                precios = 50;
            }
        }

        if (posicionDije == 2) {
            if (posicionTipo == 1 || posicionTipo == 2) {
                precios = 110;
            }
            if (posicionTipo == 3) {
                precios = 90;
            }
            if (posicionTipo == 4) {
                precios = 80;
            }
        }
        return precios;
    }

}
