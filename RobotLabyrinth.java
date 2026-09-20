import java.util.Random;

public class RobotLabyrinth {

    static int[][] lab = new int[20][20];
    static int r = 0;
    static int c = 0;

    public static void main(String[] args) {

        Random rand = new Random();

        // fill array with random numbers 1 to 9
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                lab[i][j] = rand.nextInt(9) + 1;
            }
        }

        // robot movement
        while (true) {

            int max = 0;
            int newR = r;
            int newC = c;

            // up
            if (r - 1 >= 0 && lab[r - 1][c] > max) {
                max = lab[r - 1][c];
                newR = r - 1;
                newC = c;
            }

            // down
            if (r + 1 < 20 && lab[r + 1][c] > max) {
                max = lab[r + 1][c];
                newR = r + 1;
                 newC = c;
            }

            // left
            if (c - 1 >= 0 && lab[r][c - 1] > max) {
                max = lab[r][c - 1];
                newR = r;
                newC = c - 1;
            }

            // right
            if (c + 1 < 20 && lab[r][c + 1] > max) {
                max = lab[r][c + 1];
                newR = r;
                newC = c + 1;
            }

            // stop condition
            if (max == 0) {
                break;
            }

            // previous cell becomes zero
            lab[r][c] = 0;

            // move robot
            r = newR;
            c = newC;
        }

        // print final labyrinth
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(lab[i][j] + " ");
            }
            System.out.println();
        }
    }
}
