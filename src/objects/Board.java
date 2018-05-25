package objects;

public class Board {

    Board() {}

    public void printBoard(String[][] marksArray) {
        System.out.print("\n");
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (marksArray[x][y].equals("")) print(" ");
                else
                    print(marksArray[x][y] + "");
                if (y == 2) continue;
                print(" |");
            }
            print("\n");
            if (x == 2) continue;
            print("________");
            print("\n");
        }
        System.out.print("\n \n\n \n");
    }


    public void print(Object o) {

        System.out.print(o);

    }
}
