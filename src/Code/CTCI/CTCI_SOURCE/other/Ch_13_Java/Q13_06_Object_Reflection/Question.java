package Code.CTCI.CTCI_SOURCE.other.Ch_13_Java.Q13_06_Object_Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Question {
  public static void main(String[] args) {
    try {
      /* Parameters */
      Object[] doubleArgs = new Object[]{4.2, 3.9};

      /* Get class */
      @SuppressWarnings("rawtypes")
      Class rectangleDefinition = Class.forName("Question14_5.Rectangle");

      /* Equivalent: Rectangle rectangle = new Rectangle(4.2, 3.9); */
      @SuppressWarnings("rawtypes")
      Class[] doubleArgsClass = new Class[]{double.class, double.class};
      @SuppressWarnings({"rawtypes", "unchecked"})
      Constructor doubleArgsConstructor = rectangleDefinition.getConstructor(doubleArgsClass);
      Rectangle rectangle = (Rectangle) doubleArgsConstructor.newInstance(doubleArgs);

      /* Equivalent: Double area = rectangle.area(); */
      @SuppressWarnings("unchecked")
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
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
