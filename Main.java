package hanoi;

import java.util.Scanner;

public class Main {
    // Programa principal: pide número de discos y permite jugar manualmente
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        // Validar que solo ingrese números válidos
        while (n < 1) {
            System.out.print("¿Cuántos discos quieres usar? (solo número): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 1) {
                    System.out.println("Debe ser al menos 1.");
                    n = 0;
                }
            } else {
                System.out.println("Entrada inválida, escribe un número.");
                sc.next();
            }
        }
        sc.nextLine();

        HanoiGame game = new HanoiGame(n);

        // Ciclo principal del juego
        while (true) {
            game.imprimir();

            if (game.resuelto()) {
                System.out.println("Ganaste en " + game.getPasos() + " movimientos");
                break;
            }

            System.out.print("Movimiento (ej. A C) o 'q' para salir: ");
            String mov = sc.nextLine().trim().toUpperCase();
            if (mov.equals("Q")) break;
            if (mov.length() == 2) {
                String error = game.mover(mov.charAt(0), mov.charAt(1));
                if (error != null) System.out.println("Error: " + error);
            } else {
                System.out.println("Formato inválido, usa dos letras como AC o A C.");
            }
        }
        sc.close();
    }
}
