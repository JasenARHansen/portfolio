package Java.test.educative;

import Java.code.educative.DesignSerializeAndDeserializeBinaryTree;
import Java.code.educative.DesignSerializeAndDeserializeBinaryTree.Node;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesignSerializeAndDeserializeBinaryTreeTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        DesignSerializeAndDeserializeBinaryTree.getDescription();
    }

    @Test
    public void serialize_deserialize_1() {
        String expected = "100 50 25 null null 75 null null 200 null 350 null null";
        Node N_25 = new Node(25);
        Node N_50 = new Node(50);
        Node N_75 = new Node(75);
        Node N_100 = new Node(100);
        Node N_200 = new Node(200);
        Node N_350 = new Node(350);
        // Make tree
        N_100.left = N_50;
        N_100.right = N_200;
        N_50.left = N_25;
        N_50.right = N_75;
        N_200.right = N_350;
        printTestHeader(name.getMethodName());
        String result = DesignSerializeAndDeserializeBinaryTree.serialize(N_100);
        System.out.format("\tThe tree serialized in '%s'.\n", result);
        assertEquals(expected, result);
        Node resultNode = DesignSerializeAndDeserializeBinaryTree.deserialize(result);
        String result2 = DesignSerializeAndDeserializeBinaryTree.serialize(resultNode);
        assertEquals(expected, result2);
    }

    @Test
    public void serialize_deserialize_2() {
        String expected = "25 null null";
        Node N_25 = new Node(25);
        printTestHeader(name.getMethodName());
        String result = DesignSerializeAndDeserializeBinaryTree.serialize(N_25);
        System.out.format("\tThe tree serialized in '%s'.\n", result);
        assertEquals(expected, result);
        Node resultNode = DesignSerializeAndDeserializeBinaryTree.deserialize(result);
        String result2 = DesignSerializeAndDeserializeBinaryTree.serialize(resultNode);
        assertEquals(expected, result2);
    }
}
