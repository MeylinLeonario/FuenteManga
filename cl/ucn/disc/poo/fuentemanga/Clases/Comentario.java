package cl.ucn.disc.poo.fuentemanga.Clases;

public class Comentario {
    private String comment;
    private double rating;
    public Comentario(String comment, double rating) {
        this.comment = comment;
        this.rating = rating;
    }

    public String getComentario() {
        return comment;
    }

    public double getRating() {
        return rating;
    }
}
