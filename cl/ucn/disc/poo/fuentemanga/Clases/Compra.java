package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * Clase que representa una compra realizada en la tienda de mangas.
 */
public class Compra {
    private int id;
    private String isbn;
    private int usernameId;
    private String estado;
    private String fecha;
    private int cantidad;
    /**
     * Constructor de la clase Compra.
     *
     * @param id         Identificador único de la compra.
     * @param isbn       ISBN del manga comprado.
     * @param usernameId Identificador del usuario que realizó la compra.
     * @param estado     Estado de la entrega de la compra.
     * @param fecha      Fecha de la compra.
     * @param cantidad   Cantidad de mangas comprados.
     */
    public Compra(int id, String isbn, int usernameId, String estado, String fecha, int cantidad) {
        this.id = id;
        this.isbn = isbn;
        this.usernameId = usernameId;
        this.estado = estado;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el identificador único de la compra.
     *
     * @return El identificador único de la compra.
     */
    public int getId(){ return id;}
    /**
     * Obtiene el ISBN del manga comprado.
     *
     * @return El ISBN del manga comprado.
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Obtiene el identificador del usuario que realizó la compra.
     *
     * @return El identificador del usuario que realizó la compra.
     */
    public int getUsernameId() {
        return usernameId;
    }
    /**
     * Obtiene el estado de la entrega de la compra.
     *
     * @return El estado de la entrega de la compra.
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Obtiene la fecha de la compra.
     *
     * @return La fecha de la compra.
     */

    public String getFecha() {
        return fecha;
    }
    /**
     * Obtiene la cantidad de mangas comprados.
     *
     * @return La cantidad de mangas comprados.
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Establece el estado de la entrega de la compra.
     *
     * @param estado El estado de la entrega de la compra.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


}
