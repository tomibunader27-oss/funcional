package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MainProducto {
    public static void main(String[] args) {

        List<Producto> productos = List.of(
                new Producto("Mouse", "Tecnología", 150.0, 30),
                new Producto("Teclado", "Tecnología", 120.0, 15),
                new Producto("Silla Gamer", "Muebles", 350.0, 5),
                new Producto("Escritorio", "Muebles", 200.0, 8),
                new Producto("Cuaderno", "Papelería", 50.0, 40),
                new Producto("Lápiz", "Papelería", 30.0, 100)
        );

        System.out.println("==== Caso Práctico 2: Producto ====\n");


        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList();

        System.out.println("1. Productos con precio > 100 (ordenados desc):");
        caros.forEach(System.out::println);
        System.out.println();


        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println("2. Stock total por categoría:");
        stockPorCategoria.forEach((cat, stock) ->
                System.out.println(cat + " → " + stock + " unidades"));
        System.out.println();


        String resumen = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));

        System.out.println("3. Resumen de productos (nombre y precio):");
        System.out.println(resumen);
        System.out.println();


        double promedioGeneral = productos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));

        System.out.println("4. Precio promedio general: $" + promedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("   Promedio por categoría:");
        promedioPorCategoria.forEach((cat, prom) ->
                System.out.println("   " + cat + " → $" + prom));

        System.out.println("\n==== Fin del programa ====");
    }
}
