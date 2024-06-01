package cl.ucn.disc.poo.fuentemanga.Sistema;

import cl.ucn.disc.poo.fuentemanga.Clases.Usuario;
import cl.ucn.disc.poo.fuentemanga.Clases.Mangas;
import cl.ucn.disc.poo.fuentemanga.Clases.Administrador;
import cl.ucn.disc.poo.fuentemanga.Clases.Comentario;
import cl.ucn.disc.poo.fuentemanga.Clases.Compras;
import cl.ucn.disc.poo.fuentemanga.Clases.Comments;
import cl.ucn.disc.poo.fuentemanga.Clases.Rol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.StdOut;
import org.w3c.dom.ls.LSOutput;

public class SistemaImpl implements Sistema {
    Scanner scanner = new Scanner(System.in);
    private List<Administrador> administradores = new ArrayList<>();

    private Comentario commentarios;

    public void leerUsuario() {

        Usuario[] usuarios = new Usuario[6];

        In in = new In("users.csv");
        int tamanio = 0;
        String linea = in.readLine();
        linea = in.readLine();

        while (linea != null && !linea.isEmpty()) {

            String[] campos = linea.split(",");

            String rol = campos[0];
            String username = campos[1];
            int id = Integer.parseInt(campos[2]);
            String password = campos[3];
            String administradorId = null;

            if (campos[0].equals("ADMINISTRADOR")){

                administradorId = campos[4];
            }
            if (rol.equals("ADMINISTRADOR")) {
                Administrador administrador = new Administrador(Rol.valueOf(rol), username, id, password, administradorId);
                administradores.add(administrador);
                usuarios[tamanio] = administrador;
            } else if (rol.equals("USUARIO")) {
                Usuario usuario = new Usuario(Rol.valueOf(rol), username, id, password);
                usuarios[tamanio] = usuario;
            }
            tamanio++;
            linea = in.readLine();
        }
        in.close();
    }

    public void leerManga() {

        Mangas[] mangas = new Mangas[5];

        In in = new In("mangas.csv");
        int tamanio = 0;
        String linea = in.readLine();
        linea = in.readLine();

        while (linea != null && !linea.isEmpty()) {

            String[] campos = linea.split(";");

            String isbn = campos[0];
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Mangas manga = new Mangas(isbn, nombre, stock, descripcion, precio);
            mangas[tamanio] = manga;
            tamanio++;
            linea = in.readLine();
        }
        in.close();
    }

    public void leerCompra() {

        Compras[] compras = new Compras[5];

        In in = new In("compras.csv");
        int tamanio = 0;
        String linea = in.readLine();
        linea = in.readLine();

        while (linea != null && !linea.isEmpty()) {

            String[] campos = linea.split(",");

            String isbn = campos[0];
            int usernameId = Integer.parseInt(campos[1]);
            String estado = campos[2];
            String fecha = campos[3];
            int cantidad = Integer.parseInt(campos[4]);

            Compras compra = new Compras(isbn, usernameId, estado, fecha, cantidad);
            compras[tamanio] = compra;
            tamanio++;
            linea = in.readLine();

        }
        in.close();
    }

    public void leerComentario() {
        List<Comments> comentariosList = new ArrayList<>();
        In in = new In("comments.csv");
        String linea = in.readLine();
        linea = in.readLine();

        while (linea != null && !linea.isEmpty()) {

            String[] campos = linea.split(":");
            String isbn = campos[0];
            int cantidadComentarios = Integer.parseInt(campos[1]);
            String comentarioValor = campos[2];
            comentarioValor = comentarioValor.substring(1, comentarioValor.length() - 1);

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
        in.close();

    }

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
    }
    public void inicioComun(){
        System.out.println("<------{Inicio de Sesión}------>");
        System.out.println("Inicio de sesión como cliente.");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Contraseña: ");
        int contraseña = scanner.nextInt();
        for(int i= 0; i< 10; i++){
            if (nombreUsuario == null); //Crear una lista para cada lectura de archivos

        }
    }
    public void menu() {
        menumenu();
        leerCompra();
        leerManga();
        leerUsuario();
        leerComentario();
        int opcion = scanner.nextInt();

        switch(opcion){
            case 1:
                inicioComoAdmin();
                break;
            case 2:
                //inicioComun();
        }
        if (opcion == 1) {


        }else if (opcion == 2){



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
