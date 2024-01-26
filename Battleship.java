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

    static boolean inOneLine(final Coordinate start, final Coordinate end) {
        if (start.column() == end.column()) {
            return true;
        } else if (start.row() == end.row()) {
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
        int r = temp - 65;
        int c;
        if (input.length() == 2) {
            c = input.charAt(1);
        } else {
            c = SIZE - 1;
        }
        return new Coordinate(c, r);
    }

    static boolean isValidCoordinate(final String input) {
        String temp = input.toUpperCase();
        char letter = temp.charAt(0);
        if (letter >= 65 && letter <= 90) {
            temp = temp.substring(1);
            if (Integer.parseInt(temp) >= 1 && Integer.parseInt(temp) <= 10) {
                return true;
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
}