package programacolas;

/**
 * unidad básica de almacenamiento para estructuras dinámicas.
 * contiene el valor entero y la referencia al siguiente nodo enlazado.
 */
public class Nodo {
    public int dato;
    public Nodo siguiente;

    // constructor para inicializar un nodo terminal (sin enlace siguiente)
    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    // constructor para inicializar un nodo enlazándolo directamente a otro
    public Nodo(int dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
}
