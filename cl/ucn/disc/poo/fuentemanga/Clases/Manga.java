package cl.ucn.disc.poo.fuentemanga.Clases;

public class Manga {
    private int isbn;
    private String nombre;
    private int stock;
    private String descripcion;
    private int precio;

    public Manga(int isbn, String nombre, int stock, String descripcion, int precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }
}
