package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в компанию TAGYERS");
        System.out.println("Чем хотите воспользоваться?:");
        System.out.println("1. Проверка совершеннолетия");
        System.out.println("2. Расчет параметров квадрата");
        int vibor = scanner.nextInt();

        switch (vibor) {
            case 1:
                proverkaSovershennoletiya();
                break;
            case 2:
                raschetParametrovKvadrata();
                break;
            default:
                System.out.println("Не правильный выбор");
        }
    }

    public static void proverkaSovershennoletiya() {
        System.out.println("Привет! Введите количество людей для проверки:");
        int count = scanner.nextInt();

        Chelovek[] lyudi = new Chelovek[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Введите ФИО " + (i + 1) + ":");
            scanner.nextLine();
            String fio = scanner.nextLine();

            System.out.println("Введите дату рождения в формате год-месяц-день для человека " + (i + 1) + ":");
            String birthDateStr = scanner.nextLine();
            LocalDate birthDate = LocalDate.parse(birthDateStr);

            lyudi[i] = new Chelovek(fio, birthDate);
        }

        LocalDate today = LocalDate.now();

        for (Chelovek chelovek : lyudi) {
            System.out.println(chelovek.getFio() + ": " + (chelovek.isSovershennoletnii(today) ? "Совершеннолетний" : "Не совершеннолетний"));
        }
    }

    public static void raschetParametrovKvadrata() {
        System.out.println("Введите длину стороны квадрата:");
        double storona = scanner.nextDouble();

        double perimetr = raschetPerimetra(storona);
        double ploshchad = raschetPloshchadi(storona);
        double radius = raschetRadiusa(storona);

        System.out.println("Периметр квадрата: " + perimetr);
        System.out.println("Площадь квадрата: " + ploshchad);
        System.out.println("Радиус вписанной окружности в квадрат: " + radius);
    }

    public static double raschetPerimetra(double storona) {
        return 4 * storona;
    }

    public static double raschetPloshchadi(double storona) {
        return storona * storona;
    }

    public static double raschetRadiusa(double storona) {
        return storona / Math.sqrt(2);
    }
}

class pyple {
    private String fio;
    private LocalDate dataRozhdeniya;

    public pyple(String fio, LocalDate dataRozhdeniya) {
        this.fio = fio;
        this.dataRozhdeniya = dataRozhdeniya;
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getBirthDate() {
        return dataRozhdeniya;
    }

    public boolean isSovershennoletnii(LocalDate today) {
        LocalDate dataSovershennoletiya = dataRozhdeniya.plusYears(18);
        return !dataSovershennoletiya.isAfter(today);
    }
}
