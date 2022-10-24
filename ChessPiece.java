package chess;


/*****************************************************************
 ChessPiece abstract Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public abstract class ChessPiece implements IChessPiece {
    private Player owner;

    protected ChessPiece(Player player) {
        this.owner = player;
    }

    public abstract String type();

    public Player player() {
        return owner;
    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {


        if (move.toRow == move.fromRow && move.fromColumn == move.toColumn)
            return false;


        if (move.toRow < 0 || move.toColumn < 0 || move.toRow > board.length || move.toColumn > board.length) {
            // throw new IllegalArgumentException("Move is outside of board bounds");
            return false;

        }

        if (move.fromRow < 0 || move.fromColumn < 0 || move.fromRow > board.length || move.fromColumn > board.length)
            //throw new IllegalArgumentException("Placement is outside of board");

            return false;


        if (board[move.toRow][move.toColumn] != null) {
            if (board[move.fromRow][move.fromColumn].player().equals(board[move.toRow][move.toColumn].player()))

                return false;
        }
        return true;
    }

    public String getColor() {
        if (player().equals(Player.BLACK))
            return "BLACK";
        else
            return "WHITE";
    }



}

