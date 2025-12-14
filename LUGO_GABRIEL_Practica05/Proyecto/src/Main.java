import modulos.*;
import utilidades.ManejadorLista;
import utilidades.ManejadorArchivos;

public class Main {

    public static void main(String[] args) {

        if (args.length != 10) {
            System.out.println("ERROR: Debes ingresar exactamente 10 nombres.");
            System.out.println("Ejemplo:");
            System.out.println("java Main \"Juan\" \"María\" \"Carlos\" \"Ana\" \"Luis\" \"Laura\" \"Pedro\" \"Sofia\" \"Miguel\" \"Elena\"");
            return;
        }

        ManejadorLista<Empleado> manejadorEmpleados = new ManejadorLista<>();
        ManejadorLista<Administrador> manejadorAdmins = new ManejadorLista<>();

        System.out.println("=== ENTRADA RECIBIDA (10 nombres) ===");
        for (int i = 0; i < args.length; i++) {
            System.out.println((i + 1) + ". " + args[i]);
        }

        Empleado[] empleados = new Empleado[10];
        Administrador[] admins = new Administrador[10];

        for (int i = 0; i < 10; i++) {
            String nombre = args[i];
            String correo = nombre.toLowerCase() + "@empresa.com";

            empleados[i] = new Empleado(nombre, correo);
            admins[i] = new Administrador(nombre, correo);
        }

        System.out.println("\n=== PROCESANDO DATOS ===");
        System.out.println("Empleados creados automáticamente (todos con rol Empleado)");

        Empleado[] empleadosReversa = manejadorEmpleados.regresarReversa(empleados);
        Administrador[] adminsReversa = manejadorAdmins.regresarReversa(admins);

        System.out.println("Lista revertida correctamente");

        guardarUsuariosEnArchivo(empleadosReversa, "src/BD/Empleados.txt");
        System.out.println("Archivo 'Empleados.txt' creado con 10 empleados");

        Empleado extraEmp = new Empleado("Roberto", "roberto@empresa.com");
        ManejadorArchivos.escribirLineaAlFinal(extraEmp.toString(), "src/BD/Empleados.txt");
        System.out.println("Nuevo empleado añadido al archivo");

        System.out.println("\nAdministradores creados automáticamente (todos con rol Administrador)");
        System.out.println("Lista revertida correctamente");

        guardarUsuariosEnArchivo(adminsReversa, "src/BD/Administradores.txt");
        System.out.println("Archivo 'Administradores.txt' creado con 10 administradores");

        Administrador extraAdmin = new Administrador("Roberto", "roberto@empresa.com");
        ManejadorArchivos.escribirLineaAlFinal(extraAdmin.toString(), "src/BD/Administradores.txt");
        System.out.println("Nuevo administrador añadido al archivo");

        String[] empleadosFinal = ManejadorArchivos.leerArchivoComoArreglo("src/BD/Empleados.txt");
        String[] adminsFinal = ManejadorArchivos.leerArchivoComoArreglo("src/BD/Administradores.txt");

        System.out.println("\n=== RESULTADO FINAL (11 empleados) ===");
        imprimirConFormato(empleadosFinal);

        System.out.println("\n=== RESULTADO FINAL (11 administradores) ===");
        imprimirConFormato(adminsFinal);
    }

    private static void guardarUsuariosEnArchivo(Object[] usuarios, String ruta) {
        String[] lineas = new String[usuarios.length];
        for (int i = 0; i < usuarios.length; i++) {
            lineas[i] = usuarios[i].toString();
        }
        ManejadorArchivos.escribirArregloAArchivo(lineas, ruta);
    }

    private static void imprimirConFormato(String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            String[] partes = arreglo[i].split(",");
            String nombre = partes[0];
            String correo = partes[1];
            String tipo = partes[2];

            System.out.println((i + 1) + ". " + nombre + " - " + correo + " - " + tipo);
        }
    }
}

