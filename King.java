package chess;

/*****************************************************************
 King Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class King extends ChessPiece {
    public King(Player player) {
        super(player);
    }


    public String type() {
        return "King";
    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {

        if(super.isValidMove(move, board) != true){
            return false;
        }

        if (Math.abs(move.toRow - move.fromRow) > 1 || Math.abs(move.toColumn - move.fromColumn) > 1) {
            return false;

        }

        return true;
    }
}