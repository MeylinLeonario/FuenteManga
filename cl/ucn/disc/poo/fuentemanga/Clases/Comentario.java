package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * Clase que representa un comentario sobre un manga.
 */
public class Comentario {
    private String comment;
    private double rating;
    /**
     * Constructor de la clase Comentario.
     *
     * @param comment El texto del comentario.
     * @param rating  La calificación del comentario.
     */
    public Comentario(String comment, double rating) {
        this.comment = comment;
        this.rating = rating;
    }
    /**
     * Obtiene el texto del comentario.
     *
     * @return El texto del comentario.
     */
    public String getComentario() {
        return comment;
    }
    /**
     * Obtiene la calificación del comentario.
     *
     * @return La calificación del comentario.
     */
    public double getRating() {
        return rating;
    }
}
