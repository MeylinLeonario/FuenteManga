package cl.ucn.disc.poo.fuentemanga.Clases;


public class Comments {

    private String isbn;
    private int cantidadComentarios;
    private Comentario[] subComentarios;

    public Comments(String isbn, int cantidadComentarios,Comentario[] subComentarios) {
        this.isbn = isbn;
        this.cantidadComentarios = cantidadComentarios;
        this.subComentarios = subComentarios;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCantidad_comentarios() {
        return cantidadComentarios;
    }

    public Comentario[] getComentarios() {
        return subComentarios;
    }

    public int getCantidadComentarios() {
        return cantidadComentarios;
    }

    public Comentario[] getSubComentarios() {
        return subComentarios;
    }
}
