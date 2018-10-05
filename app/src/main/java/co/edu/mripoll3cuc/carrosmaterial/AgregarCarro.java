package co.edu.mripoll3cuc.carrosmaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

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
}
