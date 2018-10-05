package co.edu.mripoll3cuc.carrosmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarro extends AppCompatActivity {
    private EditText txtPlaca, txtPrecio;
    private Spinner cmbColor, cmbMarca;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;
    private ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carro);

        txtPlaca = findViewById(R.id.txtPlaca);
        cmbColor = findViewById(R.id.cmbColor);
        cmbMarca = findViewById(R.id.cmbMarca);
        txtPrecio = findViewById(R.id.txtPrecio);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.imagen1);
        fotos.add(R.drawable.imagen2);
        fotos.add(R.drawable.imagen3);
        fotos.add(R.drawable.imagen4);
        fotos.add(R.drawable.imagen5);

        opc = getResources().getStringArray(R.array.color);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbColor.setAdapter(adapter);

        opc = getResources().getStringArray(R.array.marca);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbMarca.setAdapter(adapter);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        String pla, pre;
        int foto, col, mar;
        foto = this.fotoAleatoria();
        pla = txtPlaca.getText().toString();
        col = cmbColor.getSelectedItemPosition();
        mar = cmbMarca.getSelectedItemPosition();
        pre = txtPrecio.getText().toString();


        Carro c = new Carro(foto,pla,col,mar,pre);
        c.guardar();
        limpiar();
        Snackbar.make(v,getResources().getString(R.string.mensaje_guardado),Snackbar.LENGTH_SHORT).show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent (AgregarCarro.this,Principal.class);
        startActivity(i);
    }

    public void limpiar(){
        txtPlaca.setText("");
        cmbColor.setSelection(0);
        cmbMarca.setSelection(0);
        txtPrecio.setText("");
        txtPlaca.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void limpiar(View v){
        limpiar();
    }
}
