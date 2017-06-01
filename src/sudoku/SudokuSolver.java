package src.sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ericgumba on 5/23/17.
 */
public class SudokuSolver {

  public static int[][] solvedBoard = new int[9][9];
  public boolean potentialCandidate(int[][] board, int candidate, int row, int column){

    if ( row <= 2 && column <= 2 ){
      for (int i = 0; i <= 2; i++){
        for (int j = 0; j <= 2; j++){
          if ( board[i][j] == candidate )
            return false;
        }
      }
    } else if ( row <= 2 && column <= 5) {
      for (int i = 0; i <= 2; i++) {
        for (int j = 3; j <= 5; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }

    } else if ( row <= 2 && column <= 8) {
      for (int i = 0; i <= 2; i++) {
        for (int j = 6; j <= 8; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }

    } else if ( row <= 5 && column <= 2 ) {
      for (int i = 3; i <= 5; i++) {
        for (int j = 0; j <= 2; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }

    } else if ( row <= 5 && column <= 5 ) {
      for (int i = 3; i <= 5; i++) {
        for (int j = 3; j <= 5; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }
    } else if ( row <= 5 && column <= 8 ){
      for (int i = 3; i <= 5; i++) {
        for (int j = 6; j <= 8; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }
    }  else if ( row <= 8 && column <= 2 ) {
      for (int i = 6; i <= 8; i++) {
        for (int j = 0; j <= 2; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }
    } else if ( row <= 8 && column <= 5 ) {
      for (int i = 6; i <= 8; i++) {
        for (int j = 3; j <= 5; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }

    } else if ( row <= 8 && column <= 8 ){
      for (int i = 6; i <= 8; i++) {
        for (int j = 6; j <= 8; j++) {
          if (board[i][j] == candidate)
            return false;
        }
      }
    }

    for (int i = 0; i < 9; i++){
      if ( candidate == board[row][i] ) {
        return false;
      }
    }
    for (int i = 0; i < 9; i++) {
      if ( candidate == board[i][column] ) {
        return false;
      }
    }
    return true;


  }

  public void solve(int[][] board){
    solved(board, 0, 0);
  }

  public void solved(int[][] board, int row, int column){

    boolean noMore;

      while (board[row][column] != 0 && (column != 8 || row != 8)) {
        if (column < 8) {
          column++;
        } else if (row < 8) {
          row++;
          column = 0;
        }
      }

      if (column == 8 && row == 8 && board[row][column] != 0) {
        printSolution(board);
      }
      // check to see if a number can be placed

      for (int i = 1; i < 10; i++) {


        if (potentialCandidate(board, i, row, column)) {

          board[row][column] = i;

          if (column == 8 && row == 8) {
            printSolution(board);
          } else if (column < 8) {
            solved(board, row, column + 1);
          } else {
            solved(board, row + 1, 0);
          }
        }
        board[row][column] = 0;
      }

  }

  public void printSolution(int[][] board){

    for(int i = 0; i < board.length; i++){
      System.out.println("\n \n ROW " + (i+1));
      for (int j = 0; j < board.length; j++){
        System.out.print(board[i][j] + " ");
        solvedBoard[i][j] = board[i][j];
      }
    }

  }

}
