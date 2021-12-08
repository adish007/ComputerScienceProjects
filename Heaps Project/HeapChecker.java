/** A HeapChecker class
 * @author jcpatel and ajain5
 */
public class HeapChecker {

    /**
     * Checks if the new heap produced after adding the element is valid
     * @param hOrig the Original Heap
     * @param elt element being added
     * @param hAdded the new Heap with added element
     * @return true if the new heap added the element successfully
     */
    public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
        if (!(hAdded.newTreeIsAHeap2())) {
            return false;
        }

        if (!(hOrig.sameValues(hOrig, hAdded, elt))) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the new heap produced after removing the minimum element is valid
     * @param hOrig the Original Heap
     * @param hRemoved the new Heap with the removed minimum element
     * @return true if the new heap removed the element successfully
     */
    public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved){
        if(!(hRemoved.newTreeIsAHeap2())){
            return false;
        }

        if(!(hOrig.sameValues(hRemoved, hOrig, hOrig.getData()))){
            return false;
        }

        return true;
    }
}