package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MainEmpleado {
    public static void main(String[] args) {

        List<Empleado> empleados = List.of(
                new Empleado("Ana", "Ventas", 2500, 30),
                new Empleado("Luis", "IT", 3200, 28),
                new Empleado("Carla", "Ventas", 1800, 35),
                new Empleado("Pedro", "IT", 4000, 25),
                new Empleado("Lucía", "RRHH", 2100, 40),
                new Empleado("Martín", "RRHH", 2300, 26)
        );

        System.out.println("==== Caso Práctico 4: Empleado ====\n");

        List<Empleado> bienPagados = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .toList();

        System.out.println("1. Empleados con salario > 2000 (ordenados desc):");
        bienPagados.forEach(System.out::println);
        System.out.println();

        double promedioSalario = empleados.stream()
                .collect(Collectors.averagingDouble(Empleado::getSalario));

        System.out.println("2. Salario promedio general: $" + promedioSalario);
        System.out.println();

        Map<String, Double> salarioPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("3. Suma total de salarios por departamento:");
        salarioPorDepto.forEach((depto, suma) ->
                System.out.println(depto + " → $" + suma));
        System.out.println();

        List<String> masJovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .toList();

        System.out.println("4. Los 2 empleados más jóvenes:");
        masJovenes.forEach(System.out::println);

        System.out.println("\n==== Fin del programa ====");
    }
}

