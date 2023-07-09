package Java.Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_26_Sparse_Similarity;
public class DocPair {
  public int doc1;
  public int doc2;
  public DocPair(int d1, int d2) {
    doc1 = d1;
    doc2 = d2;
  }

  @Override
  public int hashCode() {
    return (doc1 * 31) ^ doc2;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof DocPair p) {
      return p.doc1 == doc1 && p.doc2 == doc2;
    }
    return false;
  }
}
