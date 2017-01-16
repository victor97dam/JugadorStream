package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by DAM on 19/12/16.
 */
public class Main {

    public static void main(String[] args) {

        List<Jugador> jugadores = new ArrayList<>();


        Equipo e1 = new Equipo("Lakers", "Los Angeles", LocalDate.of(1992, 2, 2));
        Equipo e2 = new Equipo("Barcelona", "Barcelona", LocalDate.of(1980, 9, 19));
        Equipo e3 = new Equipo("Real Madrid", "Madrid", LocalDate.of(1950, 5, 10));

        Jugador j1 = new Jugador("Mariano", LocalDate.of(1992, 2, 2), 34, 657, 756, "pivot", e1);
        Jugador j2 = new Jugador("Juan", LocalDate.of(1991, 4, 20), 537, 129, 23, "pivot", e2);
        Jugador j3 = new Jugador("Alfredo", LocalDate.of(1990, 10, 11), 34, 657, 756, "pivot", e3);
        Jugador j4 = new Jugador("Ruben", LocalDate.of(1997, 7, 12), 347, 789, 123, "alero", e1);
        Jugador j5 = new Jugador("Sergio", LocalDate.of(1982, 6, 9), 122, 912, 94, "alero", e2);
        Jugador j6 = new Jugador("Pau", LocalDate.of(1986, 11, 3), 853, 67, 1256, "alero", e3);
        Jugador j7 = new Jugador("Alis", LocalDate.of(1996, 8, 23), 344, 257, 233, "lateral", e1);
        Jugador j8 = new Jugador("Marta", LocalDate.of(1992, 3, 1), 1054, 699, 781, "lateral", e2);
        Jugador j9 = new Jugador("Ferran", LocalDate.of(1992, 1, 3), 34, 58, 78, "lateral", e3);

        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);
        jugadores.add(j5);
        jugadores.add(j6);
        jugadores.add(j7);
        jugadores.add(j8);
        jugadores.add(j9);


        List<Jugador> ej1 = jugadores.stream().filter(jugador -> jugador.getCanastastotales() > 500).collect(Collectors.toList());
        System.out.println("Jugadores con mas de 500 canastas");
        System.out.println(ej1);
        System.out.println();

        List<Jugador> ej2 = jugadores.stream().filter(jugador -> jugador.getCanastastotales() >= 200 && jugador.getCanastastotales() < 500).collect(Collectors.toList());
        System.out.println("Jugadores entre 200 y 500 canastas");
        System.out.println(ej2);
        System.out.println();

        List<String> ej3 = jugadores.stream().filter(jugador -> jugador.getCanastastotales()<=500 && jugador.getCanastastotales()>=200).map(Jugador::getNombre).collect(Collectors.toList());
        System.out.println("Nombre de los jugadores entre 200 y 500 canastas");
        System.out.println(ej3);
        System.out.println();

        List<Jugador> ej4 = jugadores.stream().sorted(Comparator.comparing(Jugador::getFechanacimiento)).collect(Collectors.toList());
        System.out.println("Jugadores ordenados por fecha de nacimiento");
        System.out.println(ej4);
        System.out.println();

        List<Jugador> ej5 = jugadores.stream().sorted(Comparator.comparing(Jugador::getCanastastotales)).collect(Collectors.toList());
        System.out.println("Jugadores ordenados por numero de canastas");
        System.out.println(ej5);
        System.out.println();

        List<Jugador> ej6 = jugadores.stream().sorted(Comparator.comparing(Jugador::getCanastastotales).reversed()).limit(5).collect(Collectors.toList());
        System.out.println("Top 5 más canastas");
        System.out.println(ej6);
        System.out.println();

        List<Jugador> ej7 = jugadores.stream().filter(jugador -> jugador.getCanastastotales()<=500 && jugador.getCanastastotales()>=200).sorted(Comparator.comparing(Jugador::getFechanacimiento).reversed()).collect(Collectors.toList());
        System.out.println("Jugadores entre 200 y 500 canastas ordenados por nacimiento");
        System.out.println(ej7);
        System.out.println();

        Jugador ej8 = jugadores.stream().min(Comparator.comparing(Jugador::getCanastastotales)).get();
        System.out.println("Jugador con menos canastas");
        System.out.println(ej8);
        System.out.println();

        Jugador ej9 = jugadores.stream().max(Comparator.comparing(Jugador::getCanastastotales)).get();
        System.out.println("Jugador con más canastas");
        System.out.println(ej9);
        System.out.println();

        double ej10 = jugadores.stream().mapToDouble(Jugador::getCanastastotales).average().getAsDouble();
        System.out.println("Media canastas de todos los jugadores");
        System.out.println(ej10);
        System.out.println();

        List<Jugador> ej11 = jugadores.stream().filter(jugador -> jugador.getEquipo().getLocalidad().equalsIgnoreCase("Barcelona")).collect(Collectors.toList());
        System.out.println("Jugadores de Barcelona");
        System.out.println(ej11);
        System.out.println();

        boolean ej12 = jugadores.stream().anyMatch(jugador -> jugador.getCanastastotales()>4000);
        System.out.println("Algun jugador con mas de 4000 canastas?");
        System.out.println(ej12);
        System.out.println();

        boolean ej13 = jugadores.stream().allMatch(jugador -> jugador.getCanastastotales()>50);
        System.out.println("Todos los jugadores tienen mas de 50 canastas?");
        System.out.println(ej13);
        System.out.println();

        boolean ej14 = jugadores.stream().filter(jugador -> jugador.getEquipo().getNombreequipo().equalsIgnoreCase("Lakers")).allMatch(jugador ->  jugador.getCanastastotales()>50);
        System.out.println("Los jugadores del primer equipo tienen mas de 50 canastas?");
        System.out.println(ej14);
        System.out.println();

        double ej15 = jugadores.parallelStream().mapToInt(Jugador::getCanastastotales).reduce(0, (a,b) -> a+b);
        System.out.println("Suma de todas las canastas");
        System.out.println(ej15);
        System.out.println();

        List<Jugador> ej16 = jugadores.parallelStream().filter(jugador -> jugador.getCanastastotales()<=500 && jugador.getCanastastotales()>=200)
                .sorted(Comparator.comparing(Jugador::getCanastastotales).thenComparing(Jugador::getFechanacimiento)).collect(Collectors.toList());
        System.out.println("Jugadores entre 200 y 500 canastas ordenados por canastas o por nacimiento");
        System.out.println(ej16);
        System.out.println();






    }
}
