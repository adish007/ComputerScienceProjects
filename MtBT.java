
/** An empty BT class
 * @author jcpatel and ajain5
 */
public class MtBT implements IBinTree {
    MtBT(){}
    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }
    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }
    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    /**
     * Find root of heap
     * @return value of root
     */
    public int getData() {
        return 0;
    }

    /**
     * Checks if the BT results in a heap
     * @return true if the BT results in a heap
     */
    public boolean newTreeIsAHeap2() {
        return true;
    }

    /**
     * Count how many times an element is in a BT
     * @param value element of the heap
     * @return the total count of element in the BT
     */
    public int elementsInBT(int value) {
        return 0;
    }

    /**
     * Checks if all values and occurrences are the same before and after
     * @param myHeap a heap
     * @param myBinTree a BT
     * @param elt an element
     * @return true if all the values of the BT are the same before and after
     */
    public boolean sameValues(IBinTree myHeap, IBinTree myBinTree, int elt) {
        return true;
    }


}