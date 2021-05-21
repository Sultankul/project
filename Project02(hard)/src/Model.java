import java.util.Stack;

public class Model {
    private View viewer;
    private char[][] matrix;
    private int indexOfX;
    private int indexOfY;
    private int[][] arrayOfIndexes;
    private Stack<Integer[]> undo = new Stack<>();
    private Stack<Integer[]> redo = new Stack<>();
    private boolean isOrdinaryMove = true;
    private Level levelParser;
    public static int moves = 0;
    private String cmd = "Down";


    public Model(View viewer) {
        this.viewer = viewer;
        levelParser = new Level();
        matrix = levelParser.parse();
        int[] indexes = getPlayerIndexes(matrix);
        indexOfX = indexes[0];
        indexOfY = indexes[1];
        initialization();
    }

    public void startGame() {
        matrix = levelParser.parse();
        int[] indexes = getPlayerIndexes(matrix);
        indexOfX = indexes[0];
        indexOfY = indexes[1];
        cmd = "Down";
        initialization();
        viewer.update();
    }

    public Level getLevelParser() {
        return levelParser;
    }

    private void initialization() {
        int counterGoal = 0;
        for (char[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == '.') {
                    counterGoal = counterGoal + 1;
                }
            }
        }

        arrayOfIndexes = new int[2][counterGoal];

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '.') {
                    arrayOfIndexes[0][count] = i;
                    arrayOfIndexes[1][count] = j;
                    count++;
                }
            }
        }
    }

    public void move(String direction) {
        switch (direction) {
            case "Right":
                moveRight();
                break;
            case "Left":
                moveLeft();
                break;
            case "Up":
                moveUp();
                break;
            case "Down":
                moveDown();
                break;
            case "Restart":
                startGame();
                cmd = "Down";
                break;
            default:
                return;
        }
        cmd = direction;
        moves++;
        viewer.update();
        check();

    }

    public String getCmd() {
        return cmd;
    }

    public void redoOrUndo(String stackName) {

        Stack<Integer[]> temp = stackName.equals("redo") ? redo : undo;

        if (!temp.isEmpty()) {
            Integer[] nums = temp.peek();
            if (stackName.equals("undo")) {
                redo.push(temp.pop());
                if (temp.size() == 1) {
                    redo.push(undo.peek());
                }
            } else {
                undo.push(temp.pop());
            }
            String direction = null;

            if (temp.size() != 0) {
                if (nums[0] == temp.peek()[0] && nums[1] > temp.peek()[1]) {
                    direction = "Left"; //left
                } else if (nums[0] == temp.peek()[0] && nums[1] < temp.peek()[1]) {
                    direction = "Right"; // right;
                } else if (nums[0] > temp.peek()[0] && nums[1] == temp.peek()[1]) {
                    direction = "Up"; // up
                } else if (nums[0] < temp.peek()[0] && nums[1] == temp.peek()[1]) {
                    direction = "Down"; // down
                } else {
                    return;
                }
            } else {
                return;
            }
            isOrdinaryMove = false;
            move(direction);

        }
    }

    public void setOrdinaryMove(boolean ordinaryMove) {
        isOrdinaryMove = ordinaryMove;
    }

    private void check() {

        int t = 0;
        for (int j = 0; j < arrayOfIndexes[0].length; j++) {
            int x = arrayOfIndexes[0][t];
            int y = arrayOfIndexes[1][t];
            if (matrix[x][y] == ' ') {
                matrix[x][y] = '.';
                break;


            }
            t++;
        }
        if (checkWin()) {
            viewer.winnersWindow();
            levelParser.incLine();
            startGame();
            startGame();
        }
    }

    private boolean checkWin() {

        boolean flag = true;
        for (int z = 0; z < arrayOfIndexes[0].length; z++) {
            int i = arrayOfIndexes[0][z];
            int x = arrayOfIndexes[1][z];

            if (matrix[i][x] == '.' || matrix[i][x] == '@') {
                flag = false;
                break;
            }
        }
        return flag;

    }

    private void moveDown() {
        if (matrix[indexOfX + 1][indexOfY] == '$') {
            if (matrix[indexOfX + 2][indexOfY] == ' ' || matrix[indexOfX + 2][indexOfY] == '.') {
                matrix[indexOfX + 1][indexOfY] = ' ';
                matrix[indexOfX + 2][indexOfY] = '$';
            }
        }

        if (matrix[indexOfX + 1][indexOfY] == ' ' || matrix[indexOfX + 1][indexOfY] == '.') {
            matrix[indexOfX][indexOfY] = ' ';
            indexOfX += 1;
            matrix[indexOfX][indexOfY] = '@';
        }
        if (isOrdinaryMove) {
            undo.push(new Integer[]{indexOfX, indexOfY});

        }
    }


    private void moveUp() {
        if (matrix[indexOfX - 1][indexOfY] == '$') {
            if (matrix[indexOfX - 2][indexOfY] == ' ' || matrix[indexOfX - 2][indexOfY] == '.') {
                matrix[indexOfX - 1][indexOfY] = ' ';
                matrix[indexOfX - 2][indexOfY] = '$';
            }
        }

        if (matrix[indexOfX - 1][indexOfY] == ' ' || matrix[indexOfX - 1][indexOfY] == '.') {
            matrix[indexOfX][indexOfY] = ' ';
            indexOfX -= 1;
            matrix[indexOfX][indexOfY] = '@';
        }
        if (isOrdinaryMove) {
            undo.push(new Integer[]{indexOfX, indexOfY});
        }
    }

    private void moveLeft() {
        if (matrix[indexOfX][indexOfY - 1] == '$') {
            if (matrix[indexOfX][indexOfY - 2] == ' ' || matrix[indexOfX][indexOfY - 2] == '.') {
                matrix[indexOfX][indexOfY - 1] = ' ';
                matrix[indexOfX][indexOfY - 2] = '$';
            }
        }

        if (matrix[indexOfX][indexOfY - 1] == ' ' || matrix[indexOfX][indexOfY - 1] == '.') {
            matrix[indexOfX][indexOfY] = ' ';
            indexOfY -= 1;
            matrix[indexOfX][indexOfY] = '@';
        }
        if (isOrdinaryMove) {
            undo.push(new Integer[]{indexOfX, indexOfY});
        }
    }

    private void moveRight() {
        if (matrix[indexOfX][indexOfY + 1] == '$') {
            if (matrix[indexOfX][indexOfY + 2] == ' ' || matrix[indexOfX][indexOfY + 2] == '.') {
                matrix[indexOfX][indexOfY + 1] = ' ';
                matrix[indexOfX][indexOfY + 2] = '$';
            }
        }

        if (matrix[indexOfX][indexOfY + 1] == ' ' || matrix[indexOfX][indexOfY + 1] == '.') {
            matrix[indexOfX][indexOfY] = ' ';
            indexOfY += 1;
            matrix[indexOfX][indexOfY] = '@';
        }
        if (isOrdinaryMove) {
            undo.push(new Integer[]{indexOfX, indexOfY});
        }
    }

    public char[][] getMatrix() {
        return matrix;
    }

    private int[] getPlayerIndexes(char[][] matrix) {
        int[] result = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '@') {
                    result[0] = i;
                    result[1] = j;
                    undo.push(new Integer[]{i, j});
                }
            }
        }

        return result;
    }


}
