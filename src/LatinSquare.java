import java.util.stream.IntStream;

public class LatinSquare {

    // Calculates the target checksum by summing integers from 1 to N
    public static int targetCheckSum1(int rowSize) {
        return rowSize * (rowSize + 1) / 2;
    }

    // Calculates the target checksum by multiplying integers from 1 to N
    public static int targetCheckSum2(int rowSize) {
        int product = 1;
        for (int i = 1; i <=rowSize ; i++) {
            product *= i;
        }
        return product;
    }

    // Checks if each row in the 2D array matches the given checksums
    public static boolean isLatinRows(int[][] array2d, int checkSum1, int checkSum2) {
        for (int[] row : array2d) {
            int sum = 0;
            int product = 1;
            for (int value : row) {
                sum += value;
                product *= value;
            }
            if (sum != checkSum1 || product != checkSum2) {
                return false;
            }
        }
        return true;
    }

    // Checks if each column in the 2D array matches the given checksums
    public static boolean isLatinColumns(int[][] array2d, int checkSum1, int checkSum2) {
        int n = array2d.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int product = 1;
            for (int j = 0; j < n; j++) {
                sum += array2d[j][i];
                product *= array2d[j][i];
            }
            if (sum != checkSum1 || product != checkSum2) {
                return false;
            }
        }
        return true;
    }

    // Checks if the 2D array is a Latin square
    public static boolean isLatinSquare(int[][] array2d) {
        int n = array2d.length;
        int checkSum1 = targetCheckSum1(n);
        int checkSum2 = targetCheckSum2(n);
        return isLatinRows(array2d, checkSum1, checkSum2) && isLatinColumns(array2d, checkSum1, checkSum2);
    }

    public static void main(String[] args) {
        int[][] array2d = {
                {1, 3, 4, 2},
                {2, 4, 3, 1},
                {3, 1, 2, 4},
                {4, 2, 1, 3}
        };

        System.out.println("Target CheckSum1: " + targetCheckSum1(array2d.length));  // Output: 10
        System.out.println("Target CheckSum2: " + targetCheckSum2(array2d.length));  // Output: 24

        System.out.println("Is Latin Rows: " + isLatinRows(array2d, targetCheckSum1(array2d.length), targetCheckSum2(array2d.length)));  // Output: true
        System.out.println("Is Latin Columns: " + isLatinColumns(array2d, targetCheckSum1(array2d.length), targetCheckSum2(array2d.length)));  // Output: true
        System.out.println("Is Latin Square: " + isLatinSquare(array2d));  // Output: true
    }
}
