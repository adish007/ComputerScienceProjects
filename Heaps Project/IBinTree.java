import java.lang.Math;

/** BT's both empty and with data
 * @author jcpatel and ajain5
 */
public interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();

    /**
     * Find root of heap
     * @return value of root
     */
    int getData();

    /**
     * Checks if the BT results in a heap
     * @return true if the BT results in a heap
     */
    boolean newTreeIsAHeap2();

    /**
     * Count how many times an element is in a BT
     * @param value element of the heap
     * @return the total count of element in the BT
     */
    int elementsInBT(int value);

    /**
     * Checks if all values and occurrences are the same before and after
     * @param myHeap a heap
     * @param myBinTree a BT
     * @param elt an element
     * @return true if all the values of the BT are the same before and after
     */
    public boolean sameValues(IBinTree myHeap, IBinTree myBinTree, int elt);



}
