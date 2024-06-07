package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * Clase que representa un comentario principal sobre un manga, que puede contener subcomentarios.
 */

public class Comment {

    private String isbn;
    private int cantidadComentarios;
    private Comentario[] subComentarios;
    /**
     * Constructor de la clase Comment.
     *
     * @param isbn               El ISBN del manga al que pertenece el comentario.
     * @param cantidadComentarios La cantidad total de comentarios.
     * @param subComentarios     Los subcomentarios asociados a este comentario.
     */
    public Comment(String isbn, int cantidadComentarios,Comentario[] subComentarios) {
        this.isbn = isbn;
        this.cantidadComentarios = cantidadComentarios;
        this.subComentarios = subComentarios;
    }
    /**
     * Obtiene el ISBN del manga al que pertenece el comentario.
     *
     * @return El ISBN del manga.
     */
    public String getIsbn() {
        return isbn;
    }


    public int getCantidad_comentarios() {
        return cantidadComentarios;
    }

    public Comentario[] getComentarios() {
        return subComentarios;
    }
    /**
     * Obtiene la cantidad total de comentarios.
     *
     * @return La cantidad total de comentarios.
     */
    public int getCantidadComentarios() {
        return cantidadComentarios;
    }
    /**
     * Obtiene los subcomentarios asociados a este comentario.
     *
     * @return Los subcomentarios asociados.
     */
    public Comentario[] getSubComentarios() {
        return subComentarios;
    }

}
