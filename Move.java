package chess;


/*****************************************************************
 Move Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class Move {

    /** variables for board positions */
    public int fromRow, fromColumn, toRow, toColumn;



    public Move() {
    }



    /*****************************************************************
     Constructor for Move objects

     @param fromRow row the piece is coming from
     @param fromColumn column the piece is coming from
     @param toRow row the piece is going to
     @param toColumn column the piece is going to
     *****************************************************************/
    public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }

    @Override
    public String toString() {
        return "Move [fromRow=" + fromRow + ", fromColumn=" + fromColumn + ", toRow=" + toRow + ", toColumn=" + toColumn
                + "]";
    }
}

