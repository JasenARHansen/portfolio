package Java.Code.Challenge;

public class Shapes {

    // Set Default Values
    static char defaultSymbol1 = '#';
    static char defaultSymbol2 = '%';
    static char defaultInscribedSymbol = ' ';

    public static void getDescription() {
        System.out.println("Generate various shapes composed of characters.");
    }

    public static void triangleLeftJustifiedPointDown(int count, char... symbolIn) {
        triangleLeftJustifiedPointDown(count, false, symbolIn);
    }

    public static void triangleLeftJustifiedPointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(symbol1).repeat(count));
        }
        if (count > 1) {
            for (int i = count - 1; i > 1; i--) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(i));
                }
            }
            System.out.println(symbol1);
        }
    }

    private static String inscribedLine(int count, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        StringBuilder step = new StringBuilder();
        if (count > 0) {
            step.append(symbol1);
        }
        if (count > 2) {
            step.append(String.valueOf(symbol2).repeat(Math.max(0, count - 2)));
        }
        if (count > 1) {
            step.append(symbol1);
        }
        return step.toString();
    }

    public static void triangleLeftJustifiedPointUp(int count, char... symbolIn) {
        triangleLeftJustifiedPointUp(count, false, symbolIn);
    }

    public static void triangleLeftJustifiedPointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(symbol1);
        }
        if (count > 1) {
            for (int i = 2; i < count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(i));
                }
            }
            System.out.println(String.valueOf(symbol1).repeat(count));
        }
    }

    public static void triangleRightJustifiedPointDown(int count, char... symbolIn) {
        triangleRightJustifiedPointDown(count, false, symbolIn);
    }

    public static void triangleRightJustifiedPointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(symbol1).repeat(count));
        }
        if (count > 1) {
            for (int i = 1; i < count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + inscribedLine(count - i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol1).repeat(count - i));
                }
            }
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
    }

    public static void triangleRightJustifiedPointUp(int count, char... symbolIn) {
        triangleRightJustifiedPointUp(count, false, symbolIn);
    }

    public static void triangleRightJustifiedPointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
        if (count > 1) {
            for (int i = 1; i < count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i - 1) + inscribedLine(i + 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i - 1) + String.valueOf(symbol1).repeat(i + 1));
                }
            }
            System.out.println(String.valueOf(symbol1).repeat(count));
        }
    }

    public static void trianglePointDown(int count, char... symbolIn) {
        trianglePointDown(count, false, symbolIn);
    }

    public static void trianglePointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(symbol1).repeat(Math.max(0, (2 * count) - 1)));
        }
        if (count > 1) {
            for (int i = count - 1; i > 1; i--) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + inscribedLine((2 * i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + String.valueOf(symbol1).repeat((2 * i) - 1));
                }
            }
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
    }

    public static void trianglePointUp(int count, char... symbolIn) {
        trianglePointUp(count, false, symbolIn);
    }

    public static void trianglePointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
        if (count > 1) {
            for (int i = 2; i <= count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + inscribedLine((2 * i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol1).repeat(((2 * i) - 1)));
                }
            }
            System.out.println(String.valueOf(symbol1).repeat((2 * count) - 1));
        }
    }

    public static void trianglePointLeft(int count, char... symbolIn) {
        trianglePointLeft(count, false, symbolIn);
    }

    public static void trianglePointLeft(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
        if (count > 1) {
            StringBuilder padding;
            for (int i = 2; i <= count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i));
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(padding + inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(padding + String.valueOf(symbol1).repeat(i));
                }
            }
            for (int i = count - 1; i > 1; i--) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i));
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(padding + inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(padding + String.valueOf(symbol1).repeat(i));
                }
            }
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
    }

    public static void trianglePointRight(int count, char... symbolIn) {
        trianglePointRight(count, false, symbolIn);
    }

    public static void trianglePointRight(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(symbol1);
        }
        if (count > 1) {
            for (int i = 2; i <= count; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(i));
                }
            }
            for (int i = 1; i < count; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(count - i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(count - i));
                }
            }
        }
    }

    public static void parallelogramPointRight(int count, char... symbolIn) {
        parallelogramPointRight(count, false, symbolIn);
    }

    public static void parallelogramPointRight(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(symbol1);
        }
        if (count > 1) {
            for (int i = 2; i <= count; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(i));
                }
            }
            StringBuilder padding;
            for (int i = count - 1; i > 0; i--) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i));
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(padding + inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(padding + String.valueOf(symbol1).repeat(i));
                }
            }
        }
    }

    public static void parallelogramPointLeft(int count, char... symbolIn) {
        parallelogramPointLeft(count, false, symbolIn);
    }

    public static void parallelogramPointLeft(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        StringBuilder padding;
        if (count > 0) {
            padding = new StringBuilder();
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - 1));
            System.out.println(padding.toString() + symbol1);
        }
        if (count > 1) {
            for (int i = 2; i <= count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i));
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(padding + inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(padding + String.valueOf(symbol1).repeat(i));
                }
            }
            for (int i = count - 1; i > 0; i--) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(i));
                }
            }
        }
    }

    public static void diamond(int count, char... symbolIn) {
        diamond(count, false, symbolIn);
    }

    public static void diamond(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol1);
        }
        if (count > 1) {
            for (int i = 2; i <= count; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol1).repeat((2 * i) - 1));
                }
            }
            for (int i = 0; i < count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i + 1) + inscribedLine(2 * (count - 1 - i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i + 1) + String.valueOf(symbol1).repeat(2 * (count - 1 - i) - 1));
                }
            }
        }
    }

    public static void hourglass(int count, char... symbolIn) {
        hourglass(count, false, symbolIn);
    }

    public static void hourglass(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        final String repeat = String.valueOf(symbol1).repeat((2 * count) - 1);
        if (count > 0) {
            System.out.println(repeat);
        }
        if (count > 1) {
            for (int i = count - 1; i > 0; i--) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + inscribedLine((2 * i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + String.valueOf(symbol1).repeat((2 * i) - 1));
                }
            }
            for (int i = 2; i <= count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + inscribedLine((2 * i) - 1, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - i) + String.valueOf(symbol1).repeat((2 * i) - 1));
                }
            }
            System.out.println(repeat);
        }
    }

    public static void rectangle(int height, int width, char... symbolIn) {
        rectangle(height, width, false, symbolIn);
    }

    public static void rectangle(int height, int width, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (height > 0) {
            System.out.println(String.valueOf(symbol1).repeat(width));
        }
        if (height > 1) {
            for (int i = 0; i < height - 2; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(width, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat(width));
                }
            }
            System.out.println(String.valueOf(symbol1).repeat(width));
        }
    }

    public static void square(int width, char... symbolIn) {
        //noinspection SuspiciousNameCombination
        rectangle(width, width, false, symbolIn);
    }

    public static void square(int width, boolean inscribed, char... symbolIn) {
        //noinspection SuspiciousNameCombination
        rectangle(width, width, inscribed, symbolIn);
    }

    public static void squareX(int count, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        for (int i = 0; i < count; i++) {
            String padding = String.valueOf(symbol2).repeat(i);
            System.out.println(padding + String.valueOf(symbol1).repeat(2 * (count - i) - 1) + padding);
        }
        for (int i = 2; i <= count; i++) {
            String padding = String.valueOf(symbol2).repeat(Math.max(0, count - i));
            System.out.println(padding + String.valueOf(symbol1).repeat((2 * i) - 1) + padding);
        }
    }

    public static void splitSquarePointDown(int count, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        for (int i = 0; i < count; i++) {
            System.out.println(String.valueOf(symbol1).repeat(i) + String.valueOf(symbol2).repeat(count - i));
        }
    }

    public static void splitSquarePointUp(int count, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        for (int i = 1; i <= count; i++) {
            System.out.println(String.valueOf(symbol1).repeat(count - i) + String.valueOf(symbol2).repeat(i));
        }
    }

    public static void inscribedSquare(int count, char... symbolIn) {
        inscribedSquare(count, false, symbolIn);
    }

    public static void inscribedSquare(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        if (inscribed) {
            symbol2 = defaultInscribedSymbol;
        }
        if (count > 0) {
            for (int i = 0; i <= count; i++) {
                String padding = String.valueOf(symbol1).repeat(count - i);
                String middle = inscribedLine((2 * i) + 1, symbol1, symbol2);
                System.out.println(padding + middle + padding);
            }
            for (int i = 0; i < count; i++) {
                String padding = String.valueOf(symbol1).repeat(i + 1);
                String middle = inscribedLine(2 * (count - i) - 1, symbol1, symbol2);
                System.out.println(padding + middle + padding);
            }
        }
    }

    public static void hexagon(int count, char... symbolIn) {
        hexagon(count, false, symbolIn);
    }

    public static void hexagon(int count, boolean inscribed, char... symbolIn) {
        char symbol1 = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;
        if (count > 0) {
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + String.valueOf(symbol1).repeat(count));
        }
        if (count > 1) {
            for (int i = count - 1; i > 0; i--) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i - 1) + inscribedLine(count + 2 * (count - i), symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i - 1) + String.valueOf(symbol1).repeat((count + 2 * (count - i))));
                }
            }
            for (int i = 0; i < count - 2; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(inscribedLine(3 * count - 2, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(symbol1).repeat((3 * count - 2)));
                }
            }
            for (int i = 0; i < count - 1; i++) {
                if (inscribed || (symbolIn.length > 1)) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + inscribedLine((3 * count - 2) - 2 * i, symbol1, symbol2));
                } else {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol1).repeat(((3 * count - 2) - 2 * i)));
                }
            }
            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + String.valueOf(symbol1).repeat(count));
        }
    }

    public static void main(String[] argv) throws Exception {
    }
}
