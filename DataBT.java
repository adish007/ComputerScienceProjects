
/** A DataBT class
 * @author jcpatel and ajain5
 */
public class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;
    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }
    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }
    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }
    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }


    /**
     * Find root of heap
     * @return value of root
     */
    public int getData(){
        return data;
    }

    /**
     * Checks if all values and occurrences are the same before and after
     * @param myHeap a heap
     * @param myBinTree a BT
     * @param elt an element
     * @return true if all the values of the BT are the same before and after
     */
    public boolean sameValues(IBinTree myHeap, IBinTree myBinTree, int elt){
        if(elt == data){
            return (myBinTree.elementsInBT(data) == (myHeap.elementsInBT(data) + 1) &&
                    this.left.sameValues(myHeap, myBinTree, elt) &&
                    this.right.sameValues(myHeap, myBinTree, elt));
        }
        else {
            return (myBinTree.elementsInBT(data) == myHeap.elementsInBT(data) &&
                    this.left.sameValues(myHeap, myBinTree, elt) &&
                    this.right.sameValues(myHeap, myBinTree, elt));
        }
    }


    /**
     * Checks if the BT results in a heap
     * @return true if the BT results in a heap
     */
    public boolean newTreeIsAHeap2(){
        if((this.left.size() == 0 || this.data <= this.left.getData()) && (this.right.size() == 0 || this.data <= this.right.getData()) &&
                this.left.newTreeIsAHeap2() && this.right.newTreeIsAHeap2()){
            return true;
        }
        return false;
    }

    /**
     * Count how many times an element is in a BT
     * @param value element of the heap
     * @return the total count of element in the BT
     */
    public int elementsInBT(int value){
        if(this.size() == 0){
            return 0;
        }
        else if(value == data){
            return 1 + this.left.elementsInBT(value) + this.right.elementsInBT(value);
        }
        return 0 + this.left.elementsInBT(value) + this.right.elementsInBT(value);
    }

}