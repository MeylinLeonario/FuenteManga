package cl.ucn.disc.poo.fuentemanga.Clases;

public class MangaComprado {
    private String isbn;
    private int cantidad;
    private String tipoDePago;

    public MangaComprado(String isbn, int cantidad, String tipoDePago){
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.tipoDePago = tipoDePago;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }
}
