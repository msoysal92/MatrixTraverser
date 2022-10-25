package com.asml.matrix;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MatrixTraverserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final MatrixTraverser underTest = new MatrixTraverser();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void ShouldNot_PrintMatrix_WhenGivenArrayIsEmpty() {
        int matrix[][] = {{},{}};
        underTest.traverse(matrix);

        assertEquals("", outContent.toString());
    }

    @Test
    public void Should_PrintMatrix_WhenGivenArrayHasOnlyOneRow() {
        int matrix[][] = {{1,2,3,4}};
        underTest.traverse(matrix);

        assertEquals("1,2,3,4", outContent.toString());
    }

    @Test
    public void Should_PrintMatrix_WhenGivenArraysRowsAndColumnsSizeAreEqual() {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        underTest.traverse(matrix);

        assertEquals("1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10", outContent.toString());
    }

    @Test
    public void Should_PrintMatrix_WhenGivenArraysRowsAndColumnsSizeAreNotEqual() {
        int matrix[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
        underTest.traverse(matrix);

        assertEquals("1,2,3,4,5,6,12,18,17,16,15,14,13,7,8,9,10,11", outContent.toString());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void Should_ThrowException_WhenGivenArrayNotDeclaredCorrectly() {
        int matrix[][] = new int[0][0];
        underTest.traverse(matrix);
    }

}