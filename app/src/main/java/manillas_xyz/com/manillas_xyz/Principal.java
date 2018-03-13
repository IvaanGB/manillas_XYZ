package manillas_xyz.com.manillas_xyz;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;

import org.w3c.dom.Text;


public class Principal extends AppCompatActivity {
    private TextView resultado;
    private EditText cantidad;
    private Resources recursos;
    private Spinner material, dije, tipo;
    private String opMat[], opDije[], opTipo[];
    private RadioButton usd, cop;
    private RadioGroup moneda;
    private Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidad = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.lblTotal);
        material = findViewById(R.id.cmbMaterial);
        dije = findViewById(R.id.cmbDije);
        tipo = findViewById(R.id.cmbTipo);
        usd = findViewById(R.id.rdUSD);
        cop = findViewById(R.id.rdCOP);
        boton = findViewById(R.id.btnCalcular);
        moneda = findViewById(R.id.rgMoneda);

        recursos = this.getResources();

        opMat = recursos.getStringArray(R.array.materiales);
        ArrayAdapter<String> mat = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opMat);
        material.setAdapter(mat);


        opDije = recursos.getStringArray(R.array.dije);
        ArrayAdapter<String> dij = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opDije);
        dije.setAdapter(dij);


        opTipo = recursos.getStringArray(R.array.tipo);
        ArrayAdapter<String> tip = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opTipo);
        tipo.setAdapter(tip);
    }

    public TextView errorSpinner(Spinner spinner, String error) {
        TextView errorText = (TextView) spinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(error);
        return errorText;
    }

    

    public boolean validar() {
        if (!metodos.validarSpinner(material, recursos.getString(R.string.errorMaterial))){
            return false;
        }

        if (!metodos.validarSpinner(dije, recursos.getString(R.string.errorDije))){
            return false;
        }

        if (!metodos.validarSpinner(tipo, recursos.getString(R.string.errorTipo))){
            return false;
        }

        if (cantidad.getText().toString().isEmpty() || Integer.parseInt(cantidad.getText().toString())==0) {
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.errorCantidad));
            return false;
        }

        if (moneda.getCheckedRadioButtonId() <= 0) {
            cop.setError(recursos.getString(R.string.errorMoneda));
            return false;
        }

        return true;
    }

    public int precioAPagar(int posMaterial, int posDije, int posTipo, int cant){

        int totalAPagar=0;
        int precio=0;

        if (posMaterial==1){
            precio=metodos.preciosCuero(posDije, posTipo);
            totalAPagar=(metodos.valorAPagar(precio, cant));
        }

        if (posMaterial==2){
            precio=metodos.preciosCuerda(posDije, posTipo);
            totalAPagar=(metodos.valorAPagar(precio, cant));
        }

        return totalAPagar;
    }

    public void boton(View v) {
        int total = 0;

        if (validar()) {
            int cant = Integer.parseInt(cantidad.getText().toString());
            int posicionMaterial=material.getSelectedItemPosition();
            int posicionDije=dije.getSelectedItemPosition();
            int posicionTipo=tipo.getSelectedItemPosition();
            cop.setError(null);

            if (usd.isChecked()) {
                total = precioAPagar(posicionMaterial, posicionDije, posicionTipo, cant);
                resultado.setText(recursos.getString(R.string.total) + total + " USD");
            }

            if (cop.isChecked()) {
                    total = metodos.valorCop(precioAPagar(posicionMaterial, posicionDije, posicionTipo, cant));
                    resultado.setText(recursos.getString(R.string.total) + total + " COP");
                }
            }
        }
}
