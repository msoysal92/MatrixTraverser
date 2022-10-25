package com.asml.matrix;

public class MatrixTraverser {

    /**
     * This method will traverse the 2D array. This performs clockwise manner scrolling and printing.
     *
     * @param matrix
     */
    public void traverse(int[][] matrix) {
        int bottomMostRow = 0, leftMostColumn = 0, topMostRow = matrix.length - 1, rightMostColumn = matrix[0].length - 1;
        int count = 1;
        int totalElementCount = matrix.length * matrix[0].length;

        while (count <= totalElementCount) {

            // Print first row from left most column to right most column
            int index = leftMostColumn;
            while (index <= rightMostColumn && count <= totalElementCount) {
                print(matrix[bottomMostRow][index], count, totalElementCount);
                index++;
                count++;
            }
            bottomMostRow++;

            // Print last column from bottom most row to top most row
            index = bottomMostRow;
            while (index <= topMostRow && count <= totalElementCount) {
                print(matrix[index][rightMostColumn], count, totalElementCount);
                index++;
                count++;
            }
            rightMostColumn--;

            // Print last row from right most column to left most column
            index = rightMostColumn;
            while (index >= leftMostColumn && count <= totalElementCount) {
                print(matrix[topMostRow][index], count, totalElementCount);
                index--;
                count++;
            }
            topMostRow--;

            // Print first column from top most row to bottom most row
            index = topMostRow;
            while (index >= bottomMostRow && count <= totalElementCount) {
                print(matrix[index][leftMostColumn], count, totalElementCount);
                index--;
                count++;
            }
            leftMostColumn++;
        }
    }

    public void print(int number, int count, int totalElementCount) {
        if (count == totalElementCount) {
            System.out.print(number);
        } else {
            System.out.print(number + ",");
        }
    }
}
