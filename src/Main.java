import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    public static char[][] map;

    static final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = '0';

    public static void main(String[] args) {
        init();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(X_FIELD)) {
                System.out.println("Игра завершена. Победил игрок");
            }
            if (checkDraft()) {
                System.out.println("Игра завершена. Ничья.");
                break;
            }

            computerTurn();
            printMap();
            if (checkWin(O_FIELD)) {
                System.out.println("Игра завершена. Победил компьютер");
            }
            if (checkDraft()) {
                System.out.println("Игра завершена. Ничья.");
                break;
            }
        }
    }
    public static boolean checkWin(char Player_Field) {
if (map[0][0] ==Player_Field && map[0][1] == Player_Field && map[0][2] == Player_Field) return true;
        if (map[1][0] ==Player_Field && map[1][1] == Player_Field && map[1][2] == Player_Field) return true;
        if (map[2][0] ==Player_Field && map[2][2] == Player_Field && map[2][2] == Player_Field) return true;

        if (map[0][0] ==Player_Field && map[1][0] == Player_Field && map[2][0] == Player_Field) return true;
        if (map[0][1] ==Player_Field && map[1][1] == Player_Field && map[2][1] == Player_Field) return true;
        if (map[0][2] ==Player_Field && map[1][2] == Player_Field && map[2][2] == Player_Field) return true;

        if (map[0][0] ==Player_Field && map[1][1] == Player_Field && map[2][2] == Player_Field) return true;
        if (map[0][2] ==Player_Field && map[1][1] == Player_Field && map[2][0] == Player_Field) return true;
        return false;
    }

    public static boolean checkDraft() {
        for (int i = 0; i<3; ++i) {
            for (int j = 0; j<3; ++j) {
                if (map[i][j] == EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean IsCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        if (map[y][x] != EMPTY_FIELD) {
            return false;
        }
        return true;
    }

    public static void computerTurn() {
        int x, y;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
        } while (!IsCellValid(x, y));
        map[y][x] = O_FIELD;
        System.out.println("Компьютер сделал ход: " + (x + 1) + " " + (y + 1));
    }

    public static void humanTurn() {
        System.out.println("Ход игрока. Введите координаты вашего хода X Y");
        int x, y;
        do {
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!IsCellValid(x, y));

        map[y][x] = X_FIELD;
        System.out.println("Вы ввели: " + (x + 1) + " " + (y + 1));
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void init() {
        map = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                map[i][j] = EMPTY_FIELD;
            }
        scanner = new Scanner(System.in);
    }
} c