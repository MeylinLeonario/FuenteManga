package Sistema;


import Clases.Usuario;
import Clases.Mangas;
import Clases.Administrador;
import Clases.Comentario;
import Clases.Compras;
import Clases.Comments;
import Clases.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.stdlib.In;

public class SistemaImpl implements Sistema{
    private Comentario commentarios;

    public void leerUsuario(){

        Usuario[] usuarios = new Usuario[6];

        In in = new In("users.csv");
        int tamanio = 0;
        String linea = in.readLine();

        while (linea != null){

            String[] campos = linea.split(",");

            String rol = campos[0];
            String username = campos[1];
            int id = Integer.parseInt(campos[3]);
            String password = campos[4];
            String administradorId = campos[5];

            if (rol == "ADMINISTRADOR"){
                Administrador administrador = new Administrador(Rol.valueOf(rol), username, id, password, administradorId);
                usuarios[tamanio] = administrador;
            }
            else if (rol == "USUARIO"){
                Usuario usuario = new Usuario(Rol.valueOf(rol),username,id,password);
                usuarios[tamanio] = usuario;
            }
            tamanio++;
            linea = in.readLine();
        }
    }
    public void leerManga(){

        Mangas[] mangas = new Mangas[5];

        In in = new In("mangas.csv");
        int tamanio = 0;
        String linea = in.readLine();

        while(linea != null){

            String[] campos = linea.split(";");

            String isbn = campos[0];
            String nombre = campos[1];
            int stock = Integer.parseInt(campos[2]);
            String descripcion = campos[3];
            int precio = Integer.parseInt(campos[4]);

            Mangas manga = new Mangas(isbn,nombre,stock,descripcion,precio);
            mangas[tamanio] = manga;
            tamanio++;
            linea = in.readLine();
        }

    }
    public void leerCompra(){

        Compras[] compras = new Compras[5];

        In in = new In("compras.csv");
        int tamanio = 0;
        String linea = in.readLine();

        while(linea != null){

            String[] campos = linea.split(",");

            String isbn = campos[0];
            int usernameId = Integer.parseInt(campos[1]);
            String estado = campos[2];
            String fecha = campos[3];
            int cantidad = Integer.parseInt(campos[4]);

            Compras compra = new Compras(isbn,usernameId,estado,fecha,cantidad);
            compras[tamanio] = compra;
            tamanio++;
            linea = in.readLine();

        }
    }
    /*
    public void leerComentario(){
        Comentario[] comentarios = new Comentario[3];
        In in = new In("comments.csv");
        int tamanio = 0;
        String linea = in.readLine();

        while(linea != null){
            String[] campos = linea.split(";");
            String isbn = campos[0];
            int cantidadComentarios = Integer.parseInt(campos[1]);

            for (int i = 0; i < cantidadComentarios; i++){
                String[] campus = linea.split("#");
                String comment = campus[0];
                double rating = Double.parseDouble(campus[1]);
                //Hay que agregarlos a un List(comment, rating)
            }
        }

    }
    */
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<------{Inicio de Sesión}------>");
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            System.out.println("<------{Inicio de Sesión}------>");
            System.out.println("Inicio de sesión como administrador");
            System.out.println("Id-Administrador:");
            String administradorId = scanner.nextLine();
            System.out.println("Nombre de Usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Contraseña:");
            String password = scanner.nextLine();
            Rol rol = Rol.ADMINISTRADOR;
            int id = Integer.parseInt(administradorId);
            Administrador administrador = new Administrador(rol,nombreUsuario,id,password,administradorId);
            System.out.println("Bienvenido, " + administradorId);

        }else if (opcion == 2){
            System.out.println("<------{Inicio de Sesión}------>");
            System.out.println("Inicio de sesión como cliente");
            System.out.println("nombre de usuario:");
            String nombreUsuario = scanner.nextLine();


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
