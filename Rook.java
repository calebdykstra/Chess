package chess;


/*****************************************************************
 Rook Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Rook extends ChessPiece {
    public Rook(Player player) {

        super(player);

    }

    public String type() {

        return "Rook";

    }

    /*****************************************************************
     Checks if the input move is a valid move
     @param move Move object, 4 coordinates
     @param board 8x8 2D array for Chess board
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = true;
        int offset;

        if (!super.isValidMove(move, board))
            valid = false;

        if (move.fromRow != move.toRow && move.fromColumn != move.toColumn) {
            //Did not move along one rank/file
            valid = false;
        }

        //First assume the Rook is moving along the rows

        if (move.fromRow != move.toRow){
            if (move.fromRow < move.toRow) {
                offset = 1;
            } else {
                offset = -1;
            }

            for (int x = move.fromRow + offset; x != move.toRow; x += offset) {
                //Go from fromRow to toRow, and check every space
                if (board[x][move.fromColumn] != null) {
                    valid = false;
                }
            }
        }

        //Now do the same for columns
        if (move.fromColumn != move.toColumn) {
            if (move.fromColumn < move.toColumn) {
                offset = 1;
            } else {
                offset = -1;
            }

            for (int x = move.fromColumn + offset; x != move.toColumn; x += offset) {
                //Go from currentCol to newCol, and check every space
                if (board[move.fromRow][x] != null) {
                    return false;
                }
            }
        }

        return valid;
    }

}