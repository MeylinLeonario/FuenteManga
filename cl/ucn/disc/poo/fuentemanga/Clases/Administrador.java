package cl.ucn.disc.poo.fuentemanga.Clases;

public class Administrador extends Usuario {
    private String administradorId;

    public Administrador(Rol rol, String username, int id, String password, String administradorId) {
        super(rol, username, id, password);
        this.administradorId = administradorId;
    }

    public String getAdministradorId() {
        return administradorId;
    }
}
