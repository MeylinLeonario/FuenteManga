package cl.ucn.disc.poo.fuentemanga.Sistema;

import cl.ucn.disc.poo.fuentemanga.Clases.Usuario;
import cl.ucn.disc.poo.fuentemanga.Clases.Manga;
import cl.ucn.disc.poo.fuentemanga.Clases.Administrador;
import cl.ucn.disc.poo.fuentemanga.Clases.Comentario;
import cl.ucn.disc.poo.fuentemanga.Clases.Compra;
import cl.ucn.disc.poo.fuentemanga.Clases.Comment;
import cl.ucn.disc.poo.fuentemanga.Clases.Rol;

import java.text.DecimalFormat;
import java.util.*;

import edu.princeton.cs.stdlib.In;
import edu.princeton.cs.stdlib.StdOut;
import org.w3c.dom.ls.LSOutput;

public class SistemaImpl implements Sistema {
    Scanner scanner = new Scanner(System.in);
    private List<Administrador> adminsList = new ArrayList<>();
    private List<Manga> mangasList = new ArrayList<>();
    private List<Usuario> usuariosList = new ArrayList<>();
    private List<Compra> comprasList = new ArrayList<>();
    private List<Comment> commentsList = new ArrayList<>();
    private List<Comentario> miniCommentsList = new ArrayList<>();

    public void leerUsuario() {

        Usuario[] usuarios = new Usuario[6];

        In in = new In("users.csv");
        int tamanio = 0;

        in.readLine();
        String linea = in.readLine();
        while (linea != null) {

            String[] campos = linea.split(",");

            String rol = campos[0];
            String username = campos[1];
            int id = Integer.parseInt(campos[2]);
            String password = campos[3];
            String administradorId = null;

            if (Objects.equals(campos[0], "ADMINISTRADOR")){
                administradorId = campos[4];
            }
            if (rol.equals("ADMINISTRADOR")) {
                Administrador administrador = new Administrador(Rol.valueOf(rol), username, id, password, administradorId);
                adminsList.add(administrador);
                usuarios[tamanio] = administrador;
            } else if (rol.equals("USUARIO")) {
                Usuario usuario = new Usuario(Rol.valueOf(rol), username, id, password);
                usuariosList.add(usuario);
                usuarios[tamanio] = usuario;
            }
            tamanio++;
            linea = in.readLine();
        }
        in.close();
    }

