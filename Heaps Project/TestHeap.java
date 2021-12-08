
/** A TestHeap class
 * @author jcpatel and ajain5
 */
public class TestHeap extends DataHeap {
    IHeap left;
    IHeap right;
    TestHeap(int data, IHeap left, IHeap right) {
        super(data, left, right);
        this.left = left;
        this.right = right;
    }
    @Override
    public IHeap addElt(int e) {
        return new TestHeap (e, this.left, this.right);
    }
}