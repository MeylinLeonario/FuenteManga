package cl.ucn.disc.poo.fuentemanga.Clases;
/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    private Rol rol;
    private String username;
    private int id;
    private String password;
    /**
     * Constructor de la clase Usuario.
     *
     * @param rol      El rol del usuario.
     * @param username El nombre de usuario.
     * @param id       El identificador único del usuario.
     * @param password La contraseña del usuario.
     */
    public Usuario(Rol rol, String username, int id, String password) {
        this.rol = rol;
        this.username = username;
        this.id = id;
        this.password = password;
    }
    /**
     * Método para obtener el rol del usuario.
     *
     * @return El rol del usuario.
     */
    public Rol getRol() {
        return rol;
    }
    /**
     * Método para obtener el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Método para obtener el identificador único del usuario.
     *
     * @return El identificador único del usuario.
     */
    public int getId() {
        return id;
    }
    /**
     * Método para obtener la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */

    public String getPassword() {
        return password;
    }
}
