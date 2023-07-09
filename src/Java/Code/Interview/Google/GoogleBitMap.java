package Java.Code.Interview.Google;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

@SuppressWarnings({"SameParameterValue", "unused", "CommentedOutCode"})
public class GoogleBitMap {
  public static void main(String[] args) throws Exception {
    // https://stackoverflow.com/questions/28154236/create-a-bitmap-file-from-random-data
    // https://www.dyclassroom.com/image-processing-project/how-to-create-a-random-pixel-image-in-java
    // 0 = Black
    // 1 = White
    int[][] input = {{1, 0, 1, 1}, {0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 1}};
    // int[][] input = { { 1 } };
    int scale = 40;
    BufferedImage image = createImage(input, scale);
    JPanel jPanel = initializePanel();
    JLabel jLabel = addImage(jPanel, image);
    addExit(jPanel);
    // floodFill(false, 0, 3, scale, jLabel, image);
    // floodFill(true, 1, 1, scale, jLabel, image);
    floodFill(true, 3, 0, scale, jLabel, image);
  }

  private static BufferedImage createImage(int[][] input, int scale) {
    // 0 = Black
    // 1 = White
    int[][] data = scaleUp(input, scale);
    int width = data.length;
    int height = data[0].length;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (data[x][y] == 1) {
          int a = 255; // alpha
          int r = 255; // red
          int g = 255; // green
          int b = 255; // blue
          int p = (a << 24) | (r << 16) | (g << 8) | b; // pixel
          image.setRGB(x, y, p);
        } else {
          int p = 0; // pixel
          image.setRGB(x, y, p);
        }
      }
    }
    return image;
  }

  private static int[][] scaleUp(int[][] data, int scale) {
    int[][] scaledUp = new int[data.length * scale][data[0].length * scale];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        for (int k = 0; k < scale; k++) {
          for (int l = 0; l < scale; l++) {
            scaledUp[(i * scale) + k][(j * scale) + l] = data[i][j];
          }
        }
      }
    }
    return scaledUp;
  }

  private static void addExit(JPanel jPanel) {
    JButton exitButton = new JButton("Exit");
    exitButton.addActionListener(e -> System.exit(0));
    jPanel.add(exitButton);
  }

  private static JPanel initializePanel() {
    return new JPanel();
  }

  private static JLabel addImage(JPanel jPanel, BufferedImage image) {
    JLabel jLabel = new JLabel(new ImageIcon(image));
    jPanel.add(jLabel);
    JFrame r = new JFrame();
    r.add(jPanel);
    r.setVisible(true);
    r.setSize(r.getWidth() + image.getWidth() + 50, r.getHeight() + image.getHeight() + 50);
    return jLabel;
  }

  private static void floodFill(
      boolean color, int x, int y, int scale, JLabel jLabel, BufferedImage image) {
    /*  https://docs.google.com/document/d/1l_59pIyArA0Mr3k6dJptyoatFXZhqY9fIMV7_WsT828/edit In Flood
     * Fill, you start with a bitmap where pixels are either black or white. The user selects a
     * point on the bitmap and a color, and the program flood-fills the bitmap outward from that
     * point (up, down, left, right) until a boundary is encountered. A boundary is a cell of the
     * same color or out of range.
     */
    // (x, y) coordinate mapping array[y][x]
    // color = false : Black
    // color = true : White
    int colorValue;
    if (color) {
      colorValue = (255 << 24) | (255 << 16) | (255 << 8) | 255; // pixel
      colorValue = 16777216 + colorValue; // pixel
    } else {
      colorValue = 0; // pixel
    }
    int imageHeight = image.getHeight();
    int imageWidth = image.getWidth();
    int xScaled = x * scale;
    int yScaled = y * scale;
    if ((x < 0) || (xScaled >= imageWidth)) {
      return;
    }
    if ((y < 0) || (yScaled >= imageHeight)) {
      return;
    }
    Queue<GoogleTuple<Integer, Integer>> floodQueue = new LinkedList<>();
    //noinspection SuspiciousNameCombination
    floodQueue.add(new GoogleTuple<>(xScaled, yScaled));
    while (!floodQueue.isEmpty()) {
      GoogleTuple<Integer, Integer> current = floodQueue.remove();
      // Boundary check
      Integer newX = current.getLeftData();
      Integer newY = current.getRightData();
      int temp = image.getRGB(newX, newY);
      temp = 16777216 + temp;
      if ((temp != -1) && (temp != colorValue)) {
        image.setRGB(newX, newY, colorValue);
        // Performing look ahead to optimize data stored in queue
        if ((0 <= (newX + 1))
            && ((newX + 1) < imageWidth)
            && (0 <= (newY))
            && ((newY) < imageHeight)
            && (image.getRGB((newX + 1), (newY)) != colorValue)) {
          //noinspection SuspiciousNameCombination
          floodQueue.add(new GoogleTuple<>((newX + 1), newY));
        }
        if ((0 <= (newX - 1))
            && ((newX - 1) < imageWidth)
            && (0 <= (newY))
            && ((newY) < imageHeight)
            && (image.getRGB((newX - 1), (newY)) != colorValue)) {
          //noinspection SuspiciousNameCombination
          floodQueue.add(new GoogleTuple<>((newX - 1), newY));
        }
        if ((0 <= (newX))
            && ((newX) < imageWidth)
            && (0 <= (newY + 1))
            && ((newY + 1) < imageHeight)
            && (image.getRGB((newX), (newY + 1)) != colorValue)) {
          floodQueue.add(new GoogleTuple<>(newX, (newY + 1)));
        }
        if ((0 <= (newX))
            && ((newX) < imageWidth)
            && (0 <= (newY - 1))
            && ((newY) < imageHeight)
            && (image.getRGB((newX), (newY - 1)) != colorValue)) {
          floodQueue.add(new GoogleTuple<>(newX, (newY - 1)));
        }
      }
    }
  }

  @SuppressWarnings("ClassCanBeRecord")
  static class GoogleTuple<X extends Comparable<X>, Y extends Comparable<Y>>
      implements Comparable<GoogleTuple<X, Y>> {
    private final X leftData;
    private final Y rightData;

    public GoogleTuple(X leftData, Y rightData) {
      this.leftData = leftData;
      this.rightData = rightData;
    }

    @Override
    public int compareTo(GoogleTuple<X, Y> target) {
      int leftCompare = this.leftData.compareTo(target.leftData);
      if (leftCompare == 0) {
        return this.rightData.compareTo(target.rightData);
      }
      return leftCompare;
    }

    public X getLeftData() {
      return this.leftData;
    }

    public Y getRightData() {
      return this.rightData;
    }

    @Override
    public String toString() {
      return String.format("(%s,%s)", this.leftData.toString(), this.rightData.toString());
    }
  }
}
