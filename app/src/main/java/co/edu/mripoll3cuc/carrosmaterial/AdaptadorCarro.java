package co.edu.mripoll3cuc.carrosmaterial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCarro extends RecyclerView.Adapter <AdaptadorCarro.CarroViewHolder> {
    private ArrayList<Carro> carros;

    public AdaptadorCarro(ArrayList<Carro> carros){
        this.carros=carros;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carro, parent,false);
        return new CarroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {
        Carro c = carros.get(position);
        holder.foto.setImageResource(c.getFoto());
        holder.placa.setText(c.getPlaca());
        holder.color.setSelection(c.getColor());
        holder.marca.setSelection(c.getMarca());
        holder.precio.setText(c.getPrecio());
    }


    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class CarroViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView placa;
        private Spinner color;
        private Spinner marca;
        private TextView precio;
        private View v;

        public CarroViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            placa = v.findViewById(R.id.lblPlaca);
            color = v.findViewById(R.id.lblColor);
            marca = v.findViewById(R.id.lblMarca);
            precio = v.findViewById(R.id.lblPrecio);
        }
    }
}
