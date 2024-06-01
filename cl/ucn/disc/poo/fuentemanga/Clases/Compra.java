package cl.ucn.disc.poo.fuentemanga.Clases;

public class Compra {
    private String isbn;
    private int usernameId;
    private String estado;
    private String fecha;
    private int cantidad;

    public Compra(String isbn, int usernameId, String estado, String fecha, int cantidad) {
        this.isbn = isbn;
        this.usernameId = usernameId;
        this.estado = estado;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getUsernameId() {
        return usernameId;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }
}
