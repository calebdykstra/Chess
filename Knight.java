package chess;


/*****************************************************************
 Knight Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Knight extends ChessPiece {
    public Knight(Player player) {
        super(player);
    }

    public String type() {
        return "Knight";
    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {

        if (!super.isValidMove(move, board)) {
            return false;
        }
        if(move.fromRow == move.toRow || move.fromColumn == move.toColumn){
            //Did not move
            return false;
        }

        if (Math.abs(move.toRow - move.fromRow) == 2) {
            if (Math.abs(move.toColumn - move.fromColumn) == 1)
                return true;
        }

        if (Math.abs(move.toRow - move.fromRow) == 1) {
            if (Math.abs(move.toColumn - move.fromColumn) == 2) {
                return true;
            }
        }
        return false;
    }
}