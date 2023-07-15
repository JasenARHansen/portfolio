package Java.test.interview.Facebook.interview.mar_25_2021;

import Java.code.interview.Facebook.interview.mar_25_2021.Question1;
import Java.code.interview.Facebook.interview.mar_25_2021.Question1.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Question1Tests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void NValues_1() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{0, 2, 1};
        boolean result = Question1.NValues(source);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertTrue(result);
    }

    @Test
    public void NValues_2() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{0, 2, 3};
        boolean result = Question1.NValues(source);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertFalse(result);
    }

    @Test
    public void NValues_2_1() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{0, 2, 1};
        int[] arr = source.clone();
        boolean result = Question1.NValues_2(arr);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertTrue(result);
    }

    @Test
    public void NValues_2_2() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{0, 2, 3};
        int[] arr = source.clone();
        boolean result = Question1.NValues_2(arr);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertFalse(result);
    }

    @Test
    public void NValues_2_3() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{2, 1, 2};
        int[] arr = source.clone();
        boolean result = Question1.NValues_2(arr);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertFalse(result);
    }

    @Test
    public void NValues_3() {
        printTestHeader(name.getMethodName());
        int[] source = new int[]{2, 1, 2};
        boolean result = Question1.NValues(source);
        System.out.format(
                "\tThe array '%s' contains the numbers 0 to n-1: %s.\n",
                Arrays.toString(source), result);
        assertFalse(result);
    }

    @Test
    public void commonAncestor_1() {
        printTestHeader(name.getMethodName());
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
        Node result = Question1.commonAncestor(A, C);
        System.out.format(
                "\tThe lowest common ancestor of %s and %s in the tree starting with %s is %s.\n",
                A.data, C.data, A.data, result.data);
        assertEquals(A, result);
    }

    @Test
    public void commonAncestor_2() {
        printTestHeader(name.getMethodName());
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
        Node result = Question1.commonAncestor(H, E);
        System.out.format(
                "\tThe lowest common ancestor of %s and %s in the tree starting with %s is %s.\n",
                H.data, E.data, A.data, result.data);
        assertEquals(B, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        Question1.getDescription();
    }
}
