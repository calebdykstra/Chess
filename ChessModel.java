package chess;

import java.util.ArrayList;
import java.util.Objects;

/*****************************************************************
 ChessModel Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class ChessModel implements IChessModel {
    private IChessPiece[][] board;
    private Player player;

    public ChessModel() {
        /**creates 8x8 chessboard**/
        board = new IChessPiece[8][8];
        /**setting first player**/
        player = Player.WHITE;


        /**setting white pieces in desired locations**/
        board[7][0] = new Rook(Player.WHITE);
        board[6][0] = new Pawn(Player.WHITE);
        board[7][1] = new Knight(Player.WHITE);
        board[6][1] = new Pawn(Player.WHITE);
        board[7][2] = new Bishop(Player.WHITE);
        board[6][2] = new Pawn(Player.WHITE);
        board[7][3] = new Queen(Player.WHITE);
        board[6][3] = new Pawn(Player.WHITE);
        board[7][4] = new King(Player.WHITE);
        board[6][4] = new Pawn(Player.WHITE);
        board[7][5] = new Bishop(Player.WHITE);
        board[6][5] = new Pawn(Player.WHITE);
        board[7][6] = new Knight (Player.WHITE);
        board[6][6] = new Pawn(Player.WHITE);
        board[7][7] = new Rook(Player.WHITE);
        board[6][7] = new Pawn(Player.WHITE);


        /**setting black pieces in desired locations**/
        board[0][0] = new Rook(Player.BLACK);
        board[1][0] = new Pawn(Player.BLACK);
        board[0][1] = new Knight(Player.BLACK);
        board[1][1] = new Pawn(Player.BLACK);
        board[0][2] = new Bishop(Player.BLACK);
        board[1][2] = new Pawn(Player.BLACK);
        board[0][3] = new Queen(Player.BLACK);
        board[1][3] = new Pawn(Player.BLACK);
        board[0][4] = new King(Player.BLACK);
        board[1][4] = new Pawn(Player.BLACK);
        board[0][5] = new Bishop(Player.BLACK);
        board[1][5] = new Pawn(Player.BLACK);
        board[0][6] = new Knight(Player.BLACK);
        board[1][6] = new Pawn(Player.BLACK);
        board[0][7] = new Rook(Player.BLACK);
        board[1][7] = new Pawn(Player.BLACK);

    }



    /*****************************************************************
     Checks if the current game has a checkmate, indicating the game is over
     *****************************************************************/
    public boolean isComplete() {
        if (inCheck(currentPlayer())) {
            /**method only executes if player is already in check**/
            int[] kingPosition = getKingPosition(currentPlayer());
            int kingRow = kingPosition[0];
            int kingCol = kingPosition[1];

            int[] attackPosition = getAttackingPosition(currentPlayer());
            ArrayList<int[]> tiles = blockTiles(kingPosition, attackPosition);

            /**Check if King can move**/
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    Move move = new Move(kingRow, kingCol, row, col);
                    /**attempt to move king to every position on board**/
                    if (isValidMove(move)) {
                        /**if king can move, create new king on tile and remove original king**/
                        setPiece(row, col, new King(currentPlayer()));
                        setPiece(kingRow, kingCol, null);
                        if (!(inCheck(currentPlayer()))) {
                            /**check if new king is in check, if so return original king and return false**/
                            setPiece(row, col, null);
                            setPiece(kingRow, kingCol, new King(currentPlayer()));
                            return false;
                        }
                        /**return original king and continue trying moves if still in check**/
                        setPiece(row, col, null);
                        setPiece(kingRow, kingCol, new King(currentPlayer()));
                    }
                }
            }

            /**check if attacking piece can be taken or blocked**/
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    /**swift through every tile on board**/
                    if (board[row][col] != null && board[row][col].player() == player
                            && !board[row][col].type().equals("King")) {
                        /**check if piece exists on tile and is different color than current player**/
                        for (int[] tile : tiles) {
                            Move move = new Move(row, col, tile[0], tile[1]);
                            /**try to move piece to attackers position or block**/
                            if (isValidMove(move)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /*****************************************************************
     Checks if the input move is a valid move, with respect to the king
     @param move Move object, 4 coordinates
     @return boolean valid move or not
     *****************************************************************/
    public boolean isValidMove(Move move) {
        IChessPiece fromHolder;
        IChessPiece toHolder;

        if (board[move.fromRow][move.fromColumn] != null) {
            if (board[move.fromRow][move.fromColumn].isValidMove(move, board)) {
                if (((board[move.toRow][move.toColumn] != null && board[move.toRow][move.toColumn].type().equals("King"))))
                    return true;
                fromHolder = board[move.fromRow][move.fromColumn];
                board[move.fromRow][move.fromColumn] = null;
                toHolder = board[move.toRow][move.toColumn];
                board[move.toRow][move.toColumn] = fromHolder;
                if (inCheck(currentPlayer())) {
                    board[move.fromRow][move.fromColumn] = fromHolder;
                    board[move.toRow][move.toColumn] = toHolder;
                    return false;
                }
                board[move.fromRow][move.fromColumn] = fromHolder;
                board[move.toRow][move.toColumn] = toHolder;
                return true;
            }
        }
        return false;
    }


    /*****************************************************************
     Inner move method, transferring fromPosition-toPosition and setting fromPosition to null
     *****************************************************************/
    public void move(Move move) {
        board[move.toRow][move.toColumn] =  board[move.fromRow][move.fromColumn];
        board[move.fromRow][move.fromColumn] = null;
    }



    /*****************************************************************
     Gets the kings position on the board
     @param currentPlayer player who's currently moving
     @return int[] {kingRow, kingCol}
     *****************************************************************/
    public int[] getKingPosition(Player currentPlayer){

        int row = 0, col = 0;

        for(int x = 0; x<board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] != null) {
                    if (board[x][y].player() == currentPlayer && Objects.equals(board[x][y].type(), "King")) {
                        row = x;
                        col = y;
                    }
                }
            }
        }

        return new int[] {row, col};
    }


    /*****************************************************************
     Checks if the game's king is currently in check
     @param p player you are examining
     @return boolean in check or not
     *****************************************************************/
    public boolean inCheck(Player p) {
        /**if any piece can get to the kings position, return true**/
        int[] kingPosition = getKingPosition(p);
        int kingRow = kingPosition[0];
        int kingCol = kingPosition[1];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++)
                /**swift through every tile on board**/
                if (board[row][col] != null && board[row][col].player() != p) {
                    /**check if piece exists on tile and is different color than king**/
                    Move move = new Move(row, col, kingRow, kingCol);
                    /**try to move piece to take king**/
                    if (isValidMove(move)) {
                        return true;
                    }
                }
        }
        return false;
    }


    /*****************************************************************
     Gets the attacking piece's position on the board
     @param currentPlayer player who's currently moving
     @return int[] {attackRow, attackCol}
     *****************************************************************/
    public int[] getAttackingPosition(Player currentPlayer){

        int[] kingPosition = getKingPosition(currentPlayer);
        int kingRow = kingPosition[0];
        int kingCol = kingPosition[1];
        int row = 0, col = 0;

        for(int x = 0; x<board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] != null && board[x][y].player() != currentPlayer) {
                    Move move = new Move(x, y, kingRow, kingCol);
                    if (isValidMove(move)) {
                        row = x;
                        col = y;
                    }
                }
            }
        }

        return new int[] {row, col};
    }


    /*****************************************************************
     Scans the board around the king for pieces immediately blocking it
     @param kPos {Row of King, Column of King}
     @param aPos {Row of attacker, Colu,n of attacker}
     @return int[] {Row of blocking piece, Column of blocking piece}
     *****************************************************************/
    public ArrayList<int[]> blockTiles(int[] kPos, int[] aPos) {
        int kingRow = kPos[0];
        int kingCol = kPos[1];
        int attRow = aPos[0];
        int attCol = aPos[1];
        int offset;
        int[] temp = new int[2];
        ArrayList<int[]> tiles = new ArrayList<int[]>();

        /**checking touching pieces**/
        if ((kingRow == attRow && (kingCol == attCol + 1 || kingCol == attCol - 1)) //same row touching
                || (kingCol == attCol && (kingRow == attRow + 1 || kingRow == attRow - 1)) //same col touching
                || (kingRow == attRow + 1 && kingCol == attCol + 1)  //diagonal top left
                || (kingRow == attRow + 1 && kingCol == attCol - 1)  //diagonal top right
                || (kingRow == attRow - 1 && kingCol == attCol - 1)  //diagonal bottom right
                || (kingRow == attRow - 1 && kingCol == attCol + 1)) //diagonal bottom left
            return tiles;

        //checking sliding attack
        if (kingRow == attRow || kingCol == attCol) {
            if (kingRow == attRow) {
                if (kingCol > attCol)
                    offset = 1;
                else
                    offset = -1;
                for (int x = attCol; x != kingCol; x += offset) {
                    temp[0] = kingRow;
                    temp[1] = x;
                    tiles.add(new int[]{temp[0], temp[1]});
                }
                return tiles;
            }
            else {
                if (kingRow > attRow)
                    offset = 1;
                else
                    offset = -1;
                for (int x = attRow; x != kingRow; x += offset) {
                    temp[0] = kingCol;
                    temp[1] = x;
                    tiles.add(new int[]{temp[0], temp[1]});
                }
                return tiles;
            }
        }
        //diagonal attack
        else {
            //positive slope diagonal
            if ((kingRow > attRow && kingCol < attCol) || (kingRow < attRow && kingCol > attCol)) {
                if (kingRow > attRow)
                    offset = -1;
                else
                    offset = 1;
                for (int x = attRow; x != kingRow; x += offset)
                    for (int y = attCol; y != kingCol; y += offset) {
                        temp[0] = x;
                        temp[1] = y;
                        tiles.add(new int[]{temp[0], temp[1]});
                    }
                return tiles;
            }
            //negative slope diagonal
            else {
                if (kingRow > attRow)
                    offset = 1;
                else
                    offset = -1;
                for (int x = attRow; x != kingRow; x += offset)
                    for (int y = attCol; y != kingCol; y += offset) {
                        temp[0] = x;
                        temp[1] = y;
                        tiles.add(new int[]{temp[0], temp[1]});
                    }
            }
        }
        return null;
    }



    /*****************************************************************
     @return current player
     *****************************************************************/
    public Player currentPlayer() {
        return player;
    }


    /*****************************************************************
     @return number of rows
     *****************************************************************/
    public int numRows() {
        return 8;
    }

    /*****************************************************************
     @return number of columns
     *****************************************************************/
    public int numColumns() {
        return 8;
    }

    /*****************************************************************
     getting the piece from position on board
     @param column horizontal
     @param row vertical
     @return desired position
     *****************************************************************/
    public IChessPiece pieceAt(int row, int column) {
        return board[row][column];
    }

    /*****************************************************************
     switches player white to black or black to white
     *****************************************************************/
    public void setNextPlayer() {
        player = player.next();
    }

    /*****************************************************************
     setting desired piece to desired position {row, column}
     @param column horizontal
     @param row vertical
     @param piece which type of piece
     *****************************************************************/
    public void setPiece(int row, int column, IChessPiece piece) {
        board[row][column] = piece;
    }

    public void AI() {
        /*
         * Write a simple AI set of rules in the following order.
         * a. Check to see if you are in check.
         * 		i. If so, get out of check by moving the king or placing a piece to block the check
         *
         * b. Attempt to put opponent into check (or checkmate).
         * 		i. Attempt to put opponent into check without losing your piece
         *		ii. Perhaps you have won the game.
         *
         *c. Determine if any of your pieces are in danger,
         *		i. Move them if you can.
         *		ii. Attempt to protect that piece.
         *
         *d. Move a piece (pawns first) forward toward opponent king
         *		i. check to see if that piece is in danger of being removed, if so, move a different piece.
         */

    }
}