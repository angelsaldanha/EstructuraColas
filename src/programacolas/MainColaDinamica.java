package programacolas;

/**
 * Prueba independiente para la Cola Dinámica.
 * Demuestra la flexibilidad de tamaño sin límites predefinidos,
 * el conteo iterativo con contarElementos() y la consulta con peek().
 */
public class MainColaDinamica {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       Prueba: Cola Dinámica (Nodos Enlazados)    ");
        System.out.println("==================================================");

        ColaDinamica cola = new ColaDinamica();
        System.out.println("¿Está vacía al inicio?: " + cola.estaVacia());
        System.out.println("Total de nodos iniciales: " + cola.contarElementos());

        // inserción de nodos
        System.out.println("\n-- Encolando elementos --");
        cola.encolar(1000);
        cola.encolar(2000);
        cola.encolar(3000);
        cola.encolar(4000);

        System.out.println("\nEstado actual:");
        cola.mostrar();
        System.out.println("Nodos activos contados con recorrido: " + cola.contarElementos());
        System.out.println("Elemento al frente (peek): " + cola.peek());

        // Desencolado parcial
        System.out.println("\n-- Desencolando dos elementos --");
        cola.desencolar();
        cola.desencolar();

        System.out.println("\nEstado actual tras extracciones:");
        cola.mostrar();
        System.out.println("Nodos activos contados con recorrido: " + cola.contarElementos());
        System.out.println("Nuevo elemento al frente (peek): " + cola.peek());

        // vaciado total de la cola
        System.out.println("\n-- Vaciando la cola por completo --");
        cola.desencolar();
        cola.desencolar();
        cola.mostrar();
        System.out.println("¿Está vacía?: " + cola.estaVacia());
        System.out.println("Total de nodos activos: " + cola.contarElementos());

        // intento de extracción sobre cola vacía
        System.out.println("\n-- Prueba de extracción en cola vacía --");
        cola.desencolar();
    }
}
