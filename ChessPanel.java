package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*****************************************************************
 ChessPanel Class for Chess Project

 @author Caleb Dykstra
 @author Ryan Mansour
 @author Adam Williamson
 @version Winter 2022
 *****************************************************************/
public class ChessPanel extends JPanel {


    /**variables for creating board**/
    private JButton[][] board;
    private ChessModel model;

    /**variables for black ImageIcons**/
    private ImageIcon wRook;
    private ImageIcon wBishop;
    private ImageIcon wQueen;
    private ImageIcon wKing;
    private ImageIcon wPawn;
    private ImageIcon wKnight;

    /**variables for white ImageIcons**/
    private ImageIcon bRook;
    private ImageIcon bBishop;
    private ImageIcon bQueen;
    private ImageIcon bKing;
    private ImageIcon bPawn;
    private ImageIcon bKnight;

    /**variable for first turn**/
    private boolean firstTurnFlag;

    /**variables for board position values**/
    private int fromRow;
    private int toRow;
    private int fromCol;
    private int toCol;


    /**action listener**/
    private listener listener;


    /**ChessPanel constructor, creates board**/
    public ChessPanel() {
        model = new ChessModel();
        board = new JButton[model.numRows()][model.numColumns()];
        listener = new listener();

        createIcons();

        JPanel boardpanel = new JPanel();
        JPanel buttonpanel = new JPanel();
        boardpanel.setLayout(new GridLayout(model.numRows(), model.numColumns(), 1, 1));

        for (int r = 0; r < model.numRows(); r++) {
            for (int c = 0; c < model.numColumns(); c++) {
                if (model.pieceAt(r, c) == null) {
                    board[r][c] = new JButton("", null);
                    board[r][c].addActionListener(listener);
                } else if (model.pieceAt(r, c).player() == Player.WHITE)
                    placeWhitePieces(r, c);

                else if (model.pieceAt(r, c).player() == Player.BLACK)
                    placeBlackPieces(r, c);

                setBackGroundColor(r, c);
                boardpanel.add(board[r][c]);

            }
        }
        add(boardpanel, BorderLayout.WEST);
        boardpanel.setPreferredSize(new Dimension(600, 600));
        add(buttonpanel);
        firstTurnFlag = true;
    }


    /*****************************************************************
     * Method that sets the background color of the board to light gray/white
     * @param r - row on board
     * @param c - column on board
     *****************************************************************/
    private void setBackGroundColor(int r, int c) {
        if ((c % 2 == 1 && r % 2 == 0) || (c % 2 == 0 && r % 2 == 1)) {
            board[r][c].setBackground(Color.LIGHT_GRAY);
            board[r][c].setOpaque(true);
            board[r][c].setBorderPainted(false);
        } else if ((c % 2 == 0 && r % 2 == 0) || (c % 2 == 1 && r % 2 == 1)) {
            board[r][c].setBackground(Color.WHITE);
            board[r][c].setOpaque(true);
            board[r][c].setBorderPainted(false);
        }
    }


