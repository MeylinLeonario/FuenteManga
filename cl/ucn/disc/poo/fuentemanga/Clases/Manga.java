package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * Clase que representa un manga en la tienda.
 */
public class Manga {
    private String isbn;
    private String nombre;
    private int stock;
    private String descripcion;
    private int precio;
    /**
     * Constructor de la clase Manga.
     *
     * @param isbn        ISBN del manga.
     * @param nombre      Nombre del manga.
     * @param stock       Stock disponible del manga.
     * @param descripcion Descripción del manga.
     * @param precio      Precio del manga.
     */
    public Manga(String isbn, String nombre, int stock, String descripcion, int precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    /**
     * Obtiene el ISBN del manga.
     *
     * @return El ISBN del manga.
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Obtiene el nombre del manga.
     *
     * @return El nombre del manga.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtiene el stock disponible del manga.
     *
     * @return El stock disponible del manga.
     */

    public int getStock() {
        return stock;
    }
    /**
     * Obtiene la descripción del manga.
     *
     * @return La descripción del manga.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Obtiene el precio del manga.
     *
     * @return El precio del manga.
     */

    public int getPrecio() {
        return precio;
    }
}
