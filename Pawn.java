package chess;


/*****************************************************************
 Pawn Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Pawn extends ChessPiece {
    public Pawn(Player player) {
        super(player);
    }


    public String type() {
        return "Pawn";
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
        if(move.toColumn != move.fromColumn) {
            if (board[move.toRow][move.toColumn] == null) {
                return false;

            }
        }

        if(getColor().equals("BLACK") && move.fromRow == 1 ){
            if (move.toRow > 3)
                   return false;
        }

        if(getColor().equals("WHITE") && move.fromRow == 6){
            if (move.toRow < 4)
                return false;
        }

        if(getColor().equals("BLACK") && move.fromRow != 1 ){
            if(move.toRow != move.fromRow + 1){
                return false;
            }
        }

        if(getColor().equals("WHITE") && move.fromRow != 6){
            if (move.toRow != move.fromRow - 1)
            return false;
        }

        if(getColor().equals("BLACK") && board[move.fromRow + 1][move.fromColumn] != null ){
           if(move.toColumn != move.fromColumn + 1 || move.toColumn != move.fromColumn - 1)
            return false;
        }
        if(getColor().equals("WHITE") && board[move.fromRow -1 ][move.fromColumn] != null ){
            if(move.toColumn != move.fromColumn + 1 || move.toColumn != move.fromColumn - 1)
                return false;
        }

        if (getColor().equals("WHITE")) {
            if (move.fromRow <= move.toRow) {
                return false;
            }
        }
        if (getColor().equals("BLACK")) {
            if (move.toRow <= move.fromRow) {
                return false;
            }
        }
        return true;
    }
}
