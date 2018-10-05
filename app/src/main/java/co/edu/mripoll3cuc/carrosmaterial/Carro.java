package co.edu.mripoll3cuc.carrosmaterial;

public class Carro {
    private int foto;
    private String placa;
    private int marca;
    private int color;
    private String precio;

    public Carro(int foto, String placa, int marca, int color, String precio) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.agregar(this);
    }
}
