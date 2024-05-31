package Clases;

import java.util.List;

public class Comments {
    private String isbn;
    private int cantidad_comentarios;
    private Comentario[] subComentarios;

    public Comments(String isbn, int cantidad_comentarios, Comentario[] subComentarios) {
        this.isbn = isbn;
        this.cantidad_comentarios = cantidad_comentarios;
        this.subComentarios = subComentarios;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCantidad_comentarios() {
        return cantidad_comentarios;
    }

    public Comentario[] getComentarios() {
        return subComentarios;
    }

}
