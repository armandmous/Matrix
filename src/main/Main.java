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
        Matrix matrix4 = new Matrix("C:/Users/arman/OneDrive/Desktop/Main/src/main/D.txt"); // file matrix

        matrix1.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/B.txt");
        matrix2.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/A.txt");
        matrix3.storeData("C:/Users/arman/OneDrive/Desktop/Main/src/main/C.txt");
        
        matrix1.printMatrix();
        matrix2.printMatrix();
        matrix3.printMatrix();
        matrix4.printMatrix();
        
        // Adding two matrices of the same size.
        Matrix A = new Matrix();
        A = A.add(matrix2, matrix2);
        A.printMatrix();
        
        System.out.println();
        // get smaller matrix (As you can see it needs more work)
        int[] s_size1 = A.getSmallerMatrix(A, matrix4);
        System.out.println("smaller size: ["+ s_size1[0] + " , " + s_size1[1]+ "]");
        
        int[] s_size2 = A.getSmallerMatrix(A, matrix3);
        System.out.println("***smaller size: ["+ s_size2[0] + " , " + s_size2[1]+ "]");
        int[] s_size4 = A.getSmallerMatrix(matrix2, matrix3);
        System.out.println("***smaller size: ["+ s_size4[0] + " , " + s_size4[1]+ "]");
        
        int[] s_size3 = A.getSmallerMatrix(matrix2, matrix1);
        System.out.println("smaller size: ["+ s_size3[0] + " , " + s_size3[1]+ "]");
        
    }
}