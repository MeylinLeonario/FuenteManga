package cl.ucn.disc.poo.fuentemanga.Sistema;

import cl.ucn.disc.poo.fuentemanga.Clases.Usuario;
import cl.ucn.disc.poo.fuentemanga.Clases.Manga;
import cl.ucn.disc.poo.fuentemanga.Clases.Administrador;
import cl.ucn.disc.poo.fuentemanga.Clases.Compra;
import cl.ucn.disc.poo.fuentemanga.Clases.Rol;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import edu.princeton.cs.stdlib.In;

public class SistemaImpl implements Sistema {
    Scanner scanner = new Scanner(System.in);
    private List<Administrador> adminList;
    private List<Usuario> usuariosList;
    private List<Manga> mangasList;

    public void leerUsuario() {

        Usuario[] usuarios = new Usuario[6];

        In in = new In("users.csv");
        int tamanio = 0;

        in.readLine();
        String linea = in.readLine();
        while (linea!= null) {

            String[] campos = linea.split(",");

            String rol = campos[0];
            System.out.println(rol);
            String username = campos[1];
            System.out.println(username);
            int id = Integer.parseInt(campos[2]);
            String password = campos[3];

            if (rol == "ADMINISTRADOR") {
                String administradorId = campos[4];
                Administrador administrador = new Administrador(Rol.valueOf(rol), username, id, password, administradorId);
                adminList.add(administrador);
                usuarios[tamanio] = administrador;
            } else if (rol == "USUARIO") {
                Usuario usuario = new Usuario(Rol.valueOf(rol), username, id, password);
                usuariosList.add(usuario);
                usuarios[tamanio] = usuario;
            }
            tamanio++;
            linea = in.readLine();
        }
    }

    public void leerManga() {

        Manga[] mangas = new Manga[5];

        In in = new In("mangas.csv");
        int tamanio = 0;

        in.readLine();
        String linea = in.readLine();

        while (linea != null) {

            String[] campos = linea.split(";");

            String isbn = campos[0];
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Manga manga = new Manga(isbn, nombre, stock, descripcion, precio);
            mangasList.add(manga);
            mangas[tamanio] = manga;
            tamanio++;
            linea = in.readLine();
        }
    }

    public void leerCompra() {

        Compra[] compras = new Compra[5];

        In in = new In("compras.csv");
        int tamanio = 0;

        in.readLine();
        String linea = in.readLine();

        while (linea != null) {

            String[] campos = linea.split(",");

            String isbn = campos[0];
            int usernameId = Integer.parseInt(campos[1]);
            String estado = campos[2];
            String fecha = campos[3];
            int cantidad = Integer.parseInt(campos[4]);

            Compra compra = new Compra(isbn, usernameId, estado, fecha, cantidad);
            compras[tamanio] = compra;
            tamanio++;

            linea = in.readLine();

        }
    }

  /*  public void leerComentario() {
        List<Comments> comentariosList = new ArrayList<>();
        In in = new In("comments.csv");
        String linea = in.readLine();

        while ((linea = in.readLine()) != null) {
            String[] campos = linea.split(":");
            String isbn = campos[0];
            int cantidadComentarios = Integer.parseInt(campos[1]);
            String comentarioValor = campos[2];
            comentarioValor = comentarioValor.substring(1, comentarioValor.length()-1);

            String[] comentarioGlobales = comentarioValor.split("#");

            Comentario[] subComentarios = new Comentario[cantidadComentarios];
            for (int i = 0; i < cantidadComentarios; i++) {
                String[] comentarioYRating = comentarioGlobales[i].split(";");
                String comment = comentarioYRating[0];
                double rating = Double.parseDouble(comentarioYRating[1]);
                subComentarios[i] = new Comentario(comment, rating);

            }
            Comments comments = new Comments(isbn, cantidadComentarios, subComentarios);
            comentariosList.add(comments);
            linea = in.readLine();

        }

    }
*/
    public void menumenu(){
        System.out.println("<------{TIPO DE SESION}------>");
        System.out.println("[1] Administrador");
        System.out.println("[2] Usuario");
    }
    public void inicioComoAdmin(){
        System.out.println("<------{INICIO DE SESIÓN}------>");
        System.out.println("Inicio de sesión como administrador");
        System.out.print("ID de administrador: ");
        String administradorId = scanner.nextLine();
        System.out.print("Nombre de Usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        Rol rol = Rol.ADMINISTRADOR;
        int id = Integer.parseInt(administradorId);
        Administrador administrador = new Administrador(rol,nombreUsuario,id,password,administradorId);
        System.out.println("Bienvenido, " + administradorId);
        for (int i = 0; i < adminList.size(); i++){
            if (administradorId.equals(adminList.get(i).getAdministradorId())){
                if (nombreUsuario.equals(adminList.get(i).getUsername())){
                    if (password.equals(adminList.get(i).getPassword())){
                        System.out.println("VICTORIA");
                    }
                }
            }

        }

    }
    public void inicioComun(){
        System.out.println("<------{Inicio de Sesión}------>");
        System.out.println("Inicio de sesión como cliente.");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Contraseña: ");
        String contrasenia = scanner.nextLine();
        for(int i= 0; i< usuariosList.size(); i++){
            if (nombreUsuario.equals(usuariosList.get(i).getUsername())){
                if (Objects.equals(contrasenia, usuariosList.get(i).getPassword())){
                    System.out.println("VICTORIA");
                }
            }

        }
    }
    public void menu() {
        menumenu();
        int opcion = scanner.nextInt();

        switch(opcion){
            case 1:
                inicioComoAdmin();
                break;
            case 2:
                //inicioComun();
        }
    }

    @Override
    public void busquedaManga(String titulo) {

    }

    @Override
    public void productosComprados() {

    }

    @Override
    public void valorarUnManga(String isbn) {

    }

    @Override
    public void visualizarComentarios(String isbn) {

    }
}
