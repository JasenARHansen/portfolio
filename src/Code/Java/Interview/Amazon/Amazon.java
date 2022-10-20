package Code.Java.Interview.Amazon;

import Code.Java.unsorted.classes.classesInstance.NodeTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Amazon {

    public static NodeTree<Character> binaryExpressionTree(String input) {
        char[] inputCharacters = input.toCharArray();
        Stack<NodeTree<Character>> processStack = new Stack<>();

        // Populate process stack
        for (int i = inputCharacters.length - 1; i >= 0; i--) {
            new NodeTree<>(inputCharacters[i]);
            processStack.push(new NodeTree<>(inputCharacters[i]));
        }

        while (processStack.size() >= 3) {
            NodeTree<Character> left = processStack.pop();
            NodeTree<Character> right = processStack.pop();
            NodeTree<Character> top = processStack.pop();
            top.setLeftChild(left);
            top.setRightChild(right);
            processStack.push(top);

        }
        if (processStack.size() > 1) {
            return null;
        }
        return processStack.pop();
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        String input = "ABC";
        List<String> returnList = permute(input);
        printList(returnList);
        String expression = "AB+";
        NodeTree<Character> expressionTree = binaryExpressionTree(expression);
        expression = "AB+C*D-E/F+";
        expressionTree = binaryExpressionTree(expression);
    }

    public static List<String> permute(String base) {
        List<String> returnList = new ArrayList<>();
        permute("", base, returnList);
        return returnList;
    }

    public static void permute(String base, String remainder, List<String> returnList) {
        // Base case: Remainder empty
        if (remainder.isEmpty()) {
            returnList.add(base);
            return;
        }
        // Recursive case: Remainder not empty
        for (int i = 0; i < remainder.length(); i++) {
            permute(base + remainder.charAt(i), remainder.substring(0, i) + remainder.substring(i + 1), returnList);
        }
    }

    private static <X> void printList(List<X> returnList) {
        for (int i = 0; i < returnList.size(); i++) {
            System.out.format("Index %d: '%S'\n", i, returnList.get(i).toString());
        }

    }
}