    public void leerManga() {

        Manga[] mangas = new Manga[5];

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

            Manga manga = new Manga(isbn, nombre, stock, descripcion, precio);
            mangasList.add(manga);
            mangas[tamanio] = manga;
            tamanio++;
            linea = in.readLine();
        }
        in.close();
    }

    public void leerCompra() {

        Compra[] compras = new Compra[5];

        In in = new In("compras.csv");
        int tamanio = 0;
        String linea = in.readLine();
        linea = in.readLine();

        while (linea != null && !linea.isEmpty()) {

            String[] campos = linea.split(",");
            int id = Integer.parseInt(campos[0]);
            String isbn = campos[1];
            int usernameId = Integer.parseInt(campos[2]);
            String estado = campos[3];
            String fecha = campos[4];
            int cantidad = Integer.parseInt(campos[5]);

            Compra compra = new Compra(id, isbn, usernameId, estado, fecha, cantidad);
            comprasList.add(compra);
            compras[tamanio] = compra;
            tamanio++;
            linea = in.readLine();

        }
        in.close();
    }

    public void leerComentario() {
        List<Comment> comentariosList = new ArrayList<>();
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

                miniCommentsList.add(subComentarios[i]);

            }
            Comment comments = new Comment(isbn, cantidadComentarios, subComentarios);
            commentsList.add(comments);
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
        scanner.nextLine();
        String administradorId = scanner.nextLine();
        System.out.print("Nombre de Usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        while (true) {
            for (int i = 0; i < adminsList.size(); i++) {
                if (administradorId.equals(adminsList.get(i).getAdministradorId())) {
                    if (nombreUsuario.equals(adminsList.get(i).getUsername())) {
                        if (password.equals(adminsList.get(i).getPassword())) {
                            System.out.println("Ingreso exitoso.");
                            return;
                        }
                    }
                }
            }
            System.out.println("Datos incorrectos. Ingrese nuevamente");
            System.out.print("ID de administrador: ");
            administradorId = scanner.nextLine();
            System.out.print("Nombre de Usuario: ");
            nombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            password = scanner.nextLine();
        }
    }
    public void inicioComun(){
        System.out.println("Inicio de sesión como cliente.");
        System.out.print("Nombre de usuario: ");
        scanner.nextLine();
        String nombreUsuario = scanner.nextLine();
        System.out.println("Contraseña: ");
        String contrasenia = scanner.nextLine();
        while (true) {
            for (int i = 0; i < usuariosList.size(); i++) {
                if (nombreUsuario.equals(usuariosList.get(i).getUsername())) {
                    if ((usuariosList.get(i).getPassword()).equals(contrasenia)) {
                        System.out.println("Ingreso exitoso.");
                        return;
                    }
                }
            }
            System.out.println("Nombre de usuario o contraseña incorrectos. Intente otra vez.");
            System.out.print("Nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            System.out.println("Contraseña: ");
            contrasenia = scanner.nextLine();
        }
    }
    public void menu() {
        menumenu();
        leerCompra();
        leerManga();
        leerUsuario();
        leerComentario();
        System.out.print("Ingrese su alternativa:");
        int opcion = scanner.nextInt();

        switch(opcion){
            case 1:
                inicioComoAdmin();
                menuAdministrador();
                int alternativa = scanner.nextInt();
                switch (alternativa){
                    case 1:
                        //registrarManga();
                        break;
                    case 2:
                        
                }

                break;

            case 2:
                inicioComun();
                while (true){
                menuUsuario();
                String option = scanner.nextLine();
                    switch(option){
                        case "1":
                            obtenerTitulo();
                            break;
                        case "2":
                            productosComprados();
                            break;
                        case "3":
                            //valorarUnManga();
                            break;
                        case "4":
                            //visualizarComentarios();
                            break;
                        case "5":
                            gettingAnISBN();
                    }
                }

        }
    }
    public void menuAdministrador(){
        System.out.println("<------{FUNCIONALIDADES}------>");
        System.out.println("[1] Registrar manga");
        System.out.println("[2] Ver ultimas compras");
        System.out.println("[3] Actualizar estado de una compra");
        System.out.println("[4] Estadisticas");
        System.out.println("[5] Salir");

    }

    public void menuUsuario(){
        System.out.println("<------{FUNCIONALIDADES}------>");
        System.out.println("[1] Buscar un manga");
        System.out.println("[2] Ver productos comprados");
        System.out.println("[3] Valorar un manga");
        System.out.println("[4] Visualizar comentarios");
        System.out.println("[5] Comprar un manga");
        System.out.println("[6] Salir");
    }
    public void registrarManga(Manga manga){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del manga:");
        String nombreManga = scanner.nextLine();
        if (nombreManga == null){
            throw new IllegalArgumentException("El maga no puede estar vacio.");
        }
        System.out.println("Codigo unico del manga:");
        int codigoManga = scanner.nextInt();
        if(codigoManga <= 0 ){
            throw new IllegalArgumentException("El codigo no puede estar vacio ni ser negativo");
        }
        System.out.println("Cuantos mangas hay disponibles:");
        int cantidadMangas = scanner.nextInt();
        if(cantidadMangas <= 0){
            throw new IllegalArgumentException("La cantidad de mangas no puede estar vacio ni ser negativo");
        }
        System.out.println("Descricion del manga: ");
        String descripcionManga = scanner.nextLine();
        if(descripcionManga == null){
            throw new IllegalArgumentException("La descripcion no puede estar vacia-");
        }
        System.out.println("Precio del manga:");
        int precioManga = scanner.nextInt();
        if(precioManga <= 0){
            throw new IllegalArgumentException("El precio del manga no puede estar vacio ni ser negativo");
        }
        manga= new Manga(String.valueOf(codigoManga), nombreManga, cantidadMangas, descripcionManga, precioManga);

    }

    @Override
    public void verUltimasCompras() {

    }

    @Override
    public void actualizarEstadoDeCompra(int idCompra) {

    }


    @Override
    public void estadistica() {

    }

    public void obtenerTitulo(){
        System.out.print("Ingrese un título: ");
        String titulo = scanner.nextLine();
        busquedaManga(titulo);
    }
    @Override
    public void busquedaManga(String titulo) {
        boolean existe = false;
        for (Manga manga : mangasList) {
            if (titulo.equals(manga.getNombre())) {
                existe = true;
                System.out.println("¡Título encontrado!");
                System.out.println("Título: " + manga.getNombre());
                System.out.println("ISBN: " + manga.getIsbn());
                double suma = 0;
                double cantidad = 0;
                int comentarios = 0;
                for (Comment comment : commentsList) {
                    if ((comment.getIsbn()).equals(manga.getIsbn())) {
                        for (Comentario comentario : miniCommentsList){
                            suma += comentario.getRating();
                            cantidad +=1;
                        }
                        comentarios++;
                    }
                }
                System.out.println("Comentarios: " + comentarios);
                double ratingComun = suma / cantidad;
                double original = decimalFormat(ratingComun);
                System.out.println("Rating promedio: " + original);
                System.out.println("Stock: " + manga.getStock());
            }
        }
        if (!existe){
            System.out.println("El título no existe");
        }
    }
    public double decimalFormat(double numero){
        DecimalFormat df = new DecimalFormat("#.#");
        String formatted = df.format(numero);
        return Double.parseDouble(formatted);
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

    //SECCION: COMPRAR UN MANGA
    public void gettingAnISBN(){
        System.out.println("<-----COMPRAR PRODUCTO----->");
        System.out.print("Ingresa el ISBN del producto a comprar: ");
        String newISBN = scanner.nextLine();
        System.out.print("Ingresa la cantidad de productos: ");
        String quantity = scanner.nextLine();
        System.out.print("Ingrese el método de pago (Débito/Crédito): ");
        String pago = scanner.nextLine();

        }

    @Override
    public void comprarUnManga(String isbn) {

    }
}
