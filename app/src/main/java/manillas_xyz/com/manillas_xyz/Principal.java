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


public class Principal extends AppCompatActivity   {
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

        cantidad=findViewById(R.id.txtCantidad);
        resultado=findViewById(R.id.lblTotal);
        material=findViewById(R.id.cmbMaterial);
        dije=findViewById(R.id.cmbDije);
        tipo=findViewById(R.id.cmbTipo);
        usd=findViewById(R.id.rdUSD);
        cop=findViewById(R.id.rdCOP);
        boton=findViewById(R.id.btnCalcular);
        moneda=findViewById(R.id.rgMoneda);

        recursos=this.getResources();

        opMat=recursos.getStringArray(R.array.materiales);
        ArrayAdapter<String> mat= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opMat);
        material.setAdapter(mat);


        opDije=recursos.getStringArray(R.array.dije);
        ArrayAdapter<String> dij= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opDije);
        dije.setAdapter(dij);


        opTipo=recursos.getStringArray(R.array.tipo);
        ArrayAdapter<String> tip= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opTipo);
        tipo.setAdapter(tip);
    }

    public TextView errorSpinner(Spinner mySpinner, String error){
        TextView errorText = (TextView)mySpinner.getSelectedView();
        errorText.setError("");
        errorText.setTextColor(Color.RED);
        errorText.setText(error);
        return errorText;
    }

    public boolean validar(){
        if (material.getSelectedItemPosition()==0){
            material.requestFocus();
            errorSpinner(material, recursos.getString(R.string.errorMaterial));
            return false;
        }

        if (dije.getSelectedItemPosition()==0){
            dije.requestFocus();
            errorSpinner(dije, recursos.getString(R.string.errorDije));
            return false;
        }

        if (tipo.getSelectedItemPosition()==0){
            tipo.requestFocus();
            errorSpinner(tipo, recursos.getString(R.string.errorTipo));
            return false;
        }

        if (cantidad.getText().toString().isEmpty()){
            cantidad.requestFocus();
            cantidad.setError(recursos.getString(R.string.errorCantidad));
            return false;
        }

        if (moneda.getCheckedRadioButtonId()<=0){
            cop.setError(recursos.getString(R.string.errorMoneda));
            return false;
        }

        return true;
    }

    public void calcular(View v){
        if(validar()){
            cop.setError(null);
        }
    }







}
