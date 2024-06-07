package cl.ucn.disc.poo.fuentemanga.Sistema;

import cl.ucn.disc.poo.fuentemanga.Clases.Compra;
import cl.ucn.disc.poo.fuentemanga.Clases.Manga;
/**
 * Interfaz que define las operaciones disponibles en el sistema de gestión de la fuente de manga.
 */
public interface Sistema {
    /**
     * Método para buscar un manga por título.
     *
     * @param titulo El título del manga a buscar.
     */
    void busquedaManga(String titulo);

    /**
     * Método para mostrar los productos comprados por el usuario.
     */
    void productosComprados();
    /**
     * Método para valorar un manga.
     *
     * @param isbn El ISBN del manga a valorar.
     */
    void valorarUnManga(String isbn);
    /**
     * Método para visualizar los comentarios de un manga.
     *
     * @param isbn El ISBN del manga del cual se desean visualizar los comentarios.
     */
    void visualizarComentarios(String isbn);
    /**
     * Método para comprar un manga.
     *
     * @param isbn El ISBN del manga a comprar.
     */
    void comprarUnManga(String isbn);
    /**
     * Método para registrar un nuevo manga en el sistema.
     */
    void registrarManga();

    void verUltimasCompras();
    /**
     * Método para actualizar el estado de una compra realizada.
     */
    void actualizarEstadoDeCompra();

    void estadistica();

}
