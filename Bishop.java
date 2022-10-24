package chess;

/*****************************************************************
 Bishop Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Bishop extends ChessPiece {

    /** Constructor for bishop */
    public Bishop(Player player) {
        super(player);
    }

    /** Type method for bishop */
    public String type() {
        return "Bishop";
    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        int rowOffset, colOffset;

        if(!super.isValidMove(move, board)){
            return false;
        }

        /**piece did not move**/
        if (move.fromRow == move.toRow || move.fromColumn == move.toColumn) {
            return false;
        }

        /**piece did not move diagonally**/
        if (Math.abs(move.toRow - move.fromRow) != Math.abs(move.toColumn - move.fromColumn)) {
            return false;
        }


        if (move.fromRow < move.toRow) {
            rowOffset = 1;
        } else {
            rowOffset = -1;
        }

        if (move.fromColumn < move.toColumn) {
            colOffset = 1;
        } else {
            colOffset = -1;
        }

        int y = move.fromColumn + colOffset;
        for (int x = move.fromRow + rowOffset; x != move.toRow; x += rowOffset) {

            if (board[x][y] != null) {
                return false;
            }

            y += colOffset;
        }


        return true;
    }
}