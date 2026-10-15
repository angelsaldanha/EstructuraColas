# Práctica: Colas Estáticas (Lineal y Circular) y Dinámicas en Java

Implementación y análisis comparativo de la estructura de datos lineal **Cola (Queue)** bajo la disciplina **FIFO (First In, First Out)**, explorando tres variantes de almacenamiento: estática lineal sobre arreglo contiguo, estática circular con aritmética modular, y dinámica mediante nodos enlazados.

---

## Estructura del Proyecto

El código está organizado de manera modular bajo el paquete `programacolas`, manteniendo una clase ejecutable independiente (`Main`) para cada una de las variantes:

```text
EstructuraColas/
├── src/
│   └── programacolas/
│       ├── ColaEstatica.java          # Cola lineal sobre arreglo de tamaño fijo
│       ├── ColaEstaticaCircular.java  # Cola circular con reciclaje modular de índices
│       ├── ColaDinamica.java          # Cola enlazada con apuntadores frente y fin
│       ├── Nodo.java                  # Clase base para el almacenamiento enlazado
│       ├── MainColaEstatica.java      # Ejecutable independiente de la cola lineal
│       ├── MainColaCircular.java      # Ejecutable independiente de la cola circular
│       └── MainColaDinamica.java      # Ejecutable independiente de la cola dinámica
└── README.md
```

---

## Diferencias Conceptuales: Lineal, Circular y Dinámica

* **Cola Estática Lineal:** Almacena sus datos en posiciones continuas de un arreglo. Utiliza dos índices: `frente` y `fin`. Su principal limitante es el **desbordamiento artificial**: a medida que los datos se extraen, las posiciones al inicio quedan vacías, pero si `fin` alcanza el límite del arreglo, no permite más inserciones a pesar de haber memoria libre.
* **Cola Estática Circular:** Utiliza el mismo bloque continuo de memoria fija, pero resuelve el desbordamiento artificial aplicando aritmética modular `(posicion + 1) % capacidad`. Esto permite que el puntero `fin` vuelva a la posición `0` cuando haya espacio disponible al inicio, optimizando al 100% el tamaño del arreglo sin desplazar elementos.
* **Cola Dinámica:** Implementada mediante nodos enlazados en memoria discontinua (Heap). No posee un límite fijo previo de almacenamiento; su crecimiento y reducción dependen directamente de la memoria RAM disponible. Mantiene una referencia al `frente` para extracciones en tiempo constante O(1) y una al `fin` para inserciones en O(1), requiriendo un pequeño consumo extra de memoria por nodo para almacenar la referencia `siguiente`.

---

## Compilación y Ejecución

### Opción 1: Desde la Terminal (CLI)
Situarse en el directorio raíz del proyecto (`EstructuraColas`):

1. **Compilar todos los módulos:**
```bash
javac -d bin src/programacolas/*.java
```

2. **Ejecutar cada variante de forma independiente:**
* **Cola Estática Lineal:**
```bash
java -cp bin programacolas.MainColaEstatica
```
* **Cola Estática Circular:**
```bash
java -cp bin programacolas.MainColaCircular
```
* **Cola Dinámica:**
```bash
java -cp bin programacolas.MainColaDinamica
```

### Opción 2: Desde IntelliJ IDEA
1. Abrir la carpeta raíz `EstructuraColas`.
2. Navegar en el árbol de directorios a `src/programacolas/`.
3. Hacer clic derecho sobre cualquiera de las clases principales (`MainColaEstatica.java`, `MainColaCircular.java` o `MainColaDinamica.java`) y seleccionar **Run 'Main...'**.

---

## Resultados de Ejecución (Consola)

### 1. Salida: Cola Estática Lineal (`MainColaEstatica`)
```text
==================================================
       Prueba: Cola Estática Lineal (Arreglo)
==================================================
¿Está vacía al inicio?: true

-- Inserciones iniciales --
 -> Encolado: 10
 -> Encolado: 20
 -> Encolado: 30
 -> Encolado: 40

¿Está llena?: true
 Contenido [frente -> fin]: [10] -> [20] -> [30] -> [40]

Elemento al frente (peek): 10

-- Prueba de desbordamiento --
[Aviso] Cola llena: no se pudo insertar 50.

-- Extracción de elementos --
 <- Desencolado: 10
 <- Desencolado: 20
 Contenido [frente -> fin]: [30] -> [40]

Nuevo elemento al frente (peek): 30

-- Desbordamiento artificial --
Aunque hay dos casillas libres al inicio, 'fin' no puede avanzar más:
[Aviso] Cola llena: no se pudo insertar 60.

Process finished with exit code 0
```

### 2. Salida: Cola Estática Circular (`MainColaCircular`)
```text
==================================================
      Prueba: Cola Estática Circular (Arreglo)
==================================================
¿Está vacía al inicio?: true

-- Inserción hasta capacidad máxima (4 elementos) --
 -> Encolado: 100 (índice: 0, activos: 1)
 -> Encolado: 200 (índice: 1, activos: 2)
 -> Encolado: 300 (índice: 2, activos: 3)
 -> Encolado: 400 (índice: 3, activos: 4)

¿Está llena?: true
 Contenido circular [frente -> fin]: [100] -> [200] -> [300] -> [400] | Activos: 4/4

Elemento al frente (peek): 100

-- Extracción de dos elementos --
 <- Desencolado: 100 (activos restantes: 3)
 <- Desencolado: 200 (activos restantes: 2)
 Contenido circular [frente -> fin]: [300] -> [400] | Activos: 2/4

Nuevo frente tras extracciones (peek): 300

-- Inserción aprovechando el espacio liberado al inicio --
 -> Encolado: 500 (índice: 0, activos: 3)
 -> Encolado: 600 (índice: 1, activos: 4)
 Contenido circular [frente -> fin]: [300] -> [400] -> [500] -> [600] | Activos: 4/4

-- Intento de inserción al alcanzar el tope de nuevo --
[Aviso] Cola circular llena: no se pudo insertar 700.

Process finished with exit code 0
```

### 3. Salida: Cola Dinámica (`MainColaDinamica`)
```text
==================================================
       Prueba: Cola Dinámica (Nodos Enlazados)
==================================================
¿Está vacía al inicio?: true
Total de nodos iniciales: 0

-- Encolando elementos --
 -> Encolado: 1000
 -> Encolado: 2000
 -> Encolado: 3000
 -> Encolado: 4000

Estado actual:
 Frente -> [1000] [2000] [3000] [4000] <- Fin
Nodos activos contados con recorrido: 4
Elemento al frente (peek): 1000

-- Desencolando dos elementos --
 <- Desencolado: 1000
 <- Desencolado: 2000

Estado actual tras extracciones:
 Frente -> [3000] [4000] <- Fin
Nodos activos contados con recorrido: 2
Nuevo elemento al frente (peek): 3000

-- Vaciando la cola por completo --
 <- Desencolado: 3000
 <- Desencolado: 4000
 Estado: (vacía)
¿Está vacía?: true
Total de nodos activos: 0

-- Prueba de extracción en cola vacía --
[Error] Cola vacía: no hay elementos para desencolar.

Process finished with exit code 0
```