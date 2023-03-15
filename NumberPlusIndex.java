public class NumberPlusIndex {
  private final int value;
  private final int index;
  
  //Constructor
  NumberPlusIndex(int v, int i) {
    value = v;
    index = i;
  }
  
  //Method to create a NumberPlusIndex array from a given int array
  static NumberPlusIndex[] createNPIArray(int[] a) {
    NumberPlusIndex[] b = new NumberPlusIndex[a.length];
    for (int i = 0; i < a.length; i++)
      b[i] = new NumberPlusIndex(a[i], i);
    return b;
  }
}
