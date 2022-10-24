package chess;

/*****************************************************************
 Player enum Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public enum Player {

        BLACK, WHITE;

        /**
         * Return the {@code Player} whose turn is next.
         *
         * @return the {@code Player} whose turn is next
         */
        public Player next() {
            if (this == BLACK)
                return WHITE;
            else
                return BLACK;


        }
}
