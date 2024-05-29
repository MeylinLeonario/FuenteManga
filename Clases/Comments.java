package Clases;

import java.util.List;

public class Comments {
    private String isbn;
    private int cantidad_comentarios;
    private List<Comentario> comentarios;

    public Comments(String isbn, int cantidad_comentarios, List<Comentario> comentarios) {
        this.isbn = isbn;
        this.cantidad_comentarios = cantidad_comentarios;
        this.comentarios = comentarios;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCantidad_comentarios() {
        return cantidad_comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
