package programacolas;

/**
 * Prueba independiente para la Cola Circular.
 * Demuestra el reciclaje de posiciones de memoria una vez que
 * se desencolan elementos y entran nuevos datos.
 */
public class MainColaCircular {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      Prueba: Cola Estática Circular (Arreglo)    ");
        System.out.println("==================================================");

        ColaEstaticaCircular cola = new ColaEstaticaCircular(4);
        System.out.println("¿Está vacía al inicio?: " + cola.estaVacia());

        // llenar por primera vez
        System.out.println("\n-- Inserción hasta capacidad máxima (4 elementos) --");
        cola.encolar(100);
        cola.encolar(200);
        cola.encolar(300);
        cola.encolar(400);

        System.out.println("\n¿Está llena?: " + cola.estaLlena());
        cola.mostrar();

        System.out.println("\nElemento al frente (peek): " + cola.peek());

        // liberar las dos primeras casillas
        System.out.println("\n-- Extracción de dos elementos --");
        cola.desencolar();
        cola.desencolar();
        cola.mostrar();

        System.out.println("\nNuevo frente tras extracciones (peek): " + cola.peek());

        // reutilización de índices al dar la vuelta
        System.out.println("\n-- Inserción aprovechando el espacio liberado al inicio --");
        cola.encolar(500); // Entra en el índice 0 reciclado
        cola.encolar(600); // Entra en el índice 1 reciclado
        cola.mostrar();

        // comprobación de cola nuevamente llena
        System.out.println("\n-- Intento de inserción al alcanzar el tope de nuevo --");
        cola.encolar(700);
    }
}
