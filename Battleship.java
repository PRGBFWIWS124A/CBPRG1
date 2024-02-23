import java.nio.charset.CoderResult;

public class Battleship {
    final static int SIZE = 10;
    final static String ENTER_SHIP_COORDINATE_PROMPT = "Geben sie die %s für ein Schiff der Länge %d ein: ";

    static void main(String[] args) {

    }

    static int distance(final Coordinate start, final Coordinate end) {
        return Math.abs(start.row() - end.row()) + Math.abs(start.column() - end.column());
    }

    static Coordinate getRandomCoordinate() {
        return new Coordinate(Utility.getRandomInt(SIZE), Utility.getRandomInt(SIZE));
    }

    // Kürzere Schreibweise:
    // static boolean  inOneLine(final Coordinate start, final Coordinate end) {
    // return (start.column() == end.column() || start.row == end.wor());
    // }
    //Einfach die Bedingung die normalerweise in die Klammer der If-Abfrage kommt hinter das return schreiben.
    static boolean inOneLine(final Coordinate start, final Coordinate end) {
        if (start.column() == end.column() || start.row() == end.row()) {
            return true;
        } else {
            return false;
        }
    }

    static void showSeparatorLane() {
        System.out.println("   +-+-+-+-+-+-+-+-+-+-+      +-+-+-+-+-+-+-+-+-+-+");
    }

    static int getMaxSurroundingColumn(final Coordinate start, final Coordinate end) {
        if (start.column() >= end.column()) {
            if (start.column() == SIZE - 1) {
                return SIZE - 1;
            } else {
                return start.column() + 1;
            }
        } else {
            if (end.column() == SIZE - 1) {
                return SIZE - 1;
            } else {
                return end.column() + 1;
            }
        }
    }

    static int getMinSurroundingColumn(final Coordinate start, final Coordinate end) {
        if (start.column() <= end.column()) {
            if (start.column() == 0) {
                return 0;
            } else {
                return start.column() - 1;
            }
        } else {
            if (end.column() == 0) {
                return 0;
            } else {
                return end.column() - 1;
            }
        }
    }

    static int getMaxSurroundingRow(final Coordinate start, final Coordinate end) {
        if (start.row() >= end.row()) {
            if (start.row() == SIZE - 1) {
                return SIZE - 1;
            } else {
                return start.row() + 1;
            }
        } else {
            if (end.row() == SIZE - 1) {
                return SIZE - 1;
            } else {
                return end.row() + 1;
            }
        }
    }

    static int getMinSurroundingRow(final Coordinate start, final Coordinate end) {
        if (start.row() <= end.row()) {
            if (start.row() == 0) {
                return 0;
            } else {
                return start.row() - 1;
            }
        } else {
            if (end.row() == 0) {
                return 0;
            } else {
                return end.row() - 1;
            }
        }
    }

    static Coordinate toCoordinate(final String input) {
        char temp = input.toUpperCase().charAt(0);
        int c = temp - 65;
        int r;
        if (input.length() == 2) {
            r = input.charAt(1) - 1;
        } else {
            r = SIZE - 1;
        }
        return new Coordinate(c, r);
    }

    static boolean isValidCoordinate(final String input) {
        if (input.length() >= 2) {
            String temp = input.toUpperCase();
            char letter = temp.charAt(0);
            if (letter >= 'A' && letter <= 'J') {
                temp = temp.substring(1);
                if (Integer.parseInt(temp) >= 1 && Integer.parseInt(temp) <= 10) {
                    return true;
                }
            }
        }
        return false;
    }


    static String getStartCoordinatePrompt(final int length) {
        return String.format(ENTER_SHIP_COORDINATE_PROMPT, "Startkoordinaten", length);
    }

    static String getEndCoordinatePrompt(final int length) {
        return String.format(ENTER_SHIP_COORDINATE_PROMPT, "Endkoordinaten", length);
    }

    static void showRowNumber (final int row) {
        if (row <= 8) {
            int temp = row + 1;
            System.out.print(" " + temp);
        }
        else {
            System.out.print("10");
        }
    }

    static Coordinate getRandomEndCoordinate(final Coordinate start, final int distance) {
        boolean tf = false;
        while (!tf) {
            int temp = Utility.getRandomInt(4);
            switch (temp) {
                case 0:
                    if ((start.row() - distance) >= 0) {
                        return new Coordinate(start.column(), (start.row() - distance));
                    }
                    break;
                case 1:
                    if ((start.row() + distance) <= SIZE - 1) {
                        return new Coordinate(start.column(), (start.row() + distance));
                    }
                    break;
                case 2:
                    if ((start.column() - distance) >= 0) {
                        return new Coordinate((start.column() - distance), start.row());
                    }
                    break;
                case 3:
                    if ((start.column() + distance) <= SIZE - 1) {
                        return new Coordinate((start.column() + distance), start.row());
                    }
                    break;
            }
        }
        return null;
    }

    static void showField(final Field field, final boolean showShips) {
        switch (field) {
            case FREE:
                System.out.print("o");
                break;
            case SHIP:
                if (!showShips) {
                    System.out.print(" ");
                } else {
                    System.out.print("o");
                }
                break;
            case SHIP_HIT:
                System.out.print("*");
                break;
            case WATER_HIT:
                System.out.print("x");
                break;
        }
    }

    static void shot(final Coordinate shot, final Field[][] field) {
        if (field[shot.column()][shot.row()] == Field.FREE) {
            field[shot.column()][shot.row()] = Field.WATER_HIT;
        } else if (field[shot.column()][shot.row()] == Field.SHIP) {
            field[shot.column()][shot.row()] = Field.SHIP_HIT;
        }
    }

    static void placeShip (final Coordinate start, final Coordinate end, final Field[][] field) {
        if (start.row() == end.row()) {
            if (start.column() < end.column()) {
                for (int i = start.column(); i < end.column(); i++) {
                    field[i][start.row()] = Field.SHIP;
                }
            } else {
                for (int i = end.column(); i < start.column(); i++) {
                    field[i][start.row()] = Field.SHIP;
                }
            }
        } else {
            if (start.row() < end.row()) {
                for (int i = start.row(); i < end.row(); i++) {
                    field[start.column()][i] = Field.SHIP;
                }
            } else {
                for (int i = end.row(); i < start.row(); i++) {
                    field[start.column()][i] = Field.SHIP;
                }
            }
        }
    }

    static void showRow(final int row, final Field[][] ownField, final Field[][] otherField) {
        showRowNumber(row);
        System.out.print(" |");
        for (int i = 0; i < SIZE - 1; i++) {
            showField(ownField[i][row], true);
            System.out.print("|");
        }
        System.out.print("   ");
        showRowNumber(row);
        for (int i = 0; i < SIZE - 1; i++) {
            showField(otherField[i][row], false);
            System.out.println("|");
        }
    }

    static void showFields(final Field[][] ownField, final Field[][] otherField) {
        System.out.println("    A B C D E F G H I J        A B C D E F G H I J");
        showSeparatorLane();
        for (int i = 0; i < SIZE - 1; i++) {
            showRow(i, ownField, otherField);
        }
        showSeparatorLane();
        System.out.println(" ");
    }

    static boolean shipSunk(final Coordinate shot, final Field[][] field) {

    }
}