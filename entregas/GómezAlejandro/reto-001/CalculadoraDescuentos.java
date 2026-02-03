import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

        while (true) {
            System.out.println("[1] Realizar Nueva Compra");
            System.out.println("[2] Salir");
            System.out.print("Opcion: ");
            int opcionMenu = sc.nextInt();
            sc.nextLine();

            if (opcionMenu == 2) {
                System.out.println("Saliendo del sistema.");
                break;
            }
            if (opcionMenu != 1) {
                System.out.println("Opcion no valida.");
                continue;
            }

            String[] nombresProductos = new String[10];
            double[] preciosProductos = new double[10];
            int[] cantidadesProductos = new int[10];
            int numeroProductos = 0;

            System.out.println("Carrito de Compra");
            while (numeroProductos < 10) {
                System.out.print("Nombre del producto (o 'fin'): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) break;

                nombresProductos[numeroProductos] = nombre;

                System.out.print("Precio de '" + nombre + "': ");
                preciosProductos[numeroProductos] = sc.nextDouble();

                System.out.print("Cantidad de '" + nombre + "': ");
                cantidadesProductos[numeroProductos] = sc.nextInt();
                sc.nextLine();

                numeroProductos++;
            }

            if (numeroProductos == 0) {
                System.out.println("Carrito vacio.");
                continue;
            }

            double precioTotal = 0;
            int cantidadTotal = 0;
            for (int i = 0; i < numeroProductos; i++) {
                precioTotal += preciosProductos[i] * cantidadesProductos[i];
                cantidadTotal += cantidadesProductos[i];
            }

            System.out.print("Tipo cliente (1-4): ");
            int tipoCliente = sc.nextInt();

            System.out.print("Rebajas (s/n): ");
            char rebajas = sc.next().charAt(0);

            double precioFinal = precioTotal;

            if (tipoCliente == 1) {
                if (rebajas == 's') precioFinal -= precioFinal * 0.10;
                if (cantidadTotal >= 5) precioFinal -= precioFinal * 0.05;
            } else if (tipoCliente == 2) {
                precioFinal -= precioFinal * 0.15;
                if (rebajas == 's') precioFinal -= precioFinal * 0.10;
                if (cantidadTotal >= 3) precioFinal -= precioFinal * 0.08;
            } else if (tipoCliente == 3) {
                precioFinal -= precioFinal * 0.20;
                if (rebajas == 's') precioFinal -= precioFinal * 0.15;
                if (cantidadTotal >= 2) precioFinal -= precioFinal * 0.10;
            } else if (tipoCliente == 4) {
                precioFinal -= precioFinal * 0.30;
                if (rebajas == 's') precioFinal -= precioFinal * 0.20;
                if (cantidadTotal >= 1) precioFinal -= precioFinal * 0.15;
            }

            if (precioFinal > 500) {
                precioFinal -= 50;
            }

            System.out.println("Precio final: " + precioFinal);
        }

        sc.close();
    }
}
