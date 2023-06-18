// CSC 251
// U5: Project 3
// 12/01/2022
// Samia Kayass
// In this project we will create Java code that will validate
// the one-star puzzles and two-star puzzles game.


import java.util.ArrayList;



public class KayassTwoNotTouch {


    final static int ONE_STAR_NUMBER_CAGES = 8;
    final static int TWO_STAR_NUMBER_CAGES = 10;
    final static char STAR = '*';
    final static int CHAR_POS = 0;
    final static int CAGE_POS = 1;
    final static int ASCII_NUM_INDEX = 48;

    final static int ERROR_CODE_VALID = 0;
    final static int ERROR_CODE_INCORRECT_ROW_COUNT = 1;
    final static int ERROR_CODE_INCORRECT_COLUMN_COUNT = 2;
    final static int ERROR_CODE_INCORRECT_CAGE_COUNT = 3;
    final static int ERROR_CODE_HORIZONTAL_CONTACT = 4;
    final static int ERROR_CODE_VERTICAL_CONTACT = 5;
    final static int ERROR_CODE_DIAGONAL_CONTACT = 6;
    //***
    //***
    //***

    public static void main(String[] args) {


        //*** This is a valid one-star solution.
        char[][][] oneStarGridValid1 = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is a valid one-star solution.
        char[][][] oneStarGridValid2 = {
                {{STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {' ', '2'}, {' ', '2'}},
                {{' ', '0'}, {' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {STAR, '2'}, {' ', '2'}, {' ', '2'}},
                {{' ', '0'}, {STAR, '3'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {' ', '2'}, {' ', '2'}, {' ', '4'}},
                {{' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '1'}, {' ', '2'}, {' ', '2'}, {STAR, '4'}},
                {{' ', '0'}, {' ', '3'}, {STAR, '5'}, {' ', '1'}, {' ', '1'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '0'}, {' ', '3'}, {' ', '5'}, {' ', '1'}, {STAR, '6'}, {' ', '6'}, {' ', '7'}, {' ', '6'}},
                {{' ', '0'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '6'}, {STAR, '7'}, {' ', '6'}}};

        //*** This is an invalid one-star solution that contains incorrect row counts.
        char[][][] oneStarGridInvalidRow = {
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains incorrect column counts.
        char[][][] oneStarGridInvalidColumn = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {STAR, '3'}, {' ', '4'}, {' ', '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains direct contact between stars diagonally.
        char[][][] oneStarGridInValidDiagonal = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {' ', '3'}, {' ', '4'}, {STAR, '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '2'}, {STAR, '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '7'}, {' ', '7'}, {' ', '5'}, {STAR, '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}}};

        //*** This is an invalid one-star solution that contains incorrect cage counts.
        char[][][] oneStarGridInvalidCageOnly = {
                {{' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '2'}, {STAR, '3'}, {' ', '4'}, {' ', '4'}, {' ', '4'}},
                {{' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{STAR, '0'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '2'}, {' ', '3'}, {' ', '3'}, {' ', '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '3'}, {STAR, '3'}},
                {{' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '3'}, {' ', '3'}},
                {{' ', '7'}, {STAR, '7'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}},
                {{' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '7'}, {' ', '7'}}};

        //*** This is a valid two-star solution.
        char[][][] twoStarGridValid1 = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is a valid two-star solution.
        char[][][] twoStarGridValid2 = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}},
                {{' ', '0'}, {' ', '2'}, {' ', '2'}, {STAR, '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {' ', '3'}, {' ', '3'}},
                {{' ', '4'}, {STAR, '2'}, {' ', '5'}, {' ', '5'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {STAR, '5'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {STAR, '5'}, {' ', '5'}, {STAR, '7'}, {' ', '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {STAR, '8'}, {' ', '6'}, {' ', '6'}, {STAR, '9'}},
                {{STAR, '4'}, {' ', '4'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '8'}, {' ', '9'}, {' ', '9'}, {' ', '9'}},
                {{' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '8'}, {' ', '8'}, {STAR, '9'}, {' ', '9'}}};

        //*** This is an invalid two-star solution that contains incorrect row counts.
        char[][][] twoStarGridInvalidRow = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains incorrect column counts.
        char[][][] twoStarGridInvalidColumn = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars horizontally (left and/or right).
        char[][][] twoStarGridInvalidHorizontal = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {STAR, '4'}, {' ', '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars vertically (up and/or down).
        char[][][] twoStarGridInvalidVertical = {
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}},
                {{' ', '0'}, {STAR, '2'}, {' ', '2'}, {STAR, '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}, {' ', '1'}, {' ', '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '2'}, {' ', '5'}, {' ', '5'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}, {' ', '1'}, {STAR, '3'}, {' ', '3'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {STAR, '5'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {STAR, '5'}, {' ', '5'}, {STAR, '7'}, {' ', '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '6'}},
                {{' ', '4'}, {' ', '4'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '7'}, {STAR, '8'}, {' ', '6'}, {' ', '6'}, {STAR, '9'}},
                {{STAR, '4'}, {' ', '4'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {STAR, '8'}, {' ', '9'}, {' ', '9'}, {' ', '9'}},
                {{' ', '7'}, {' ', '7'}, {STAR, '7'}, {' ', '7'}, {' ', '7'}, {' ', '7'}, {' ', '8'}, {' ', '8'}, {STAR, '9'}, {' ', '9'}}};

        //*** This is an invalid two-star solution that contains direct contact between stars diagonally.
        char[][][] twoStarGridInValidDiagonal = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {STAR, '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {STAR, '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};

        //*** This is an invalid two-star solution that contains incorrect cage counts.
        char[][][] twoStarGridInvalidCageOnly = {
                {{' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {STAR, '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '1'}, {' ', '1'}},
                {{' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {' ', '0'}, {STAR, '2'}, {' ', '0'}, {STAR, '1'}, {' ', '1'}},
                {{' ', '3'}, {STAR, '4'}, {' ', '4'}, {STAR, '4'}, {' ', '0'}, {' ', '2'}, {' ', '2'}, {' ', '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '5'}, {STAR, '6'}, {' ', '6'}, {STAR, '2'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {' ', '6'}, {' ', '1'}, {STAR, '1'}},
                {{STAR, '3'}, {' ', '3'}, {' ', '7'}, {' ', '5'}, {' ', '5'}, {' ', '5'}, {' ', '6'}, {STAR, '6'}, {' ', '1'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {STAR, '7'}, {' ', '7'}, {STAR, '7'}, {' ', '6'}, {' ', '6'}, {' ', '6'}, {' ', '8'}, {' ', '1'}},
                {{' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {' ', '3'}, {STAR, '6'}, {' ', '6'}, {STAR, '8'}, {' ', '1'}},
                {{STAR, '3'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '8'}, {' ', '8'}},
                {{' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '9'}, {' ', '9'}, {' ', '9'}, {' ', '9'}, {STAR, '8'}}};
        //***
        //***
        //***




    


        //*** ONE-STAR Solutions ***//

        gridPrint(oneStarGridValid1);
        System.out.println();
        processErrorCode(gridValid(oneStarGridValid1, 1, ONE_STAR_NUMBER_CAGES));

        gridPrint(oneStarGridValid2);
        System.out.println();
        processErrorCode(gridValid(oneStarGridValid2, 1, ONE_STAR_NUMBER_CAGES));

        gridPrint(oneStarGridInvalidRow);
        System.out.println();
        processErrorCode(gridValid(oneStarGridInvalidRow, 1, ONE_STAR_NUMBER_CAGES));

//        gridPrint(oneStarGridInvalidColumn);
//        System.out.println();
//        processErrorCode(gridValid(oneStarGridInvalidColumn, 1, ONE_STAR_NUMBER_CAGES));

        gridPrint(oneStarGridInValidDiagonal);
        System.out.println();
        processErrorCode(gridValid(oneStarGridInValidDiagonal, 1, ONE_STAR_NUMBER_CAGES));

        gridPrint(oneStarGridInvalidCageOnly);
        System.out.println();
        processErrorCode(gridValid(oneStarGridInvalidCageOnly, 1, ONE_STAR_NUMBER_CAGES));


        //*** TWO-STAR Solutions ***//

        gridPrint(twoStarGridValid1);
        System.out.println();
        processErrorCode(gridValid(twoStarGridValid1, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridValid2);
        System.out.println();
        processErrorCode(gridValid(twoStarGridValid2, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridInvalidRow);
        System.out.println();
        processErrorCode(gridValid(twoStarGridInvalidRow, 2, TWO_STAR_NUMBER_CAGES));

//        gridPrint(twoStarGridInvalidColumn);
//        System.out.println();
//        processErrorCode(gridValid(twoStarGridInvalidColumn, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridInvalidHorizontal);
        System.out.println();
        processErrorCode(gridValid(twoStarGridInvalidHorizontal, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridInvalidVertical);
        System.out.println();
        processErrorCode(gridValid(twoStarGridInvalidVertical, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridInValidDiagonal);
        System.out.println();
        processErrorCode(gridValid(twoStarGridInValidDiagonal, 2, TWO_STAR_NUMBER_CAGES));

        gridPrint(twoStarGridInvalidCageOnly);
        System.out.println();
        processErrorCode(gridValid(twoStarGridInvalidCageOnly, 2, TWO_STAR_NUMBER_CAGES));

        //***
        //***
        //***
    }



    //*** The numbers in the displayed grid represent the "cages".
    //*** All cells with the same number are in the same cage.
    //*** In other words, all cells with the number 0 are in the same
    //***    cage, all cells with the number 1 are in the same cage,
    //***    and so on.
    //***
    //*** The asterisks represent the cell in which a star is placed.
    //***
    public static void gridPrint(char[][][] grid) {

        System.out.println();
        System.out.print("\t");

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j][CHAR_POS] + "" + grid[i][j][CAGE_POS] + "\t");
            }

            System.out.println();
            System.out.print("\t");
        }
    }

   
    public static void processErrorCode(int errorCode) {
        switch (errorCode) {
            case ERROR_CODE_VALID:
                System.out.println("This is a valid Star Battle solution.");
                break;
            case ERROR_CODE_INCORRECT_ROW_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect row count.");
                break;
            case ERROR_CODE_INCORRECT_COLUMN_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect column count.");
                break;
            case ERROR_CODE_INCORRECT_CAGE_COUNT:
                System.out.println("This is an invalid Star Battle solution. There is an incorrect cage count.");
                break;
            case ERROR_CODE_HORIZONTAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct horizontal contact.");
                break;
            case ERROR_CODE_VERTICAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct vertical contact.");
                break;
            case ERROR_CODE_DIAGONAL_CONTACT:
                System.out.println("This is an invalid Star Battle solution. Stars have direct diagonal contact.");
                break;
        }
    }


    public static int gridValid(char[][][] grid, int stars, int numberCages) {

        //***
        //***
        int errorCode = ERROR_CODE_VALID;
        int[] cageCount = new int[numberCages];
        //***
        //***
        //***

       
        int row = 0;
        int col = 0;
        boolean isValid = true;
        //***
        //***
        //***

        while (isValid && row < grid.length) {

            // Creating a nested loop to check the constraint that there cannot be
            // more than given stars in a given row.
            int foundStar;
            for (int r = 0; r < grid.length; r++) {

                foundStar = 0;
                for (int c = 0; c < grid[r].length; c++) {
                    for (int i = 0 ; i < grid[r][c].length; i++) {
                        if (grid[r][c][i] == STAR){
                            foundStar++;
                        }
                    }

                }

                // Creating an if statement, if finding more than number of stars,
                // then set the variable errorCode to ERROR_CODE_INCORRECT_ROW_COUNT.
                if ( foundStar > stars ){
                    isValid = false;
                    errorCode = ERROR_CODE_INCORRECT_ROW_COUNT;
                }
            }

            while (isValid && col < grid[row].length) {

                // Creating an array list, and use a nested for loop to locate the STAR char
                // Append the column location into the array by using the method add,
                // to check the constraint that there cannot be more than given stars number
                // in a given column. I left these statements in block comment because I could figure out just in
                // one-star solutions, and in vertical, horizontal and diagonal two-stars solutions.

                /*int colCount;
                ArrayList<Integer> locate_star_in_column = new ArrayList<Integer>();
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 0; c < grid[r].length; c++) {
                        for (int i = 0; i < grid[r][c].length; i++) {
                            if (grid[r][c][i] == STAR) {
                                locate_star_in_column.add(c);
                            }
                        }
                    }
                }
                // Nested for loop to pull duplicate element inside the array, to detect if we have more than
                // star in each column, and using if statement, if finding more than number of stars,
                // then set the variable errorCode to ERROR_CODE_INCORRECT_COLUMN_COUNT.
                for(int x = 0 ; x < locate_star_in_column.toArray().length; x++){
                    for(int i = x + 1 ; i < locate_star_in_column.toArray().length - 1 ; i++){
                        if(locate_star_in_column.get(x) == locate_star_in_column.get(i) && (x != i )){
                            isValid = false;
                            errorCode = ERROR_CODE_INCORRECT_COLUMN_COUNT;
                        }
                    }

                }*/

                // Creating a nested loop to check the constraint that there cannot be
                // direct contact between two stars horizontally which is left or right of the star.
                for (int r = 0; r < grid.length; r++) {
                    for (int c = 1; c < grid[r].length -1 ; c++) {
                        for (int i = 0; i < grid[r][c].length  ; i++) {
                            if (grid[r][c][i] == STAR) {
                                // Creating an if statement, if finding star on the left or the right,
                                // then set the variable errorCode to ERROR_CODE_HORIZONTAL_CONTACT.
                                if (grid[r][c-1][i] == STAR || grid[r][c+1][i] == STAR ){
                                    isValid = false;
                                    errorCode = ERROR_CODE_HORIZONTAL_CONTACT;
                                }

                            }


                        }


                    }

                }

                // Creating a nested loop to check the constraint that there cannot be
                // direct contact between two stars vertically which is up or down of the star.
                for (int r = 1; r < grid.length -1; r++) {
                    for (int c = 0; c < grid[r].length  ; c++) {
                        for (int i = 0; i < grid[r][c].length  ; i++) {
                            if (grid[r][c][i] == STAR) {
                                // Creating an if statement, if finding star on the up or down,
                                // then set the variable errorCode to ERROR_CODE_VERTICAL_CONTACT.
                                if (grid[r-1][c][i] == STAR || grid[r+1][c][i] == STAR ){
                                    isValid = false;
                                    errorCode = ERROR_CODE_VERTICAL_CONTACT;
                                }

                            }


                        }


                    }

                }

                // Creating a nested loop to check the constraint that there cannot be
                // direct contact between two stars in the four diagonal directions.
                for (int r = 1; r < grid.length -1 ; r++) {
                    for (int c = 1; c < grid[r].length -1 ; c++) {
                        for (int i = 0; i < grid[r][c].length  ; i++) {
                            if (grid[r][c][i] == STAR) {
                                // Creating an if statement, if finding star in the four diagonal directions,
                                // then set the variable errorCode to ERROR_CODE_DIAGONAL_CONTACT.
                                if(grid[r-1][c-1][i]  == STAR || grid[r-1][c+1][i] == STAR || grid[r+1][c-1][i] == STAR || grid[r+1][c+1][i] == STAR ){
                                    isValid = false;
                                    errorCode = ERROR_CODE_DIAGONAL_CONTACT;
                                }
                            }
                        }
                    }
                }

                // Accumulates the count of stars by cage and stores the numbers
                //     in the cageCount array to be processed outside this loop.
                if (grid[row][col][CHAR_POS] == STAR)
                    cageCount[grid[row][col][CAGE_POS]-ASCII_NUM_INDEX]++;

                col++;

            }

            col = 0;
            row++;
        }

        // A valid solution must have exactly variable "stars" number of stars per cage.
        // Spins through the cageCount array and determines if each cage contains the
        //     correct number of stars.
        // If is does not contain the correct number of stars, then variable "errorCode"
        //     is set to the correct error code based upon the error code constants.
        if (isValid) {
            for (int i = 0; i < cageCount.length; i++) {
                if (cageCount[i] != stars) {
                    isValid = false;
                    errorCode = ERROR_CODE_INCORRECT_CAGE_COUNT;
                }
            }
        }

        return errorCode;
    }
}
