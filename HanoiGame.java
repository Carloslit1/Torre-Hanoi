package hanoi;

import java.util.*;

public class HanoiGame {
    private Deque<Integer> A = new ArrayDeque<>();
    private Deque<Integer> B = new ArrayDeque<>();
    private Deque<Integer> C = new ArrayDeque<>();
    private int n, pasos = 0;

    // Constructor: inicializa la torre A con n discos
    public HanoiGame(int n) {
        this.n = n;
        for (int d = n; d >= 1; d--) {
            A.push(d);
        }
    }

    // Imprime el estado de cada torre (discos de abajo hacia arriba)
    public void imprimir() {
        System.out.println("\n--- Estado actual ---");
        System.out.println("Paso: " + pasos);
        System.out.println("A " + mostrar(A));
        System.out.println("B " + mostrar(B));
        System.out.println("C " + mostrar(C));
    }

    // Realiza un movimiento entre dos torres, validando reglas
    public String mover(char f, char t) {
        Deque<Integer> from = torre(f);
        Deque<Integer> to   = torre(t);
        if (from == null || to == null) return "Torre inválida (usa A, B o C)";
        if (from.isEmpty()) return "La torre " + f + " está vacía";
        int disco = from.peek();
        if (!to.isEmpty() && to.peek() < disco) return "No puedes poner " + disco + " sobre " + to.peek();
        from.pop();
        to.push(disco);
        pasos++;
        return null;
    }

    // Comprueba si todos los discos están en la torre C
    public boolean resuelto() {
        return C.size() == n;
    }

    // Devuelve los pasos realizados
    public int getPasos() {
        return pasos;
    }

    // Devuelve la pila según la letra
    private Deque<Integer> torre(char c) {
        switch (c) {
            case 'A': return A;
            case 'B': return B;
            case 'C': return C;
            default:  return null;
        }
    }

    // Convierte la pila en una lista de discos de abajo hacia arriba
    private String mostrar(Deque<Integer> p) {
        List<Integer> l = new ArrayList<>(p);
        Collections.reverse(l);
        return l.isEmpty() ? "[]" : l.toString();
    }
}
