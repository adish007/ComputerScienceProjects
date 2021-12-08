
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.LinkedList;

public class Examples {
    public Examples() {}

    HeapChecker HT = new HeapChecker();
    IHeap heap1 = new MtHeap();
    IHeap heap2 = new DataHeap(8, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap heap3 = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap heap3removed = new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap heap3removedkyle = new DataHeap(5, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap heap3second = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()),
    new DataHeap(5, new DataHeap(7, new MtHeap(), new MtHeap()), new DataHeap(7, new MtHeap(), new MtHeap())));
    IHeap heap4 = new DataHeap(3, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IBinTree heap4test = new DataHeap(3, new DataHeap(4, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()),
    new MtHeap()), new MtHeap()), new DataHeap(4, new MtHeap(), new MtHeap()));
    IHeap heap5 = new DataHeap(3, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap5test = new DataHeap(3, new DataHeap(4, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()),
    new MtHeap()), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap heap6 = new DataHeap(3, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap6test = new DataHeap(3, new DataHeap(4, new DataHeap(5, new DataHeap(6, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap8 = new DataHeap(3, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap8total = new DataHeap(5, new MtHeap(), new MtHeap());
    IHeap heap8test = new DataHeap(3, new DataHeap(4, new DataHeap(8, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap9 = new DataHeap(2, new DataHeap(2, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap9test = new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap heaptestredo = new DataHeap(6, new DataHeap(4, new DataHeap(5, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap10 = new DataHeap(1, new DataHeap(2, new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap()), new MtHeap());
    IHeap heap10test = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap());

    @Test
    public void test1(){ // test on empty heap
        assertTrue(HT.addEltTester(heap1 ,5, heap1.addElt(5)));
    }

    @Test
    public void test2(){ // test should pass - valid heap
        assertTrue(HT.addEltTester(heap6, 6, heap6test));
    }

    @Test
    public void test3(){ // test should fail - result isn't a heap
        assertFalse(HT.addEltTester(heap9test, 6, heaptestredo));
    }

    @Test
    public void test4(){ // test should fail - add elt occurs wrong number of times
        assertFalse(HT.addEltTester(heap4, 4, heap4test));
    }

    @Test
    public void test5(){ // test should fail - other elts occur wrong number of times
        assertFalse(HT.addEltTester(heap5, 4, heap5test));
    }

    @Test
    public void test6(){ // test should fail - total number of elements is incorrect
        assertFalse(HT.addEltTester(heap8, 8, heap8test));
    }

    @Test
    public void test7(){ // test on empty heap
        assertTrue(HT.remMinEltTester(new MtHeap(), new MtHeap()));
    }

    @Test
    public void test8(){ //  test should pass - valid heap
        assertTrue(HT.remMinEltTester(heap3, heap3removed));
    }
    @Test
    public void test8v2(){ // test should pass - valid heap
        assertTrue(HT.remMinEltTester(heap3, heap3.remMinElt()));
    }

    @Test
    public void test9(){ //test should fail - result isn't a heap
        assertFalse(HT.remMinEltTester(heap3, heap3removedkyle));
    }

    @Test
    public void test10(){ //test should fail - remove elt occurs wrong number of times
        assertFalse(HT.remMinEltTester(heap9, heap9test));
    }

    @Test
    public void test11(){ //test should fail - other elts occur wrong number of times
        assertFalse(HT.remMinEltTester(heap8, heap8total));
    }

    @Test
    public void test12(){ //test should fail - total number of elements is incorrect
        assertFalse(HT.remMinEltTester(heap10, heap10test));
    }
}