    /*****************************************************************
     * Method that instantiates the white pieces on the board
     * @param r - row on the board
     * @param c - column on the board
     *****************************************************************/
    private void placeWhitePieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, wPawn);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, wRook);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, wKnight);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, wBishop);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, wQueen);
            board[r][c].addActionListener(listener);
        }
        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, wKing);
            board[r][c].addActionListener(listener);
        }
    }


    /*****************************************************************
     * Method that instantiates the black pieces on the board
     * @param r - row on the board
     * @param c - column on the board
     *****************************************************************/
    private void placeBlackPieces(int r, int c) {
        if (model.pieceAt(r, c).type().equals("Pawn")) {
            board[r][c] = new JButton(null, bPawn);
            board[r][c].addActionListener(listener);
        }

        if (model.pieceAt(r, c).type().equals("Rook")) {
            board[r][c] = new JButton(null, bRook);
            board[r][c].addActionListener(listener);
        }

        if (model.pieceAt(r, c).type().equals("Knight")) {
            board[r][c] = new JButton(null, bKnight);
            board[r][c].addActionListener(listener);
        }

        if (model.pieceAt(r, c).type().equals("Bishop")) {
            board[r][c] = new JButton(null, bBishop);
            board[r][c].addActionListener(listener);
        }

        if (model.pieceAt(r, c).type().equals("Queen")) {
            board[r][c] = new JButton(null, bQueen);
            board[r][c].addActionListener(listener);
        }

        if (model.pieceAt(r, c).type().equals("King")) {
            board[r][c] = new JButton(null, bKing);
            board[r][c].addActionListener(listener);
        }
    }


    /*****************************************************************
     * Method that creates piece icons
     *****************************************************************/
    private void createIcons() {
        // Sets the Image for white player pieces
        wRook = new ImageIcon("./src/chess/wRook.png");
        wBishop = new ImageIcon("./src/chess/wBishop.png");
        wQueen = new ImageIcon("./src/chess/wQueen.png");
        wKing = new ImageIcon("./src/chess/wKing.png");
        wPawn = new ImageIcon("./src/chess/wPawn.png");
        wKnight = new ImageIcon("./src/chess/wKnight.png");
        // sets Image for black player pieces
        bRook = new ImageIcon("./src/chess/bRook.png");
        bBishop = new ImageIcon("./src/chess/bBishop.png");
        bQueen = new ImageIcon("./src/chess/bQueen.png");
        bKing = new ImageIcon("./src/chess/bKing.png");
        bPawn = new ImageIcon("./src/chess/bPawn.png");
        bKnight = new ImageIcon("./src/chess/bKnight.png");


    }

    /*****************************************************************
     * Method that updates the board
     *****************************************************************/
    private void displayBoard() {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                if (model.pieceAt(r, c) == null)
                    board[r][c].setIcon(null);
                else if (model.pieceAt(r, c).player() == Player.WHITE) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(wPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(wRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(wKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(wBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(wQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(wKing);

                } else if (model.pieceAt(r, c).player() == Player.BLACK) {
                    if (model.pieceAt(r, c).type().equals("Pawn"))
                        board[r][c].setIcon(bPawn);

                    if (model.pieceAt(r, c).type().equals("Rook"))
                        board[r][c].setIcon(bRook);

                    if (model.pieceAt(r, c).type().equals("Knight"))
                        board[r][c].setIcon(bKnight);

                    if (model.pieceAt(r, c).type().equals("Bishop"))
                        board[r][c].setIcon(bBishop);

                    if (model.pieceAt(r, c).type().equals("Queen"))
                        board[r][c].setIcon(bQueen);

                    if (model.pieceAt(r, c).type().equals("King"))
                        board[r][c].setIcon(bKing);

                }
        }
        repaint();
    }

    /*****************************************************************
     * Inner class for actionlistener buttons
     *****************************************************************/
    private class listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for (int r = 0; r < model.numRows(); r++)
                for (int c = 0; c < model.numColumns(); c++)
                    if (board[r][c] == event.getSource())
                        if (firstTurnFlag) {
                            fromRow = r;
                            fromCol = c;
                            firstTurnFlag = false;
                        } else {
                            toRow = r;
                            toCol = c;
                            firstTurnFlag = true;
                            Move m = new Move(fromRow, fromCol, toRow, toCol);
                            if (model.pieceAt(fromRow, fromCol) != null) {
                                /**displaying invalid turn message**/
                                if (model.pieceAt(fromRow, fromCol).player() != model.currentPlayer())
                                    JOptionPane.showConfirmDialog(null, "Not your turn");
                                else {
                                    if ((model.isValidMove(m))) {
                                        model.move(m);

                                        model.setNextPlayer();
                                        displayBoard();

                                    }
                                    else{
                                        /**displaying invalid move message**/
                                        if(!(model.isValidMove(m))){
                                            JOptionPane.showConfirmDialog(null, "Not a valid move");
                                        }
                                    }


                                }
                                displayBoard();
                            }
                            if(model.isComplete()){
                                /**displaying checkmate complete message**/
                                JOptionPane.showConfirmDialog(null,  "Game complete, Checkmate");
                            }

                        }

        }

    }
}


