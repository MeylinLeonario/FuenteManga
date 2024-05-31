package Sistema;


import Clases.Administrador;
import Clases.Rol;
import edu.princeton.cs.stdlib.In;

import java.util.Scanner;

public class SistemaImpl implements Sistema{
    public void lecturaDeArchivos(){
        //HOLA
    }

    public void usuarioLectura(){
        In in = new In();

    }

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
            Administrador administrador = new Administrador(rol, nombreUsuario, id, password, administradorId);
            System.out.println("Bienvenido, " + administradorId);

        } else if (opcion == 2) {
            System.out.println("<------{Inicio de Sesión}------>");
            System.out.println("Inicio de sesión como usuario");

        }
    }

}
