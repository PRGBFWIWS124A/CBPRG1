import java.nio.charset.CoderResult;

public class Battleship {
    final static int SIZE = 10;

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
            if (start.column() == 9) {
                return 9;
            } else {
                return start.column() + 1;
            }
        } else {
            if (end.column() == 9) {
                return 9;
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
            if (start.row() == 9) {
                return 9;
            } else {
                return start.row() + 1;
            }
        } else {
            if (end.row() == 9) {
                return 9;
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
}