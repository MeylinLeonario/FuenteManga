package Clases;

public class Compras {
    private String isbn;
    private String usernameId;
    private String estado;
    private String fecha;
    private int cantidad;

    public Compras(String isbn, String usernameId, String estado, String fecha, int cantidad) {
        this.isbn = isbn;
        this.usernameId = usernameId;
        this.estado = estado;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUsernameId() {
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
