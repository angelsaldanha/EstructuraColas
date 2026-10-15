package programacolas;

/**
 * Cola Circular sobre arreglo que resuelve el desbordamiento artificial.
 * Reutiliza casillas al inicio mediante aritmética modular: (indice + 1) % capacidad.
 */
public class ColaEstaticaCircular {
    private final int[] datos;
    private final int capacidad;
    private int frente;  // Posición del primer elemento en la fila
    private int fin;     // Posición del último elemento ingresado
    private int tamanio; // Cantidad de elementos activos actualmente

    public ColaEstaticaCircular(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamanio = 0; // El contador evita ambigüedad entre cola llena y vacía
    }

    // la cola está vacía cuando el conteo de elementos activos es 0
    public boolean estaVacia() {
        return tamanio == 0;
    }

    // la cola está llena cuando el total de elementos activos iguala la capacidad
    public boolean estaLlena() {
        return tamanio == capacidad;
    }

    // inserta reutilizando posiciones liberadas al dar la vuelta al arreglo
    public void encolar(int x) {
        if (estaLlena()) {
            System.out.println(" [Aviso] Cola circular llena: no se pudo insertar " + x + ".");
            return;
        }
        // salto circular: si fin llega al extremo, vuelve al índice 0
        fin = (fin + 1) % capacidad;
        datos[fin] = x;
        tamanio++;
        System.out.println(" -> Encolado: " + x + " (índice: " + fin + ", activos: " + tamanio + ")");
    }

    // extrae el elemento del frente y desplaza 'frente' circularmente
    public int desencolar() {
        if (estaVacia()) {
            System.out.println(" [Error] Cola circular vacía: no hay elementos para desencolar.");
            return -1;
        }
        int valor = datos[frente];
        // Desplazamiento circular del frente
        frente = (frente + 1) % capacidad;
        tamanio--;
        System.out.println(" <- Desencolado: " + valor + " (activos restantes: " + tamanio + ")");
        return valor;
    }

    // consulta el dato en 'frente' sin alterar índices ni el contador
    public int peek() {
        if (tamanio == 0) {
            System.out.println(" [Error] Cola circular vacía: no hay elemento al frente.");
            return -1;
        }
        return datos[frente];
    }

    // recorre exactamente 'tamanio' elementos calculando sus posiciones relativas
    public void mostrar() {
        if (estaVacia()) {
            System.out.println(" Estado: (vacía)");
            return;
        }
        System.out.print(" Contenido circular [frente -> fin]: ");
        for (int i = 0; i < tamanio; i++) {
            int indiceReal = (frente + i) % capacidad;
            System.out.print("[" + datos[indiceReal] + "]");
            if (i < tamanio - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" | Activos: " + tamanio + "/" + capacidad);
    }
}
