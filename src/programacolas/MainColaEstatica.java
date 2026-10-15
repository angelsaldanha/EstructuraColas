package programacolas;

/**
 * prueba independiente para la Cola Estática Lineal.
 * demuestra inserciones, extracciones, consulta con peek() y el
 * fenómeno de desbordamiento artificial al agotarse los índices del arreglo.
 */
public class MainColaEstatica {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       Prueba: Cola Estática Lineal (Arreglo)    ");
        System.out.println("==================================================");

        ColaEstatica cola = new ColaEstatica(4);
        System.out.println("¿Está vacía al inicio?: " + cola.estaVacia());

        // llenado de la cola hasta su límite
        System.out.println("\n-- Inserciones iniciales --");
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);
        cola.encolar(40);

        System.out.println("\n¿Está llena?: " + cola.estaLlena());
        cola.mostrar();

        // consulta del primer elemento sin retirarlo
        System.out.println("\nElemento al frente (peek): " + cola.peek());

        // intento de inserción con el arreglo lleno
        System.out.println("\n-- Prueba de desbordamiento --");
        cola.encolar(50);

        // desencolado de dos elementos
        System.out.println("\n-- Extracción de elementos --");
        cola.desencolar();
        cola.desencolar();
        cola.mostrar();

        System.out.println("\nNuevo elemento al frente (peek): " + cola.peek());

        // evidencia de limitación: 'fin' está en el tope físico, impidiendo reutilizar casillas libres
        System.out.println("\n-- Desbordamiento artificial --");
        System.out.println("Aunque hay dos casillas libres al inicio, 'fin' no puede avanzar más:");
        cola.encolar(60);
    }
}
