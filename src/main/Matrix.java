package main;

/**
 *
 * @author Armand Moussaouyi 
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Matrix {
    private int rows;
    private int columns;
    private int[][] origin;
    private int matrix[][];
    private double[][] double_matrix;
    private String type;
    
    // default constructor
    public Matrix(){
        
    }
    
    /***************************************************************************
     * Overload constructor to get number of rows, columns and data from a file
     * Takes a file name and store the data in a new matrix object
     * The matrix size does not need to be predefined
     * @param fileName
     **************************************************************************/
    public Matrix(String fileName){
        
        java.io.File file = new java.io.File(fileName);
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileName));
            Scanner input = new Scanner(file);
            columns = (input.nextLine().split(" ")).length;  // get the number of columns
            int count = 0;                                   // keeps track of number of rows
            
            while (read.readLine() != null){
                count++;                                     // Update number of rows
                System.out.println("count: " + count);
            }
            read.close();
            rows = count;                                    // assign number of rows
            
            // store file data in the new matrix
            while (input.hasNext()){                         
                for (int i = 0; i < rows; i++){
                    for (int j = 0; j < columns; j++){
                        matrix[i][j] = input.nextInt();
                        origin[i][j] = matrix[i][j];
                    }
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /***************************************************************************
     * Constructor
     * @param _rows
     * @param _columns 
     **************************************************************************/
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
    
    /***************************************************************************
     * Overloading storeData method to take a matrix from a file
     * The file must have predefined number of rows and columns matching the
     * created object
     * @param fileName 
     **************************************************************************/
    public void storeData(String fileName){
        java.io.File file = new java.io.File(fileName);
        try {
            Scanner input = new Scanner(file);
            
            while (input.hasNext()){
                for (int i = 0; i < rows; i++){
                    for (int j = 0; j < columns; j++){
                        matrix[i][j] = input.nextInt();
                        origin[i][j] = matrix[i][j];
                    }
                }
            }
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found");
        }
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
     * @param op1
     * @param op2
     * @return temp
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
            System.err.println("Incompatible sizes");
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
     * @param op1
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