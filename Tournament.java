public class Tournament {

    static boolean finished (final TournamentNode root) {
        return root.winner() != null;
    }

    static TournamentNode setPoints (final TournamentNode node, final int points) {
        return new TournamentNode(node.left(), node.right(), node.winner(), points);
    }

    static int powerOf2(final int nonNegativeNumber) {
       if (nonNegativeNumber == 0) {
           return 1;
       } else {
           return (2 * powerOf2(nonNegativeNumber - 1));
       }
    }

    static int rowOffset(final int level, final int height) {
        return (powerOf2(height)/powerOf2(level));
    }

    static int getHeight(final TournamentNode node) {
        if (node.left() == null && node.right() == null) return 0;
        int right = 0;
        int left = 0;
        if (node.left() != null) return 1 + getHeight(node.left());
        if (node.right() != null) return 1 + getHeight(node.right());
        return Math.max(left, right);
    }

    static int countNames (final TournamentNode node) {
        int temp = 0;
        if (node.winner() != null) {
            temp = 1;
        }
        if (node.left() != null) {
            temp = temp + countNames(node.left());
        }
        if (node.right() != null) {
            temp = temp + countNames(node.right());
        }
        return temp;
    }

    static int getNumberOfLeaves (final TournamentNode node) {
        if (node.left() == null && node.right() == null) return 1;
        int temp = 0;
        if (node.left() != null) {
            temp = temp + getNumberOfLeaves(node.left());
        }
        if (node.right() != null) {
            temp = temp + getNumberOfLeaves(node.right());
        }
        return temp;
    }
}
