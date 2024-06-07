package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * La clase Administrador extiende la clase Usuario y representa un administrador del sistema.
 * Cada administrador tiene un identificador único adicional.
 */
public class Administrador extends Usuario {
    private String administradorId;
    /**
     * Constructor para crear un objeto Administrador.
     *
     * @param rol            El rol del usuario (Administrador en este caso).
     * @param username       El nombre de usuario del administrador.
     * @param id             El identificador único del usuario.
     * @param password       La contraseña del administrador.
     * @param administradorId El identificador único del administrador.
     */
    public Administrador(Rol rol, String username, int id, String password, String administradorId) {
        super(rol, username, id, password);
        this.administradorId = administradorId;
    }
    /**
     * Obtiene el identificador único del administrador.
     *
     * @return El identificador único del administrador.
     */
    public String getAdministradorId() {
        return administradorId;
    }
}
