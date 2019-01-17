/**
 *
 * @author arman
 */
package main;

public class Main {

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3,3);
        Matrix matrix2 = new Matrix(3,2);
        Matrix matrix3;
        
        // 3 X 3 matrices
        matrix1.storeData();
        matrix1.printMatrix();
        matrix2.storeData();
        matrix2.printMatrix();
        
        matrix3 = matrix1.multiply(matrix1, matrix2);
        matrix3.printMatrix();
        
    }
}
