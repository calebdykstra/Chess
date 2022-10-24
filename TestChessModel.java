package chess;

import org.junit.Test;
import static org.junit.Assert.*;


/*****************************************************************
 Junit Test Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class TestChessModel {

    /** Clear board of all pieces for testing */
    public void clearBoard(ChessModel board) {
        for (int row = 0; row < 8; row++)
            for (int column = 0; column < 8; column++)
                board.setPiece(row, column, null);
    }


    /** Test the pawns valid moves */
    @Test
    public void testPawnValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(6, 0, new Pawn(Player.WHITE));
        board.setPiece(6, 1, new Pawn(Player.WHITE));
        board.setPiece(1, 0, new Pawn(Player.BLACK));
        board.setPiece(1, 1, new Pawn(Player.BLACK));


        Move move;
        // test white pawns
        move = new Move(6, 0, 5, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(6, 1, 4, 1);
        assertTrue(board.isValidMove(move));

        // test black pawns
        move = new Move(1, 0, 2, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(1, 1, 3, 1);
        assertTrue(board.isValidMove(move));
    }


    /** Test the pawns invalid moves */
    @Test
    public void testPawnInvalidMove(){
        ChessModel board = new ChessModel();
        clearBoard(board);
        // Testing white pieces
        board.setPiece(6, 0, new Pawn(Player.WHITE));
        Move move;
        move = new Move(6, 0, 7, 0);
        assertFalse(board.isValidMove(move));

        board.setPiece(6, 1, new Pawn(Player.WHITE));
        Move move2;
        move2 = new Move (6, 1, 6, 2);
        assertFalse(board.isValidMove(move2));


        // Testing black pieces
        board.setPiece(1, 1, new Pawn(Player.BLACK));
        Move move3;
        move3 = new Move(1, 1, 0, 1);
        assertFalse(board.isValidMove(move3));

        board.setPiece(1, 3, new Pawn(Player.BLACK));
        Move move4;
        move4 = new Move(1, 3, 1, 2);
        assertFalse(board.isValidMove(move4));
    }

    /** Test the rooks valid moves */
    @Test
    public void testRookValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(6, 6, new King(Player.WHITE));
        board.setPiece(7, 0, new Rook(Player.WHITE));
        board.setPiece(5, 4, new Rook(Player.WHITE));

        board.setPiece(4, 4, new King(Player.WHITE));
        board.setPiece(0, 0, new Rook(Player.BLACK));
        board.setPiece(2, 3, new Rook(Player.BLACK));

        Move move;
        // test white rooks
        move = new Move(7, 0, 4, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(5, 4, 5, 7);
        assertTrue(board.isValidMove(move));

        // test black rooks
        move = new Move(0, 0, 5, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(2, 3, 2, 0);
        assertTrue(board.isValidMove(move));
    }


    /** Test the rooks invalid moves */
    @Test
    public void testInvalidRookMove(){
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 0, new Rook(Player.WHITE));
        board.setPiece(0, 0, new Rook(Player.BLACK));
        board.setPiece(6, 0, new Pawn(Player.WHITE));
        board.setPiece(1, 0, new Pawn(Player.BLACK));

        // testing white moves
        Move move = new Move(7, 0, 6, 1);
        assertFalse(board.isValidMove(move));

        Move move2 = new Move(7, 0, 5, 0);
        assertFalse(board.isValidMove(move2));


        // testing black pieces
        Move move1 = new Move(0, 0, 7, 7);
        assertFalse(board.isValidMove(move1));

        Move move3 = new Move(0, 0, 1, 0);
        assertFalse(board.isValidMove(move3));

    }

    /** Test the knights valid moves */
    @Test
    public void testKnightValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 1, new Knight(Player.WHITE));
        board.setPiece(5, 5, new Knight(Player.WHITE));
        board.setPiece(0, 1, new Knight(Player.BLACK));
        board.setPiece(2, 5, new Knight(Player.BLACK));

        Move move;
        // test white knights
        move = new Move(7, 1, 5, 2);
        assertTrue(board.isValidMove(move));
        move = new Move(5, 5, 3, 4);
        assertTrue(board.isValidMove(move));

        // test black knights
        move = new Move(0, 1, 2, 2);
        //assertTrue(board.isValidMove(move));
        move = new Move(2, 5, 3, 7);
        assertTrue(board.isValidMove(move));
    }

    /** Test the knights invalid moves */
    @Test
    public void testKnightInvalidMove(){
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 1, new Knight(Player.WHITE));
        board.setPiece(0, 1, new Knight(Player.BLACK));
        board.setPiece(2, 2, new Pawn(Player.BLACK));
        Move move;

        // testing white
        move = new Move(7, 1, 6, 1);
        assertFalse(board.isValidMove(move));
        move = new Move(7, 1, 5, 1);
        assertFalse(board.isValidMove(move));
        move = new Move(7, 1, 7, 6);
        assertFalse(board.isValidMove(move));

        // testing black
        move = new Move(0, 1, 1, 2);
        assertFalse(board.isValidMove(move));
        move = new Move(0, 1, 2, 1 );
        assertFalse(board.isValidMove(move));
        move = new Move(0, 1, 2, 2);
        assertFalse(board.isValidMove(move));
    }




    /** Test the bishops valid moves */
    @Test
    public void testBishopValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 2, new Bishop(Player.WHITE));
        board.setPiece(4, 2, new Bishop(Player.WHITE));
        board.setPiece(0, 2, new Bishop(Player.BLACK));
        board.setPiece(2, 3, new Bishop(Player.BLACK));

        Move move;
        // test white bishop
        move = new Move(7, 2, 3, 6);
        assertTrue(board.isValidMove(move));
        move = new Move(4, 2, 6, 0);
        assertTrue(board.isValidMove(move));

        // test black bishop
        move = new Move(0, 2, 2, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(2, 3, 0, 1);
        assertTrue(board.isValidMove(move));
    }

    /** Test the bishop invalid moves */
    @Test
    public void testBishopInvalidMove(){
        ChessModel board = new ChessModel();
        clearBoard(board);
        Move move;

        board.setPiece(7, 2, new Bishop(Player.WHITE));
        board.setPiece(0, 2, new Bishop(Player.BLACK));
        board.setPiece(7, 5, new Bishop(Player.WHITE));
        board.setPiece(0, 5, new Bishop(Player.BLACK));
        board.setPiece(6, 3, new Pawn(Player.WHITE));

        move = new Move(7, 2, 6, 2);
        assertFalse(board.isValidMove(move));
        move = new Move(7, 2, 5, 4);
        assertFalse(board.isValidMove(move));
        move = new Move(7, 2, 6, 3);
        assertFalse(board.isValidMove(move));




    }

    /** Test the queens valid moves */
    @Test
    public void testQueenValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 0, new King(Player.WHITE));
        board.setPiece(7, 3, new Queen(Player.WHITE));
        board.setPiece(4, 1, new Queen(Player.WHITE));

        board.setPiece(0, 0, new King(Player.BLACK));
        board.setPiece(0, 3, new Queen(Player.BLACK));
        board.setPiece(2, 7, new Queen(Player.BLACK));

        Move move;
        // test white queen
        move = new Move(7, 3, 4, 6);
        assertTrue(board.isValidMove(move));
        move = new Move(4, 1, 4, 3);
        assertTrue(board.isValidMove(move));
        board.setNextPlayer();

        // test black queen
        move = new Move(0, 3, 3, 0);
        assertTrue(board.isValidMove(move));
        move = new Move(2, 7, 2, 0);
        assertTrue(board.isValidMove(move));
    }


    /** Test the king valid moves */
    @Test
    public void testKingValidMove() {

        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(6, 4, new King(Player.WHITE));
        board.setPiece(0, 4, new King(Player.BLACK));

        Move move;
        // test white king
        move = new Move(6, 4, 5, 4);
        assertTrue(board.isValidMove(move));
        move = new Move(6, 4, 7, 3);
        assertTrue(board.isValidMove(move));

        // test black king
        move = new Move(0, 4, 1, 5);
        assertTrue(board.isValidMove(move));
        move = new Move(0, 4, 0, 3);
        assertTrue(board.isValidMove(move));
    }

    /** Test the king invalid moves */
    @Test
    public void testKingInvalidMove() {
        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(6, 4, new King(Player.WHITE));
        board.setPiece(0, 4, new King(Player.BLACK));

        Move move;
        // test white king
        move = new Move(6, 4, 6, 4);
        assertFalse(board.isValidMove(move));
        move = new Move(6, 4, 6, 6);
        assertFalse(board.isValidMove(move));
    }

    /** Test the check method */
    @Test
    public void testCheckAttacked() {
        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(6, 4, new King(Player.WHITE));
        board.setPiece(7, 5, new Rook(Player.WHITE));
        board.setPiece(5, 1, new Bishop(Player.WHITE));
        board.setPiece(4, 2, new Knight(Player.WHITE));

        board.setPiece(0, 4, new King(Player.BLACK));
        board.setPiece(0, 2, new Bishop(Player.BLACK));
        board.setPiece(0, 6, new Rook(Player.BLACK));
        board.setPiece(7, 7, new Knight(Player.BLACK));
        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |     bB    bK    bR   |
         *   |                      |
         *   |                      |
         *   |                      |
         *   |     wN               |
         *   |  wB                  |
         *   |           wK         |
         *   |              wR    bN|
         *    -  -  -  -  -  -  -  -
         * */

        Move move;
        // test white king attacked then remove attacking piece
        move = new Move(0, 6, 6, 6);
        board.move(move);
        assertTrue(board.inCheck(Player.WHITE));
        board.setPiece(6, 6, null);

        move = new Move(0, 2, 3, 7);
        board.move(move);
        assertTrue(board.inCheck(Player.WHITE));
        board.setPiece(3, 7, null);

        move = new Move(7, 7, 5, 6);
        board.move(move);
        assertTrue(board.inCheck(Player.WHITE));
        board.setPiece(5, 6, null);

        // test black king attacked then remove attacking piece
        move = new Move(7, 5, 0, 5);
        board.move(move);
        assertTrue(board.inCheck(Player.BLACK));
        board.setPiece(0, 5, null);

        move = new Move(5, 1, 4, 0);
        board.move(move);
        assertTrue(board.inCheck(Player.BLACK));
        board.setPiece(4, 0, null);

        move = new Move(4, 2, 2, 3);
        board.move(move);
        assertTrue(board.inCheck(Player.BLACK));
        board.setPiece(2, 3, null);
    }


    /** Test the checkmate method */
    @Test
    public void testCheckmate() {
        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));
        board.setPiece(6, 0, new Pawn(Player.WHITE));
        board.setPiece(6, 1, new Pawn(Player.WHITE));
        board.setPiece(6, 2, new Pawn(Player.WHITE));

        board.setPiece(3, 5, new Rook(Player.BLACK));
        board.setNextPlayer(); //set player black

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |                      |
         *   |                      |
         *   |                      |
         *   |               bR     |
         *   |                      |
         *   |                      |
         *   |wP wP wP              |
         *   |   wK                 |
         *    -  -  -  -  -  -  -  -
         * */

        Move move;
        move = new Move(3, 5, 7, 5);
        board.move(move);
        board.setNextPlayer();
        assertTrue(board.inCheck(Player.WHITE));
        assertTrue(board.isComplete());

        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));

        board.setPiece(3, 5, new Rook(Player.BLACK));
        board.setPiece(6, 4, new Rook(Player.BLACK));
        board.setNextPlayer();

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |                      |
         *   |                      |
         *   |                      |
         *   |               bR     |
         *   |                      |
         *   |                      |
         *   |            bR        |
         *   |   wK                 |
         *    -  -  -  -  -  -  -  -
         * */

        move = new Move(3, 5, 7, 5);
        board.move(move);
        board.setNextPlayer();
        assertTrue(board.inCheck(Player.WHITE));
        assertTrue(board.isComplete());

        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));
        board.setPiece(6, 0, new Pawn(Player.WHITE));

        board.setPiece(3, 5, new Rook(Player.BLACK));
        board.setPiece(0, 7, new Bishop(Player.BLACK));
        board.setNextPlayer();

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |                    bB|
         *   |                      |
         *   |                      |
         *   |               bR     |
         *   |                      |
         *   |                      |
         *   |wP                    |
         *   |  wK                  |
         *    -  -  -  -  -  -  -  -
         * */

        move = new Move(3, 5, 7, 5);
        board.move(move);
        board.setNextPlayer();
        assertTrue(board.inCheck(Player.WHITE));
        assertFalse(board.isComplete());

        //test blocking to get out of check
        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));
        board.setPiece(3, 3, new Rook(Player.WHITE));

        board.setPiece(3, 5, new Rook(Player.BLACK));
        board.setPiece(6, 4, new Rook(Player.BLACK));
        board.setPiece(0, 0, new King(Player.BLACK));
        board.setNextPlayer();

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |bK                    |
         *   |                      |
         *   |                      |
         *   |         wR    bR     |
         *   |                      |
         *   |                      |
         *   |            bR        |
         *   |   wK                 |
         *    -  -  -  -  -  -  -  -
         * */

        move = new Move(3, 5, 7, 5);
        board.move(move);
        board.setNextPlayer();
        assertTrue(board.inCheck(Player.WHITE));
        assertFalse(board.isComplete());
        move = new Move(3, 3, 7, 3);
        board.move(move);
        board.setNextPlayer();
        assertFalse(board.inCheck(Player.WHITE));
        assertFalse(board.isComplete());
        move = new Move(7, 5, 7, 3);
        board.move(move);
        board.setNextPlayer();
        assertTrue(board.inCheck(Player.WHITE));
        assertTrue(board.isComplete());


        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));
        board.setPiece(6, 0, new Pawn(Player.WHITE));
        board.setPiece(6, 1, new Pawn(Player.WHITE));
        board.setPiece(6, 2, new Pawn(Player.WHITE));

        board.setPiece(3, 3, new Rook(Player.BLACK));

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |                      |
         *   |                      |
         *   |                      |
         *   |         bR           |
         *   |                      |
         *   |                      |
         *   |wP wP wP              |
         *   |   wK                 |
         *    -  -  -  -  -  -  -  -
         * */

        move = new Move(3, 3, 7, 3);
        board.move(move);
        assertTrue(board.inCheck(Player.WHITE));
        assertTrue(board.isComplete());
    }


    /** Test invalid checks */
    @Test
    public void invalidMoveIntoCheck() {
        //generate -> clear -> build chess board
        ChessModel board = new ChessModel();
        clearBoard(board);
        board.setPiece(7, 1, new King(Player.WHITE));
        board.setPiece(7, 2, new Rook(Player.WHITE));

        board.setPiece(7, 5, new Rook(Player.BLACK));
        board.setPiece(6, 5, new Rook(Player.BLACK));

        /*
         *   Board status from build
         *    -  -  -  -  -  -  -  -
         *   |                      |
         *   |                      |
         *   |                      |
         *   |                      |
         *   |                      |
         *   |                      |
         *   |               bR     |
         *   |   wK wR       bR     |
         *    -  -  -  -  -  -  -  -
         * */

        Move move;
        move = new Move(7, 2, 0, 2);
        assertFalse(board.isValidMove(move));
    }
}