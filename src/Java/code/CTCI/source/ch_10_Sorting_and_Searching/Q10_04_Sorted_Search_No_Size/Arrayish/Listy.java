package Java.code.ctci.source.ch_10_Sorting_and_Searching.q10_04_Sorted_Search_No_Size.arrayish;

@SuppressWarnings("SpellCheckingInspection")
public class Listy {
  final int[] array;

  public Listy(int[] arr) {
    array = arr.clone();
  }

  public int elementAt(int index) {
    if (index >= array.length) {
      return -1;
    }
    return array[index];
  }
}
