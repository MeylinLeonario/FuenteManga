package cl.ucn.disc.poo.fuentemanga.Sistema;

import cl.ucn.disc.poo.fuentemanga.Clases.Compra;
import cl.ucn.disc.poo.fuentemanga.Clases.Manga;

public interface Sistema {
    void busquedaManga(String titulo);
    void productosComprados();
    void valorarUnManga(String isbn);
    void visualizarComentarios(String isbn);
    void registrarManga(Manga manga);
    void verUltimasCompras();
    void actualizarEstadoDeCompra(int idCompra);
    void estadistica();
}
