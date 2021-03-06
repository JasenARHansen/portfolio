package Test.interview.Facebook.interview.Mar_25_2021;

import Code.interview.Facebook.interview.Mar_25_2021.question_1;
import Code.interview.Facebook.interview.Mar_25_2021.question_1.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class question_1_tests {

  @Rule public TestName name = new TestName();

  @Test
  public void commonAncestor_1() {
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");
    Node H = new Node("H");
    Node I = new Node("I");

    // Make tree
    A.left = B;
    A.right = C;
    B.parent = A;
    B.left = D;
    B.right = E;
    C.parent = A;
    C.left = F;
    C.right = G;
    D.parent = B;
    D.left = H;
    E.parent = B;
    F.parent = C;
    G.parent = C;
    G.left = I;
    H.parent = D;
    I.parent = G;

    Node result = question_1.commonAncestor(A, C);
    System.out.format(
        "%s: The lowest common ancestor of %s and %s in the tree starting with %s is %s.\n",
        name.getMethodName(), A.data, C.data, A.data, result.data);
    assertEquals(A, result);
  }

  @Test
  public void commonAncestor_2() {

    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");
    Node H = new Node("H");
    Node I = new Node("I");

    // Make tree
    A.left = B;
    A.right = C;
    B.parent = A;
    B.left = D;
    B.right = E;
    C.parent = A;
    C.left = F;
    C.right = G;
    D.parent = B;
    D.left = H;
    E.parent = B;
    F.parent = C;
    G.parent = C;
    G.left = I;
    H.parent = D;
    I.parent = G;

    Node result = question_1.commonAncestor(H, E);
    System.out.format(
        "%s: The lowest common ancestor of %s and %s in the tree starting with %s is %s.\n",
        name.getMethodName(), H.data, E.data, A.data, result.data);
    assertEquals(B, result);
  }

  @Test
  public void NValues_1() {
    int[] source = new int[] {0, 2, 1};
    boolean result = question_1.NValues(source);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertTrue(result);
  }

  @Test
  public void NValues_2() {
    int[] source = new int[] {0, 2, 3};
    boolean result = question_1.NValues(source);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertFalse(result);
  }

  @Test
  public void NValues_3() {
    int[] source = new int[] {2, 1, 2};
    boolean result = question_1.NValues(source);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertFalse(result);
  }

  @Test
  public void NValues_2_1() {
    int[] source = new int[] {0, 2, 1};
    int[] arr = source.clone();
    boolean result = question_1.NValues_2(arr);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertTrue(result);
  }

  @Test
  public void NValues_2_2() {
    int[] source = new int[] {0, 2, 3};
    int[] arr = source.clone();
    boolean result = question_1.NValues_2(arr);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertFalse(result);
  }

  @Test
  public void NValues_2_3() {
    int[] source = new int[] {2, 1, 2};
    int[] arr = source.clone();
    boolean result = question_1.NValues_2(arr);
    System.out.format(
        "%s: The array '%s' contains the numbers 0 to n-1: %s.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertFalse(result);
  }
}
