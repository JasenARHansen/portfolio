package Java.code.ctci.source.ch_17_Hard.q17_25_Word_Rectangle;

import Java.code.ctci.source.ctciLibrary.Trie;

@SuppressWarnings({"unused", "ConstantValue"})
public class Rectangle {
    public final int length;
    /* A class that represents a rectangular array of letters. */
    /* Rectangle data. */
    public int height;
    public char[][] matrix;

    public Rectangle(int len) {
        this.length = len;
    }

    public Rectangle(int length, int height, char[][] letters) {
    /* Construct a rectangular array of letters of the specified length
    and height, and backed by the specified matrix of letters. (It is
    assumed that the length and height specified as arguments are
    consistent with the array argument's dimensions.). */
        this.height = letters.length;
        this.length = letters[0].length;
        matrix = letters;
    }

    public Rectangle append(String s) {
    /* If the length of the argument s is consistent with that of this
    Rectangle object, then return a Rectangle whose matrix is constructed by
    appending s to the underlying matrix. Otherwise, return null. The
    underlying matrix of this Rectangle object is /not/ modified. */
        if (s.length() == length) {
            char[][] temp = new char[height + 1][length];
            for (int i = 0; i < height; i++) {
                if (length >= 0) System.arraycopy(matrix[i], 0, temp[i], 0, length);
            }
            s.getChars(0, length, temp[height], 0);
            return new Rectangle(length, height + 1, temp);
        }
        return null;
    }

    public boolean isComplete(int l, int h, WordGroup groupList) {
        // Check if we have formed a complete rectangle.
        if (height == h) {
            // Check if each column is a word in the dictionary.
            for (int i = 0; i < l; i++) {
                String col = getColumn(i);
                if (!groupList.containsWord(col)) {
                    return false; // Invalid rectangle.
                }
            }
            return true; // Valid Rectangle!
        }
        return false;
    }

    public String getColumn(int i) {
        char[] column = new char[height];
        for (int j = 0; j < height; j++) {
            column[j] = getLetter(j, i);
        }
        return new String(column);
    }

    public char getLetter(int i, int j) {
        /* Return the letter present at the specified location in the array. */
        return matrix[i][j];
    }

    public boolean isPartialOK(int l, Trie trie) {
        if (height == 0) {
            return true;
        }
        for (int i = 0; i < l; i++) {
            String col = getColumn(i);
            if (!trie.contains(col)) {
                return false; // Invalid rectangle.
            }
        }
        return true;
    }

    public void print() {
        /* Print the rectangle out, row by row. */
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println(" ");
        }
    }
}
