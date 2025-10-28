package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class MainAlumno {
    public static void main(String[] args) {
                List<Alumno> alumnos = List.of(
                        new Alumno("Ana", 8.5, "Matemática"),
                        new Alumno("Luis", 6.0, "Historia"),
                        new Alumno("Carla", 9.0, "Matemática"),
                        new Alumno("Pedro", 7.5, "Historia"),
                        new Alumno("Lucía", 5.5, "Lengua")
                );

                System.out.println("==== Caso Práctico 1: Alumno ====\n");

                List<String> aprobados = alumnos.stream()
                        .filter(a -> a.getNota() >= 7)
                        .map(a -> a.getNombre().toUpperCase())
                        .sorted()
                        .toList();

                System.out.println("1. Alumnos aprobados en mayúsculas y ordenados:");
                System.out.println(aprobados + "\n");


                double promedio = alumnos.stream()
                        .mapToDouble(Alumno::getNota)
                        .average()
                        .orElse(0.0);

                System.out.println("2. Promedio general de notas:");
                System.out.println(promedio + "\n");


                Map<String, List<Alumno>> agrupadosPorCurso = alumnos.stream()
                        .collect(Collectors.groupingBy(Alumno::getCurso));

                System.out.println("3. Alumnos agrupados por curso:");
                agrupadosPorCurso.forEach((curso, lista) -> {
                    System.out.println(curso + " → " + lista);
                });
                System.out.println();


                List<Alumno> top3 = alumnos.stream()
                        .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                        .limit(3)
                        .toList();

                System.out.println("4. Top 3 alumnos con mejores notas:");
                top3.forEach(System.out::println);

                System.out.println("\n==== Fin del programa ====");
            }
    }
