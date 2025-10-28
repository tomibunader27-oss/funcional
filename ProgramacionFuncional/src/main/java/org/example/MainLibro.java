package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MainLibro {
    public static void main(String[] args) {

        List<Libro> libros = List.of(
                new Libro("El Quijote", "Cervantes", 950, 3000),
                new Libro("1984", "Orwell", 350, 1500),
                new Libro("Rebelión en la Granja", "Orwell", 180, 900),
                new Libro("Cien Años de Soledad", "García Márquez", 420, 2500),
                new Libro("Fahrenheit 451", "Bradbury", 290, 1200),
                new Libro("Rayuela", "Cortázar", 600, 2800)
        );

        System.out.println("==== Caso Práctico 3: Libro ====\n");

        List<String> titulos = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .toList();

        System.out.println("1. Libros con más de 300 páginas (ordenados alfabéticamente):");
        titulos.forEach(System.out::println);
        System.out.println();

        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);

        System.out.println("2. Promedio de páginas: " + promedioPaginas);
        System.out.println();

        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));

        System.out.println("3. Cantidad de libros por autor:");
        librosPorAutor.forEach((autor, cantidad) ->
                System.out.println(autor + " → " + cantidad + " libro(s)")
        );
        System.out.println();


        Libro masCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio))
                .orElse(null);

        System.out.println("4. Libro más caro:");
        System.out.println(masCaro);

        System.out.println("\n==== Fin del programa ====");
    }
}

