/**
 *
 * @author arman
 */
package main;

public class Main {

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3,3);           // 3X3 matrix
        Matrix matrix2 = new Matrix(3,2);           // 3X2 matrix
        Matrix matrix3 = new Matrix(2,3);           // 2X3 matrix
        //Matrix matrix4 = new Matrix("C:/Users/arman/OneDrive/Desktop/Main/src/main/D.txt"); // file matrix

        matrix1.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/B.txt");
        matrix2.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/A.txt");
        matrix3.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/C.txt");
        
        matrix1.printMatrix();
        matrix2.printMatrix();
        matrix3.printMatrix();
        //matrix4.printMatrix();
        
    }
}