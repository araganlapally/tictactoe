import java.util.*;

class A {
    Scanner sc = new Scanner(System.in);
    int r, c;
    char[][] a = new char[3][3];
    int count1=0;

    void player() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    void game() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = '-';
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("It's player1's turn");
            System.out.println("Enter row:");
            r = sc.nextInt();
            System.out.println("Enter column:");
            c = sc.nextInt();
            swap(r, c, 'X');
            player();
            if (checkWin('X')) {
                System.out.println("Player 1 wins!");
                return;
            }
            count1++;
if(count1==9)
{
System.out.println("draw");
return;
}
            System.out.println("It's player2's turn");
            System.out.println("Enter row:");
            r = sc.nextInt();
            System.out.println("Enter column:");
            c = sc.nextInt();
            swap(r, c, 'O');
            player();
            if (checkWin('O')) {
                System.out.println("Player 2 wins!");
                        return;
              
            }
count1++;
        }
        System.out.println("It's a draw!");
    }

    void swap(int r, int c, char player) {
        if (r >= 0 && r < 3 && c >= 0 && c < 3 && a[r][c] == '-') {
            a[r][c] = player;
            System.out.println("Move made at (" + r + "," + c + "): " + a[r][c]);
        } else {
            System.out.println("Invalid move, try again");
        }
    }

    boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == player && a[i][1] == player && a[i][2] == player) return true;
            if (a[0][i] == player && a[1][i] == player && a[2][i] == player) return true;
        }
        if (a[0][0] == player && a[1][1] == player && a[2][2] == player) return true;
        if (a[0][2] == player && a[1][1] == player && a[2][0] == player) return true;
        
        return false;
    }
}

class Tictac {
    public static void main(String args[]) {
        A obj = new A();
        obj.game();
    }
}
