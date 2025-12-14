package utilidades;

import java.io.*;
import java.util.ArrayList;

public class ManejadorArchivos {

    public static String[] leerArchivoComoArreglo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }

        return lineas.toArray(new String[0]);
    }

    public static String buscarLinea(String cadenaBuscada, String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(cadenaBuscada)) {
                    return linea;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al buscar en archivo: " + e.getMessage());
        }
        return null;
    }

    public static void escribirLineaAlFinal(String linea, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }

    public static void escribirArregloAArchivo(String[] lineas, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }
}

