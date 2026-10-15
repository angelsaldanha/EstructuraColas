package programacolas;

/**
 * cola dinámica enlazada que crece o encoge según la demanda de memoria.
 * mantiene referencias directas al primer nodo (frente) y al último (fin).
 */
public class ColaDinamica {
    private Nodo frente; // apunta al primer nodo para desencolar en O(1)
    private Nodo fin;    // apunta al último nodo para encolar en O(1)

    public ColaDinamica() {
        this.frente = null;
        this.fin = null;
    }

    // la cola está vacía si el apuntador frente es nulo
    public boolean estaVacia() {
        return frente == null;
    }

    // inserta un nuevo nodo al final de la estructura
    public void encolar(int x) {
        Nodo nuevo = new Nodo(x);
        if (estaVacia()) {
            // si la cola está vacía, el nuevo nodo es frente y fin a la vez
            frente = nuevo;
            fin = nuevo;
        } else {
            // se enlaza el nuevo nodo después del fin actual y se actualiza 'fin'
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        System.out.println(" -> Encolado: " + x);
    }

    // desvincula el nodo del frente y avanza la referencia al siguiente nodo
    public int desencolar() {
        if (estaVacia()) {
            System.out.println(" [Error] Cola vacía: no hay elementos para desencolar.");
            return -1;
        }
        int valor = frente.dato;
        frente = frente.siguiente; // Avanza el frente al nodo subsecuente

        // si la cola quedó vacía, se anula también la referencia 'fin'
        if (frente == null) {
            fin = null;
        }
        System.out.println(" <- Desencolado: " + valor);
        return valor;
    }

    // consulta el valor del nodo en el frente sin desvincularlo
    public int peek() {
        if (estaVacia()) {
            System.out.println(" [Error] Cola vacía: no hay elemento al frente.");
            return -1;
        }
        return frente.dato;
    }

    // cuenta el número de nodos activos recorriendo la lista desde el frente
    public int contarElementos() {
        int contador = 0;
        Nodo actual = frente;
        while (actual != null) {
            contador++;
            actual = actual.siguiente; // Avanza nodo a nodo hasta encontrar null
        }
        return contador;
    }

    // recorre e imprime cada nodo desde el frente hasta el fin
    public void mostrar() {
        if (estaVacia()) {
            System.out.println(" Estado: (vacía)");
            return;
        }
        Nodo actual = frente;
        System.out.print(" Frente -> ");
        while (actual != null) {
            System.out.print("[" + actual.dato + "] ");
            actual = actual.siguiente;
        }
        System.out.println("<- Fin");
    }
}
