package Java.code.ctci.source.ch_13_Java.q13_06_Object_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings({"rawtypes", "ThrowablePrintedToSystemOut", "unchecked"})
public class Question {
    public static void main(String[] args) {
        try {
            /* Parameters. */
            Object[] doubleArgs = new Object[]{4.2, 3.9};
            /* Get class. */
            Class rectangleDefinition = Class.forName("Question14_5.Rectangle");
            /* Equivalent: Rectangle rectangle = new Rectangle(4.2, 3.9). */
            Class[] doubleArgsClass = new Class[]{double.class, double.class};
            Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
            Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);
            /* Equivalent: Double area = rectangle.area(). */
            Method m = rectangleDefinition.getDeclaredMethod("area");
            Double area = (Double) m.invoke(rectangle);
            System.out.println(area);
        } catch (ClassNotFoundException
                 | InvocationTargetException
                 | IllegalArgumentException
                 | IllegalAccessException
                 | NoSuchMethodException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
