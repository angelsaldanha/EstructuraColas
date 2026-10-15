package programacolas;

/**
 * Implementación de Cola Lineal basada en un arreglo de tamaño fijo (FIFO).
 * El frente avanza al extraer y el fin avanza al insertar.
 */
public class ColaEstatica {
    private final int[] datos;
    private final int capacidad;
    private int frente; // Índice del elemento listo para salir
    private int fin;    // Índice del último elemento insertado

    public ColaEstatica(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.frente = 0;
        this.fin = -1; // -1 indica que la cola inicia sin elementos
    }

    // la cola está vacía si el índice de extracción sobrepasa al de inserción
    public boolean estaVacia() {
        return frente > fin;
    }

    // la cola se satura cuando 'fin' alcanza la última posición física del arreglo
    public boolean estaLlena() {
        return fin == capacidad - 1;
    }

    // inserta un dato al final verificando que no exista desbordamiento
    public void encolar(int x) {
        if (estaLlena()) {
            System.out.println(" [Aviso] Cola llena: no se pudo insertar " + x + ".");
            return;
        }
        // incrementa la posición de fin y almacena el nuevo valor
        datos[++fin] = x;
        System.out.println(" -> Encolado: " + x);
    }

    // extrae y devuelve el elemento al frente incrementando el índice 'frente'
    public int desencolar() {
        if (estaVacia()) {
            System.out.println(" [Error] Cola vacía: no hay elementos para desencolar.");
            return -1;
        }
        // obtiene el dato y desplaza el frente al siguiente índice
        int valor = datos[frente++];
        System.out.println(" <- Desencolado: " + valor);
        return valor;
    }

    // consulta el valor al frente de la cola sin modificar apuntadores
    public int peek() {
        if (estaVacia()) {
            System.out.println(" [Error] Cola vacía: no hay elemento al frente.");
            return -1;
        }
        return datos[frente];
    }

    // muestra los elementos vigentes desde 'frente' hasta 'fin'
    public void mostrar() {
        if (estaVacia()) {
            System.out.println(" Estado: (vacía)");
            return;
        }
        System.out.print(" Contenido [frente -> fin]: ");
        for (int i = frente; i <= fin; i++) {
            System.out.print("[" + datos[i] + "]");
            if (i < fin) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
