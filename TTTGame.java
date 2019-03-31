
import java.util.Scanner;
import java.util.StringTokenizer;

public class TTTGame {

    static char[] r1 = {' ', ' ', ' '};
    static char[] r2 = {' ', ' ', ' '};
    static char[] r3 = {' ', ' ', ' '};
    private static char x;

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        System.out.println("**********************");
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("~-~-~-~-~-~-~-~-~-~-~-");
        Scanner selection = new Scanner(System.in);
        System.out.println("Main Menu:");
        System.out.println("----------");
        System.out.println("1. Play Game");
        System.out.println("2. Help");
        System.out.println("3. Exit Game");
        System.out.println();
        System.out.print("Enter command: ");
        String sel = selection.nextLine();
        StringTokenizer tk = new StringTokenizer(sel, " ");
        while (tk.countTokens() > 1) {
            System.out.println("Invalid input!\n");
            System.out.print("Enter row and column: ");
            sel = selection.nextLine();
            tk = new StringTokenizer(sel, " ");
        };
        sel = tk.nextToken();
        while (!sel.equals("1") && !sel.equals("2") && !sel.equals("3")) {
            System.out.print("Invalid command! \n");
            System.out.print("----------------------\n1.Play Game \n2.Help \n3.Exit Game \n");
            System.out.print("Enter command: \n");
            sel = selection.next();
        };
        if (sel.equals("1")) {
            StartTicTacToeGame();
        } else if (sel.equals("2")) {
            HelpScreen();
        } else if (sel.equals("3")) {
            System.out.println("Thanks for playing! \n");
            System.exit(0);
        }
        return;

    }

    public static void HelpScreen() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers, one for the row and one for the column, that you would like to place your symbol on.");
        System.out.println("For example:");
        System.out.println("    1    2    3");
        System.out.println("1 [ X ][   ][   ]");
        System.out.println("2 [ X ][ O ][ X ]");
        System.out.println("3 [ O ][ O ][ X ]");
        System.out.println();
        System.out.println("Position: 1 3");
        System.out.println("1 and 3 will place your symbol in the top right corner.\n");
        System.out.println("Typing an invalid position will cause the game to restart.\n");
        System.out.print("----------------------\n1.Return to Main Menu \n2.Exit Game \n");
        String choice = input.nextLine();
        StringTokenizer tk = new StringTokenizer(choice, " ");
        while (tk.countTokens() > 1) {
            System.out.println("Invalid input!\n");
            System.out.print("Enter row and column: ");
            choice = input.nextLine();
            tk = new StringTokenizer(choice, " ");
        };
        choice = tk.nextToken();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.print("Invalid command! \n");
            System.out.print("----------------------\n1.Return to Main Menu \n2.Exit Game \n");
            System.out.print("Enter command: \n");
            choice = input.next();
        };
        if (choice.equals("1")) {
            MainMenu();
        } else if (choice.equals("2")) {
            System.out.print("Thanks for playing! \n");
            System.exit(0);
        };

    }

    public static void StartTicTacToeGame() {

        // Game goes here
        Scanner input = new Scanner(System.in);

        char p1 = 'X'; // Player 1
        char p2 = 'O'; // Player 2
        System.out.println("Player 1 is X. Player 2 is O.");

        char player = p2;
        String player_name = "Player 1";
        boolean CONTINUE = true;

        while (CONTINUE) {

            if (r1[0] == r1[1] && r1[1] == r1[2] && r1[0] != ' '
                    || r2[0] == r2[1] && r2[1] == r2[2] && r2[0] != ' '
                    || r3[0] == r3[1] && r3[1] == r3[2] && r3[0] != ' '
                    || r1[0] == r2[0] && r2[0] == r3[0] && r1[0] != ' '
                    || r1[1] == r2[1] && r2[1] == r3[1] && r1[1] != ' '
                    || r1[2] == r2[2] && r2[2] == r3[2] && r1[2] != ' '
                    || r1[0] == r2[1] && r2[1] == r3[2] && r1[0] != ' '
                    || r1[2] == r2[1] && r2[1] == r3[0] && r1[2] != ' ') {

                showBoard();
                System.out.println("");
                r1[0] = ' ';
                r1[1] = ' ';
                r1[2] = ' ';
                r2[0] = ' ';
                r2[1] = ' ';
                r2[2] = ' ';
                r3[0] = ' ';
                r3[1] = ' ';
                r3[2] = ' ';
                System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*");
                System.out.println(player_name + " wins!");
                System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*");
                System.out.print("1.Start New Game \n2.Exit to Main Menu \n3.Exit Game \n ");
                String choice = input.next();
                while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                    System.out.print("Wrong command!\n");
                    System.out.print("1.Start New Game \n2.Exit to Main Menu \n3.Exit Game \n ");
                    System.out.print("Enter command: \n");
                    choice = input.next();
                };

                if (choice.equals("1")) {
                    StartTicTacToeGame();
                } else if (choice.equals("2")) {
                    MainMenu();
                } else if (choice.equals("3")) {
                    System.out.print("Thanks for playing! \n");
                    System.exit(0);
                }
            } else if(r1[0] != ' ' && r1[1] != ' ' && r1[2] != ' ' && r2[0] != ' ' && r2[1] != ' ' && r2[2] != ' ' && r3[0] != ' ' && r3[1] != ' ' && r3[2] != ' ') {
                    System.out.print("Draw!\n");
                    System.out.print("1.Start New Game \n2.Exit to Main Menu \n3.Exit Game \n ");
                    String choice = input.next();
                    while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                        System.out.print("Wrong command!\n");
                        System.out.print("1.Start New Game \n2.Exit to Main Menu \n3.Exit Game \n ");
                        System.out.print("Enter command: \n");
                        choice = input.next();
                    };

                    if (choice.equals("1")) {
                        StartTicTacToeGame();
                    } else if (choice.equals("2")) {
                        MainMenu();
                    } else if (choice.equals("3")) {
                        System.out.print("Goodbye \n");
                        System.exit(0);
                    }
                    
            }else{
            
                if (player == p2) {
                    player = p1;
                    player_name = "Player 1";
                } else {
                    player = p2;
                    player_name = "Player 2";
                };

                showBoard();
                System.out.println();
                System.out.println(player_name + "'s turn.");
                System.out.print("Enter row and column: ");
                String rowCol = input.nextLine();
                StringTokenizer tk = new StringTokenizer(rowCol, " ");
                while (tk.countTokens() > 2) {
                    System.out.println("Invalid input!\n");
                    System.out.print("Enter row and column: ");
                    rowCol = input.nextLine();
                    tk = new StringTokenizer(rowCol, " ");
                };

                int row = Integer.parseInt(tk.nextToken());
                int col = Integer.parseInt(tk.nextToken());

                
                    switch (row - 1) {
                        case 0:
                            if (r1[col - 1] != ' ') {
                                System.out.println("**********************************");
                                System.out.println("That box is not empty, try again. ");
                                System.out.println("**********************************");
                                if (player == p2) {
                                    player = p1;
                                    player_name = "Player 1";
                                } else {
                                    player = p2;
                                    player_name = "Player 2";
                                };
                            } else {
                                r1[col - 1] = player;
                            }
                            ;
                            break;

                        case 1:
                            if (r2[col - 1] != ' ') {
                                System.out.println("**********************************");
                                System.out.println("That box is not empty, try again. ");
                                System.out.println("**********************************");
                                if (player == p2) {
                                    player = p1;
                                    player_name = "Player 1";
                                } else {
                                    player = p2;
                                    player_name = "Player 2";
                                };
                            } else {
                                r2[col - 1] = player;
                            }
                            ;
                            break;

                        case 2:
                            if (r3[col - 1] != ' ') {
                                System.out.println("**********************************");
                                System.out.println("That box is not empty, try again. ");
                                System.out.println("**********************************");
                                System.out.println();
                                if (player == p2) {
                                    player = p1;
                                    player_name = "Player 1";
                                } else {
                                    player = p2;
                                    player_name = "Player 2";
                                };
                            } else {
                                r3[col - 1] = player;
                            }
                            ;
                            break;

                        default:
                            System.out.println("Invalid position!");
                            break;
                    }
               

            }
        }
    }

    public static void showBoard() {
        System.out.println("    1    2    3");
        System.out.println("1 [ " + r1[0] + " ][ " + r1[1] + " ][ " + r1[2] + " ]");
        System.out.println("2 [ " + r2[0] + " ][ " + r2[1] + " ][ " + r2[2] + " ]");
        System.out.println("3 [ " + r3[0] + " ][ " + r3[1] + " ][ " + r3[2] + " ]");
    }
}
