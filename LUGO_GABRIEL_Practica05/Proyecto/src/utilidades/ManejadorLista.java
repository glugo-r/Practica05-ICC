package utilidades;

import interfaces.ArreglosInterface;

public class ManejadorLista<T> implements ArreglosInterface<T> {

    @Override
    public T[] regresarReversa(T[] arreglo) {
        if (arreglo == null)
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");

        if (arreglo.length == 0)
            throw new IllegalStateException("El arreglo está vacío, no se puede invertir.");

        T[] reversa = arreglo.clone();

        int n = arreglo.length;
        for (int i = 0; i < n; i++) {
            reversa[i] = arreglo[n - 1 - i];
        }

        return reversa;
    }

    @Override
    public T[] agregarElemento(T[] arreglo, T elemento) {
        if (arreglo == null || elemento == null)
            throw new IllegalArgumentException("Ni el arreglo ni el elemento pueden ser nulos.");

        T[] nuevo = java.util.Arrays.copyOf(arreglo, arreglo.length + 1);
        nuevo[arreglo.length] = elemento;

        return nuevo;
    }

    @Override
    public T buscarElemento(T[] arreglo, int posicion) {
        if (arreglo == null)
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");

        if (posicion < 0 || posicion >= arreglo.length)
            throw new IndexOutOfBoundsException("Posición fuera de rango.");

        return arreglo[posicion];
    }

    @Override
    public T[] eliminarElemento(T[] arreglo, int posicion) {
        if (arreglo == null)
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");

        if (posicion < 0 || posicion >= arreglo.length)
            throw new IndexOutOfBoundsException("Posición fuera de rango.");

        T[] nuevo = java.util.Arrays.copyOf(arreglo, arreglo.length - 1);

        for (int i = posicion; i < nuevo.length; i++) {
            nuevo[i] = arreglo[i + 1];
        }

        return nuevo;
    }
}

