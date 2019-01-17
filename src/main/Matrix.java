package main;

/**
 *
 * @author arman
 */
import java.util.Scanner;
        
public class Matrix {
    private int rows;
    private int columns;
    private int sum;
    private String type;
    private int[][] origin;
    private int matrix[][];
    
    // default constructor
    public Matrix(){
        
    }
    
    // Constructor
    public Matrix(int _rows, int _columns){
        rows = _rows;
        columns = _columns;
        matrix = new int[rows][columns];
        origin = new int[rows][columns];
    }
    
    public void storeData(){
        Scanner input = new Scanner (System.in);
        int value;
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print("Insert value at ["+i+"]["+j+"]: ");
                value = input.nextInt();
                matrix[i][j] = value;
                origin[i][j] = value;
            }
        }
    }
    
    public void storeData(String fileName){
        
    }
    
    public void transpose(){
        setSize(columns, rows);
        
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] = origin[j][i];
            }
        }        
    }
    
    // returns the transposed matrix
    public Matrix getTranspose(){
        int _rows = columns;
        int _columns = rows;
        Matrix temp = new Matrix(_rows, _columns);
        
        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                temp.matrix[i][j] = matrix[j][i];
            }
        }
        return temp;
    }
    
    // Prints the matrix
    public void printMatrix(){
        System.out.println();
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    // Adds op2 to current matrix object that must be of equal size
    public void add(Matrix op2){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] += op2.matrix[i][j];
            }
        }
        System.out.println("\n"+ matrix.length);
    }
    
    /***************************************************************************
    * Takes two matrices of the same size and returns the addition of the two
    ***************************************************************************/
    public Matrix add(Matrix op1, Matrix op2){
        Matrix temp = null;
        int _row1 = op1.getSize()[0];
        int _row2 = op2.getSize()[0];
        int _column1 = op1.getSize()[1];
        int _column2 = op2.getSize()[1];
        
        if ( (_row1 == _row2) && (_column1 == _column2) ){
            temp = new Matrix(_row2, _column2);
            for(int i = 0; i < _row1; i++){
                for (int j = 0; j < _column1; j++){
                    temp.matrix[i][j] = (op1.matrix[i][j] + op2.matrix[i][j]);
                }
            }
        }
        else{
            System.err.println("Error, incompatible sizes");
        }
        return temp;
    }
    
    /***************************************************************************
    * Takes two matrices and performs subtraction and returns a matrix object
    * op1 is subtracted from op2.
    * Both matrices must be of equal size.
    * *************************************************************************/
    public Matrix subtract(Matrix op1, Matrix op2){
        int _rows = op1.getSize()[0];
        int _columns = op1.getSize()[1];
        Matrix temp = new Matrix(_rows, _columns);
        
        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                temp.matrix[i][j] = op2.matrix[i][j] - op1.matrix[i][j];
            }
        }
        return temp;
    }
    
    /***************************************************************************
    * Subtract op1 from current matrix object
    * They must have equal sizes
    ***************************************************************************/
    public void subtract(Matrix op1){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                matrix[i][j] -= op1.matrix[i][j];
            }
        }
    }
    
    // returns an array of two elements, number of rows and columns
    public int[] getSize(){
        int[] _size = {rows, columns};
        return _size;
    }
    
    // sets the number of rows and columns
    public void setSize(int _rows, int _columns){
        rows = _rows;
        columns =_columns;
    }
    
    // Performs matrix multiplication
    public Matrix multiply(Matrix op1, Matrix op2){
        int[] _size = getSmallerMatrix(op1, op2);
        Matrix temp = new Matrix(_size[0], _size[1]);
        
        if (op1.columns == op2.rows){
            for (int i = 0; i < op1.getSize()[0]; i++){
                for (int j = 0; j < op2.getSize()[1]; j++){
                    temp.matrix[i][j] = 0;
                    for (int k = 0; k < op1.getSize()[1]; k++){
                        temp.matrix[i][j] += op1.matrix[i][k] * op2.matrix[k][j];
                    }
                }
            }
        }
        return temp;
    }
    
    // Multiply all elements in op2 by op1 and returns a new Matrix object
    public Matrix elementWiseMultiplication(int op1, Matrix op2){
        int _rows = op2.getSize()[0];
        int _columns = op2.getSize()[1];
        Matrix temp = new Matrix(_rows, _columns);
        
        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                temp.matrix[i][j] = op1 * op2.matrix[i][j];
            }
        }
        return temp;
    }
    
    // Given two matrices return size of smaller matrix
    public int[] getSmallerMatrix(Matrix op1, Matrix op2){
        int[] temp = new int[2];
        if ((op1.rows <= op2.rows) && (op1.columns <= op2.columns)){
            temp[0] = op1.rows;
            temp[1] = op1.columns;
        }
        else if ((op2.rows <= op1.rows) && (op2.columns <= op1.columns)) {
            temp[0] = op2.rows;
            temp[1] = op2.columns;
        }
        return temp;
    }
}