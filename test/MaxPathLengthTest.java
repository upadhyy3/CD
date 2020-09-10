import com.couchb.Node;
import com.couchb.NodeHelper;
import com.couchb.NodeTraversal;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class MaxPathLengthTest {

    NodeHelper nodeHelper;
    NodeTraversal nodeTraversal;
    @BeforeMethod
    public void beforeMethod() {
        nodeHelper = new NodeHelper();
        nodeTraversal = new NodeTraversal();
    }
    @Test (description = "MaxLength 3")
    public void testCase01(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        nodeHelper.addChildren(a, b,c,d);
        nodeHelper.addChildren(b,d);
        nodeHelper.addChildren(c,d,e);
        nodeHelper.addChildren(c,d,e);
        nodeHelper.addChildren(d,e);
        int result = nodeTraversal.getMaximumPathLength(a);
        Assert.assertEquals(3,result);
    }

    @Test (description = "MaxLength 4")
    public void testCase02(){
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        nodeHelper.addChildren(a, b,c,d);
        nodeHelper.addChildren(b,d);
        nodeHelper.addChildren(c,d,e);
        nodeHelper.addChildren(c,d,e);
        nodeHelper.addChildren(d,e);
        nodeHelper.addChildren(e,f);
        int result = nodeTraversal.getMaximumPathLength(a);
        Assert.assertEquals(4,result);
    }

    @Test (description = "MaxLength 0")
    public void testCase03(){
        Node a = new Node();
        int result = nodeTraversal.getMaximumPathLength(a);
        Assert.assertEquals(0,result);
    }
}
