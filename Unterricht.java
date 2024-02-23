import java.util.Scanner;

public class Unterricht {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp = scanner.nextInt();
        if (temp % 2 == 0) {
            System.out.println("Die Zahl ist gerade!");
        }
        else {
            System.out.println("Die Zahl ist ungerade!");
        }
    }

    static void weekday (int num) {
        switch (num) {
            case 1:
                System.out.println("Montag");
                break;
            case 2:
                System.out.println("Dienstag");
                break;
            case 3:
                System.out.println("Mittwoch");
                break;
            case 4:
                System.out.println("Donnerstag");
                break;
            case 5:
                System.out.println("Freitag");
                break;
            case 6:
                System.out.println("Samstag");
                break;
            case 7:
                System.out.println("Sonntag");
                break;
        }
    }

    static void weekday_if (int num) {
        if (num == 1) {
            System.out.println("Montag");
        } else if (num == 2) {
            System.out.println("Dienstag");
        } else if (num == 3) {
            System.out.println("Mittwoch");
        } else if (num == 4) {
            System.out.println("Donnerstag");
        } else if (num == 5) {
            System.out.println("Freitag");
        } else if (num == 6) {
            System.out.println("Samstag");
        } else if (num == 7) {
            System.out.println("Sonntag");
        } else {
            System.out.println("Es kann kein Wochentag zugeordnet werden");
        }
    }

    static void month (int num) {
        switch (num) {
            case 1:
                System.out.println("Januar");
                break;
            case 2:
                System.out.println("Februar");
                break;
            case 3:
                System.out.println("März");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("Mai");
                break;
            case 6:
                System.out.println("Juni");
                break;
            case 7:
                System.out.println("Juli");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("Oktober");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("Dezember");
                break;
        }
    }

    static String grade(final int points) {
        if (points >= 0 && points <= 49) {
            return "5,0";
        } else if (points >= 50 && points <= 58) {
            return "4,0";
        } else if (points >= 59 && points <= 66) {
            return "3,7";
        } else if (points >= 67 && points <= 71) {
            return "3,3";
        } else if (points >= 72 && points <= 76) {
            return "3,0";
        } else if (points >= 77 && points <= 80) {
            return "2,7";
        } else if (points >= 81 && points <= 84) {
            return "2,3";
        } else if (points >= 85 && points <= 88) {
            return "2,0";
        } else if (points >= 89 && points <= 91) {
            return "1,7";
        } else if (points >= 92 && points <= 96) {
            return "1,3";
        } else if (points >= 97 && points <= 100) {
            return "1,0";
        } else {
            return "Ungültige Punktzahl";
        }
    }

    static int max(final int[] array) {
        int temp = array[0];
        for(int i = 0; i < array.length; i++) {
            if (temp <= array[i]) {
                temp = array[i];
            }
        }
        return temp;
    }
}
