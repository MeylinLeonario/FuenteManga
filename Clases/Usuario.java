package Clases;

public class Usuario {
    private Rol rol;
    private String username;
    private int id;
    private String password;

    public Usuario(Rol rol, String username, int id, String password) {
        this.rol = rol;
        this.username = username;
        this.id = id;
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
