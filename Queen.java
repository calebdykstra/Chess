package chess;

/*****************************************************************
 Queen Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Queen extends ChessPiece {
    public Queen(Player player) {
        super(player);

    }

    public String type() {
        return "Queen";

    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {

        if(!super.isValidMove(move, board))
            return false;

        Bishop move1 = new Bishop(board[move.fromRow][move.fromColumn].player());
        Rook move2 = new Rook(board[move.fromRow][move.fromColumn].player());
        return (move1.isValidMove(move, board) || move2.isValidMove(move, board));

    }
}
