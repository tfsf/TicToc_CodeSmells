package objects;

import proxy.InputProxy;


public class Game {

    private String[][] marksArray;
    private String[] marks;

    public Game() {
        marksArray = new String[][]{{"", "", ""}, {"", "", ""}, {"", "", ""}};
        marks = new String[]{"O", "X"};

    }


    public boolean move(String index, int player) {
        int x, y;
        Board br = new Board();
        InputProxy inputProxy = new InputProxy();
        if (inputProxy.proxyTest(index)) {
            String[] tokens = inputProxy.getCode();
            x = Integer.parseInt(tokens[0]);
            y = Integer.parseInt(tokens[1]);

            marksArray[x][y] = marks[player];

            br.printBoard(marksArray);
            return true;
        }
        return false;
    }


    private boolean validateCell(String s) {
        int x, y;
        InputProxy inputProxy = new InputProxy();
        if (inputProxy.proxyTest(s)) return false;
        String[] tokens = inputProxy.getCode();
        x = Integer.parseInt(tokens[0]);
        y = Integer.parseInt(tokens[1]);

        return marksArray[x][y].equals("");
    }


    public int gameStatus() {
        int draw = 0;
        int playerWon = 1;
        int comWon = 2;
        int nextTurn = 3;

        if (playerWonTest())
            return playerWon;
        else if (comWonTest())
            return comWon;
        else if (turnTest())
            return nextTurn;
        else
            return draw;
    }

    private boolean turnTest() {
        boolean tt = false;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (marksArray[x][y].equals(""))
                    tt = true;
            }
        }
        return tt;

    }

    private boolean playerWonTest() {
        return wonTest("X");
    }

    private boolean comWonTest() {
        return wonTest("O");
    }

    private boolean wonTest(String symbol) {
        return (marksArray[0][0].equals(symbol) && marksArray[0][1].equals(symbol) && marksArray[0][2].equals(symbol)) ||//first row
                (marksArray[1][0].equals(symbol) && marksArray[1][1].equals(symbol) && marksArray[1][2].equals(symbol)) ||//second row
                (marksArray[2][0].equals(symbol) && marksArray[2][1].equals(symbol) && marksArray[2][2].equals(symbol)) ||//third row
                (marksArray[0][0].equals(symbol) && marksArray[1][0].equals(symbol) && marksArray[2][0].equals(symbol)) ||//first column
                (marksArray[0][1].equals(symbol) && marksArray[1][1].equals(symbol) && marksArray[2][1].equals(symbol)) ||//second column
                (marksArray[0][2].equals(symbol) && marksArray[1][2].equals(symbol) && marksArray[2][2].equals(symbol)) ||//third column
                (marksArray[0][0].equals(symbol) && marksArray[1][1].equals(symbol) && marksArray[2][2].equals(symbol)) ||//diagonal
                (marksArray[0][2].equals(symbol) && marksArray[1][1].equals(symbol) && marksArray[2][0].equals(symbol));

    }

    public String comMove() {
        int x, y;
        String m = "";
        boolean i = true;
        while (i) {

            x = (int) Math.floor(Math.random() * 3);
            y = (int) Math.floor(Math.random() * 3);
            m = x + "," + y;
            i = !validateCell(m);
        }
        return m;
    }
}

