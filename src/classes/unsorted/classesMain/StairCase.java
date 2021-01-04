package classes.unsorted.classesMain;

public class StairCase {

    // Set Default Values
    static char defaultSymbol1 = '#';
    static char defaultSymbol2 = '%';
    static char defaultInscribedSymbol = ' ';
    static boolean defaultInscribed = true;

    public static void main(String[] argv) throws Exception {

        // Variable Definition and declaration
        int methodCount = 80;
        int defaultCount = 7;
        char firstSymbol = '@';
        char secondSymbol = '$';

        for (int methodLoopCount = 1; methodLoopCount <= methodCount; methodLoopCount++) {

            // hexagon
            // Inscribed hexagon
            switch (methodLoopCount) {
                case 1 -> {
                    System.out.format("\nPrint Case %d: Left Justified Triangle Point Down\n", methodLoopCount);
                    triangleLeftJustifiedPointDown(defaultCount);
                }
                case 2 -> {
                    System.out.format("\nPrint Case %d: Left Justified Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointDown(defaultCount, firstSymbol);
                }
                case 3 -> {
                    System.out.format("\nPrint Case %d: Left Justified Hollow Triangle Point Down\n", methodLoopCount);
                    triangleLeftJustifiedPointDown(defaultCount, defaultInscribed);
                }
                case 4 -> {
                    System.out.format("\nPrint Case %d: Left Justified Hollow Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointDown(defaultCount, defaultInscribed, firstSymbol);
                }
                case 5 -> {
                    System.out.format("\nPrint Case %d: Left Justified Filled Triangle Point Down with Selected Symbols\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointDown(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 6 -> {
                    System.out.format("\nPrint Case %d: Left Justified Triangle Point Up\n", methodLoopCount);
                    triangleLeftJustifiedPointUp(defaultCount);
                }
                case 7 -> {
                    System.out.format("\nPrint Case %d: Left Justified Triangle Point Up with Selected Symbol\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointUp(defaultCount, firstSymbol);
                }
                case 8 -> {
                    System.out.format("\nPrint Case %d: Left Justified Hollow Triangle Point Up\n", methodLoopCount);
                    triangleLeftJustifiedPointUp(defaultCount, defaultInscribed);
                }
                case 9 -> {
                    System.out.format("\nPrint Case %d: Left Justified Hollow Triangle Point Up with Selected Symbol\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointUp(defaultCount, defaultInscribed, firstSymbol);
                }
                case 10 -> {
                    System.out.format("\nPrint Case %d: Left Justified Filled Triangle Point Up with Selected Symbols\n",
                            methodLoopCount);
                    triangleLeftJustifiedPointUp(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 11 -> {
                    System.out.format("\nPrint Case %d: Right Justified Triangle Point Down\n", methodLoopCount);
                    triangleRightJustifiedPointDown(defaultCount);
                }
                case 12 -> {
                    System.out.format("\nPrint Case %d: Right Justified Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    triangleRightJustifiedPointDown(defaultCount, firstSymbol);
                }
                case 13 -> {
                    System.out.format("\nPrint Case %d: Right Justified Hollow Triangle Point Down\n", methodLoopCount);
                    triangleRightJustifiedPointDown(defaultCount, defaultInscribed);
                }
                case 14 -> {
                    System.out.format("\nPrint Case %d: Right Justified Hollow Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    triangleRightJustifiedPointDown(defaultCount, defaultInscribed, firstSymbol);
                }
                case 15 -> {
                    System.out.format("\nPrint Case %d: Right Justified Filled Triangle Point Down with Selected Symbols\n",
                            methodLoopCount);
                    triangleRightJustifiedPointDown(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 16 -> {
                    System.out.format("\nPrint Case %d: Right Justified Triangle Point Up\n", methodLoopCount);
                    triangleRightJustifiedPointUp(defaultCount);
                }
                case 17 -> {
                    System.out.format("\nPrint Case %d: Right Justified Triangle Point Up with Selected Symbol\n",
                            methodLoopCount);
                    triangleRightJustifiedPointUp(defaultCount, firstSymbol);
                }
                case 18 -> {
                    System.out.format("\nPrint Case %d: Right Justified Hollow Triangle Point Up\n", methodLoopCount);
                    triangleRightJustifiedPointUp(defaultCount, defaultInscribed);
                }
                case 19 -> {
                    System.out.format("\nPrint Case %d: Right Justified Hollow Triangle Point Up with Selected Symbol\n",
                            methodLoopCount);
                    triangleRightJustifiedPointUp(defaultCount, defaultInscribed, firstSymbol);
                }
                case 20 -> {
                    System.out.format("\nPrint Case %d: Right Justified Filled Triangle Point Up with Selected Symbols\n",
                            methodLoopCount);
                    triangleRightJustifiedPointUp(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 21 -> {
                    System.out.format("\nPrint Case %d: Triangle Point Down\n", methodLoopCount);
                    trianglePointDown(defaultCount);
                }
                case 22 -> {
                    System.out.format("\nPrint Case %d:Triangle Point Down with Selected Symbol\n", methodLoopCount);
                    trianglePointDown(defaultCount, firstSymbol);
                }
                case 23 -> {
                    System.out.format("\nPrint Case %d: Hollow Triangle Point Down Down\n", methodLoopCount);
                    trianglePointDown(defaultCount, defaultInscribed);
                }
                case 24 -> {
                    System.out.format("\nPrint Case %d: Hollow Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    trianglePointDown(defaultCount, defaultInscribed, firstSymbol);
                }
                case 25 -> {
                    System.out.format("\nPrint Case %d: Filled In Triangle Point Down with Selected Symbol\n",
                            methodLoopCount);
                    trianglePointDown(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 26 -> {
                    System.out.format("\nPrint Case %d: Triangle Point Up\n", methodLoopCount);
                    trianglePointUp(defaultCount);
                }
                case 27 -> {
                    System.out.format("\nPrint Case %d: Triangle Point Up with Selected Symbol\n", methodLoopCount);
                    trianglePointUp(defaultCount, firstSymbol);
                }
                case 28 -> {
                    System.out.format("\nPrint Case %d: Hollow Triangle Point Up\n", methodLoopCount);
                    trianglePointUp(defaultCount, defaultInscribed);
                }
                case 29 -> {
                    System.out.format("\nPrint Case %d: Hollow Triangle Point Up with Selected Symbol\n", methodLoopCount);
                    trianglePointUp(defaultCount, defaultInscribed, firstSymbol);
                }
                case 30 -> {
                    System.out.format("\nPrint Case %d: Filled In Triangle Point Up with Selected Symbols\n",
                            methodLoopCount);
                    trianglePointUp(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 31 -> {
                    System.out.format("\nPrint Case %d: Left Facing Triangle\n", methodLoopCount);
                    trianglePointLeft(defaultCount);
                }
                case 32 -> {
                    System.out.format("\nPrint Case %d: Left Facing Triangle with Selected Symbol\n", methodLoopCount);
                    trianglePointLeft(defaultCount, firstSymbol);
                }
                case 33 -> {
                    System.out.format("\nPrint Case %d: Left Facing Hollow Triangle\n", methodLoopCount);
                    trianglePointLeft(defaultCount, defaultInscribed);
                }
                case 34 -> {
                    System.out.format("\nPrint Case %d: Left Facing Hollow Triangle with Selected Symbol\n",
                            methodLoopCount);
                    trianglePointLeft(defaultCount, defaultInscribed, firstSymbol);
                }
                case 35 -> {
                    System.out.format("\nPrint Case %d: Left Facing Filled In Triangle with Selected Symbols\n",
                            methodLoopCount);
                    trianglePointLeft(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 36 -> {
                    System.out.format("\nPrint Case %d: Right Facing Triangle\n", methodLoopCount);
                    trianglePointRight(defaultCount);
                }
                case 37 -> {
                    System.out.format("\nPrint Case %d: Right Facing Triangle with Selected Symbol\n", methodLoopCount);
                    trianglePointRight(defaultCount, firstSymbol);
                }
                case 38 -> {
                    System.out.format("\nPrint Case %d: Right Facing Hollow Triangle\n", methodLoopCount);
                    trianglePointRight(defaultCount, defaultInscribed);
                }
                case 39 -> {
                    System.out.format("\nPrint Case %d: Right Facing Hollow Triangle with Selected Symbol\n",
                            methodLoopCount);
                    trianglePointRight(defaultCount, defaultInscribed, firstSymbol);
                }
                case 40 -> {
                    System.out.format("\nPrint Case %d: Right Facing Filled In Triangle with Selected Symbols\n",
                            methodLoopCount);
                    trianglePointRight(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 41 -> {
                    System.out.format("\nPrint Case %d: Right Leaning Parallelogram\n", methodLoopCount);
                    parallelogramPointRight(defaultCount);
                }
                case 42 -> {
                    System.out.format("\nPrint Case %d: Right Leaning Parallelogram with Selected Symbol\n",
                            methodLoopCount);
                    parallelogramPointRight(defaultCount, firstSymbol);
                }
                case 43 -> {
                    System.out.format("\nPrint Case %d: Right Leaning Hollow Parallelogram\n", methodLoopCount);
                    parallelogramPointRight(defaultCount, defaultInscribed);
                }
                case 44 -> {
                    System.out.format("\nPrint Case %d: Right Leaning Hollow Parallelogram with Selected Symbol\n",
                            methodLoopCount);
                    parallelogramPointRight(defaultCount, defaultInscribed, firstSymbol);
                }
                case 45 -> {
                    System.out.format("\nPrint Case %d: Right Leaning Filled In Parallelogram with Selected Symbols\n",
                            methodLoopCount);
                    parallelogramPointRight(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 46 -> {
                    System.out.format("\nPrint Case %d: Left Leaning Parallelogram\n", methodLoopCount);
                    parallelogramPointLeft(defaultCount);
                }
                case 47 -> {
                    System.out.format("\nPrint Case %d: Left Leaning Parallelogram with Selected Symbol\n",
                            methodLoopCount);
                    parallelogramPointLeft(defaultCount, firstSymbol);
                }
                case 48 -> {
                    System.out.format("\nPrint Case %d: Left Leaning Hollow Parallelogram\n", methodLoopCount);
                    parallelogramPointLeft(defaultCount, defaultInscribed);
                }
                case 49 -> {
                    System.out.format("\nPrint Case %d: Left Leaning Hollow Parallelogram with Selected Symbol\n",
                            methodLoopCount);
                    parallelogramPointLeft(defaultCount, defaultInscribed, firstSymbol);
                }
                case 50 -> {
                    System.out.format("\nPrint Case %d: Left Leaning Filled In Parallelogram with Selected Symbols\n",
                            methodLoopCount);
                    parallelogramPointLeft(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 51 -> {
                    System.out.format("\nPrint Case %d: Diamond\n", methodLoopCount);
                    diamond(defaultCount);
                }
                case 52 -> {
                    System.out.format("\nPrint Case %d: Diamond with Selected Symbol\n", methodLoopCount);
                    diamond(defaultCount, firstSymbol);
                }
                case 53 -> {
                    System.out.format("\nPrint Case %d: Hollow Diamond\n", methodLoopCount);
                    diamond(defaultCount, defaultInscribed);
                }
                case 54 -> {
                    System.out.format("\nPrint Case %d: Hollow Diamond with Selected Symbol\n", methodLoopCount);
                    diamond(defaultCount, defaultInscribed, firstSymbol);
                }
                case 55 -> {
                    System.out.format("\nPrint Case %d: Filled In Diamond with Selected Symbols\n", methodLoopCount);
                    diamond(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 56 -> {
                    System.out.format("\nPrint Case %d: Hourglass\n", methodLoopCount);
                    hourglass(defaultCount);
                }
                case 57 -> {
                    System.out.format("\nPrint Case %d: Hourglass with Selected Symbol\n", methodLoopCount);
                    hourglass(defaultCount, firstSymbol);
                }
                case 58 -> {
                    System.out.format("\nPrint Case %d: Hollow Hourglass\n", methodLoopCount);
                    hourglass(defaultCount, defaultInscribed);
                }
                case 59 -> {
                    System.out.format("\nPrint Case %d: Hollow Hourglass with Selected Symbol\n", methodLoopCount);
                    hourglass(defaultCount, defaultInscribed, firstSymbol);
                }
                case 60 -> {
                    System.out.format("\nPrint Case %d: Filled In Hourglass with Selected Symbols\n", methodLoopCount);
                    hourglass(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                case 61 -> {
                    System.out.format("\nPrint Case %d: X Square\n", methodLoopCount);
                    xSquare(defaultCount);
                }
                case 62 -> {
                    System.out.format("\nPrint Case %d: X Square with Selected Symbol\n", methodLoopCount);
                    xSquare(defaultCount, firstSymbol);
                }
                case 63 -> {
                    System.out.format("\nPrint Case %d: Filled In X Square with Selected Symbols\n", methodLoopCount);
                    xSquare(defaultCount, firstSymbol, secondSymbol);
                }
                case 64 -> {
                    System.out.format("\nPrint Case %d: Split Square Point Down\n", methodLoopCount);
                    splitSquarePointDown(defaultCount);
                }
                case 65 -> {
                    System.out.format("\nPrint Case %d: Split Square Point Down with Selected Symbol\n", methodLoopCount);
                    splitSquarePointDown(defaultCount, firstSymbol);
                }
                case 66 -> {
                    System.out.format("\nPrint Case %d: Split Square Point Down with Selected Symbols\n", methodLoopCount);
                    splitSquarePointDown(defaultCount, firstSymbol, secondSymbol);
                }
                case 67 -> {
                    System.out.format("\nPrint Case %d: Split Square Point Up\n", methodLoopCount);
                    splitSquarePointUp(defaultCount);
                }
                case 68 -> {
                    System.out.format("\nPrint Case %d: y Point Up with Selected Symbol\n", methodLoopCount);
                    splitSquarePointUp(defaultCount, firstSymbol);
                }
                case 69 -> {
                    System.out.format("\nPrint Case %d: Split Square Point Up with Selected Symbols\n", methodLoopCount);
                    splitSquarePointUp(defaultCount, firstSymbol, secondSymbol);
                }
                case 70 -> {
                    System.out.format("\nPrint Case %d: Inscribed Square\n", methodLoopCount);
                    inscribedSquare(defaultCount);
                }
                case 71 -> {
                    System.out.format("\nPrint Case %d: Inscribed Hollow Square\n", methodLoopCount);
                    inscribedSquare(defaultCount, defaultInscribed);
                }
                case 72 -> {
                    System.out.format("\nPrint Case %d: Inscribed Hollow Square with Selected Symbols\n", methodLoopCount);
                    inscribedSquare(defaultCount, defaultInscribed, firstSymbol);
                }
                case 73 -> {
                    System.out.format("\nPrint Case %d: Inscribed Square Point Up with Selected Symbol\n", methodLoopCount);
                    inscribedSquare(defaultCount, firstSymbol);
                }
                case 74 -> {
                    System.out.format("\nPrint Case %d: Inscribed Square Point Up with Selected Symbols\n",
                            methodLoopCount);
                    inscribedSquare(defaultCount, firstSymbol, secondSymbol);
                }
                case 75 -> {
                    System.out.format("\nPrint Case %d: Hexagon\n", methodLoopCount);
                    hexagon(defaultCount);
                }
                case 76 -> {
                    System.out.format("\nPrint Case %d: Hexagon with Selected Symbol\n", methodLoopCount);
                    hexagon(defaultCount, firstSymbol);
                }
                case 77 -> {
                    System.out.format("\nPrint Case %d: Hollow Hexagon\n", methodLoopCount);
                    hexagon(defaultCount, defaultInscribed);
                }
                case 78 -> {
                    System.out.format("\nPrint Case %d: Hollow Hexagon with Selected Symbol\n", methodLoopCount);
                    hexagon(defaultCount, defaultInscribed, firstSymbol);
                }
                case 79 -> {
                    System.out.format("\nPrint Case %d: Filled Hexagon with Selected Symbols\n", methodLoopCount);
                    hexagon(defaultCount, defaultInscribed, firstSymbol, secondSymbol);
                }
                default -> System.out.format("\nPrint Case %d:Invalid", methodLoopCount);
            }
        }
    }

    private static void diamond(int count, char... symbolIn) {
        diamond(count, false, symbolIn);
    }

    private static void diamond(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            if (count >= 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
            if (count > 2) {
                for (int i = 2; i <= count; i++) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbolIn));
                }
            }

            if (count > 3) {
                for (int i = 0; i < count - 2; i++) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i + 1) + inscribedLine(2 * (count - 1 - i) - 1, symbolIn));
                }
            }
            if (count >= 2) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, (2 * i) - 1)));
            }
            for (int i = 0; i < count - 1; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i + 1) + String.valueOf(symbol).repeat(Math.max(0, 2 * (count - 1 - i) - 1)));
            }

        }
    }

    private static String inscribedLine(int count, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char inscribedSymbol = symbolIn.length > 1 ? symbolIn[1] : defaultInscribedSymbol;

        StringBuilder step = new StringBuilder();

        if (count == 0) {
            return step.toString();
        } else if (count == 0) {
            return step.toString() + symbol;
        }
        step.append(symbol);

        step.append(String.valueOf(inscribedSymbol).repeat(Math.max(0, count - 2)));
        step.append(symbol);

        return step.toString();
    }

    private static void hexagon(int count, char... symbolIn) {
        hexagon(count, false, symbolIn);
    }

    private static void hexagon(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 0 ? symbolIn[1] : defaultInscribedSymbol;

        StringBuilder base = new StringBuilder();
        StringBuilder baseInner = new StringBuilder();
        StringBuilder padding = new StringBuilder();
        StringBuilder step = new StringBuilder();

        if (inscribed) {
            for (int i = 0; i < count; i++) {
                base.append(symbol);
                baseInner.append(symbol2);
            }
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding + base.toString());
            for (int i = 1; i < count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i - 1));
                step = new StringBuilder();
                step.append(String.valueOf(symbol2).repeat(i - 1));
                System.out.println(padding.toString() + symbol + step + baseInner + step + symbol);
            }
            for (int i = 1; i < count; i++) {
                System.out.println(padding.toString() + symbol + step + baseInner + step + symbol);
            }

            for (int i = 0; i < count - 2; i++) {
                step = new StringBuilder();
                step.append(String.valueOf(symbol2).repeat(Math.max(0, count - i - 3)));
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i + 1) + symbol + step + baseInner + step + symbol);
            }

            System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)) + base.toString());

        } else {
            base.append(String.valueOf(symbol).repeat(Math.max(0, count)));
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding + base.toString());
            for (int i = 1; i < count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(count - i - 1));
                step = new StringBuilder();
                step.append(String.valueOf(symbol).repeat(i));
                System.out.println(padding + step.toString() + base + step);
            }
            for (int i = 1; i < count; i++) {
                System.out.println(padding + step.toString() + base + step);
            }
            for (int i = 0; i < count - 1; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(i + 1));
                step = new StringBuilder();
                step.append(String.valueOf(symbol).repeat(Math.max(0, count - i - 2)));
                System.out.println(padding + step.toString() + base + step);
            }

        }
    }

    private static void hourglass(int count, char... symbolIn) {
        hourglass(count, false, symbolIn);
    }

    private static void hourglass(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            StringBuilder step = new StringBuilder();
            step.append(String.valueOf(symbol).repeat(Math.max(0, (2 * count) - 1)));
            System.out.println(step);
            if (count > 2) {
                for (int i = count - 1; i > 1; i--) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
            if (count > 2) {
                for (int i = 2; i <= count - 1; i++) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbolIn));
                }
            }
            if (count > 1) {
                step = new StringBuilder();
                step.append(String.valueOf(symbol).repeat(Math.max(0, (2 * count) - 1)));
                System.out.println(step);
            }

        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol).repeat(Math.max(0, 2 * (count - i) - 1)));
            }

            for (int i = 2; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, (2 * i) - 1)));
            }
        }
    }

    private static void inscribedSquare(int count, char... symbolIn) {
        inscribedSquare(count, false, symbolIn);
    }

    private static void inscribedSquare(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;

        char symbol2;
        if (inscribed) {
            symbol2 = defaultInscribedSymbol;
        } else {
            symbol2 = symbolIn.length > 1 ? symbolIn[0] : defaultSymbol2;
        }

        for (int i = 1; i <= count; i++) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(symbol).repeat(Math.max(0, count - i)));
            System.out.println(padding.toString() + String.valueOf(symbol2).repeat(Math.max(0, (2 * i) - 1)) + padding);
        }
        for (int i = 0; i < count - 1; i++) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(symbol).repeat(i + 1));
            System.out.println(padding + String.valueOf(symbol2).repeat(Math.max(0, 2 * (count - 1 - i) - 1)) + padding);
        }
    }

    private static void parallelogramPointLeft(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding.toString() + symbol);
            for (int i = 2; i <= count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)));
                System.out.println(padding + inscribedLine(i, symbolIn));
            }
            for (int i = count - 1; i > 1; i--) {
                System.out.println(inscribedLine(i, symbolIn));
            }
            System.out.println(symbol);
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, i)));
            }
            for (int i = 1; i < count; i++) {
                System.out.println(String.valueOf(symbol).repeat(count - i));
            }
        }
    }

    private static void parallelogramPointLeft(int count, char... symbolIn) {
        parallelogramPointLeft(count, false, symbolIn);
    }

    private static void parallelogramPointRight(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            System.out.println(symbol);
            for (int i = 2; i <= count; i++) {
                System.out.println(inscribedLine(i, symbolIn));
            }
            StringBuilder padding = new StringBuilder();
            for (int i = count - 1; i > 1; i--) {
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)));
                System.out.println(padding + inscribedLine(i, symbolIn));
            }
            padding = new StringBuilder();
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding.toString() + symbol);
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(symbol).repeat(Math.max(0, i)));
            }
            for (int i = 1; i < count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol).repeat(count - i));
            }
        }
    }

    private static void parallelogramPointRight(int count, char... symbolIn) {
        parallelogramPointRight(count, false, symbolIn);
    }

    private static void splitSquarePointDown(int count, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;

        for (int i = 0; i < count; i++) {
            System.out.println(String.valueOf(symbol2).repeat(i) + String.valueOf(symbol).repeat(count - i));
        }
    }

    private static void splitSquarePointUp(int count, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;
        for (int i = 1; i <= count; i++) {
            System.out.println(String.valueOf(symbol2).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, i)));
        }
    }

    private static void triangleLeftJustifiedPointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            System.out.println(String.valueOf(symbol).repeat(Math.max(0, count)));
            if (count > 2) {
                for (int i = count - 1; i > 1; i--) {
                    System.out.println(inscribedLine(i, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(symbol);
            }
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(String.valueOf(symbol).repeat(count - i));
            }
        }
    }

    private static void triangleLeftJustifiedPointDown(int count, char... symbolIn) {
        triangleLeftJustifiedPointDown(count, false, symbolIn);
    }

    private static void triangleLeftJustifiedPointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            if (count > 0) {
                System.out.println(symbol);
            }
            if (count > 1) {
                for (int i = 2; i < count; i++) {
                    System.out.println(inscribedLine(i, symbolIn));
                }
            }
            if (count > 2) {
                System.out.println(String.valueOf(symbol).repeat(count));
            }
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(symbol).repeat(Math.max(0, i)));
            }
        }
    }

    private static void triangleLeftJustifiedPointUp(int count, char... symbolIn) {
        triangleLeftJustifiedPointUp(count, false, symbolIn);
    }

    private static void trianglePointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            System.out.println(String.valueOf(symbol).repeat(Math.max(0, (2 * count) - 1)));
            if (count > 2) {
                for (int i = count - 1; i > 1; i--) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol).repeat(Math.max(0, 2 * (count - i) - 1)));
            }
        }
    }

    private static void trianglePointDown(int count, char... symbolIn) {
        trianglePointDown(count, false, symbolIn);
    }

    private static void trianglePointLeft(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding.toString() + symbol);
            for (int i = 2; i <= count; i++) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)));
                System.out.println(padding + inscribedLine(i, symbolIn));
            }
            for (int i = count - 1; i > 1; i--) {
                padding = new StringBuilder();
                padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)));
                System.out.println(padding + inscribedLine(i, symbolIn));
            }
            padding = new StringBuilder();
            padding.append(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - 1)));
            System.out.println(padding.toString() + symbol);
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, i)));
            }
            for (int i = 1; i < count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol).repeat(count - i));
            }
        }
    }

    private static void trianglePointLeft(int count, char... symbolIn) {
        trianglePointLeft(count, false, symbolIn);
    }

    private static void trianglePointRight(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {

            System.out.println(symbol);
            for (int i = 2; i <= count; i++) {
                System.out.println(inscribedLine(i, symbolIn));
            }
            for (int i = count - 1; i > 1; i--) {

                System.out.println(inscribedLine(i, symbolIn));
            }

            System.out.println(symbol);
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(symbol).repeat(Math.max(0, i)));
            }
            for (int i = 1; i < count; i++) {
                System.out.println(String.valueOf(symbol).repeat(count - i));
            }
        }
    }

    private static void trianglePointRight(int count, char... symbolIn) {
        trianglePointRight(count, false, symbolIn);
    }

    private static void trianglePointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            if (count >= 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
            if (count > 2) {
                for (int i = 2; i <= count - 1; i++) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine((2 * i) - 1, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(String.valueOf(symbol).repeat(Math.max(0, (2 * count) - 1)));
            }
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, (2 * i) - 1)));
            }
        }
    }

    private static void trianglePointUp(int count, char... symbolIn) {
        trianglePointUp(count, false, symbolIn);
    }

    private static void triangleRightJustifiedPointDown(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;

        if (inscribed) {
            System.out.println(String.valueOf(symbol).repeat(Math.max(0, count)));
            if (count > 2) {
                for (int i = count - 1; i > 1; i--) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine(i, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
        } else
            for (int i = 0; i < count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(i) + String.valueOf(symbol).repeat(count - i));
            }
    }

    private static void triangleRightJustifiedPointDown(int count, char... symbolIn) {
        triangleRightJustifiedPointDown(count, false, symbolIn);
    }

    private static void triangleRightJustifiedPointUp(int count, boolean inscribed, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        if (inscribed) {
            if (count >= 1) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(count - 1) + symbol);
            }
            if (count > 2) {
                for (int i = 2; i <= count - 1; i++) {
                    System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + inscribedLine(i, symbolIn));
                }
            }
            if (count > 1) {
                System.out.println(String.valueOf(symbol).repeat(count));
            }
        } else {
            for (int i = 1; i <= count; i++) {
                System.out.println(String.valueOf(defaultInscribedSymbol).repeat(Math.max(0, count - i)) + String.valueOf(symbol).repeat(Math.max(0, i)));
            }
        }
    }

    private static void triangleRightJustifiedPointUp(int count, char... symbolIn) {
        triangleRightJustifiedPointUp(count, false, symbolIn);
    }

    private static void xSquare(int count, char... symbolIn) {
        char symbol = symbolIn.length > 0 ? symbolIn[0] : defaultSymbol1;
        char symbol2 = symbolIn.length > 1 ? symbolIn[1] : defaultSymbol2;

        for (int i = 0; i < count; i++) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(symbol2).repeat(i));
            System.out.println(padding.toString() + String.valueOf(symbol).repeat(Math.max(0, 2 * (count - i) - 1)) + padding);
        }

        for (int i = 2; i <= count; i++) {
            StringBuilder padding = new StringBuilder();
            padding.append(String.valueOf(symbol2).repeat(Math.max(0, count - i)));
            System.out.println(padding.toString() + String.valueOf(symbol).repeat(Math.max(0, (2 * i) - 1)) + padding);
        }
    }

}
