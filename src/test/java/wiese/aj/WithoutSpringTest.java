package wiese.aj;

import org.junit.Assert;
import org.junit.Test;

public class WithoutSpringTest {

    @Test
    public void testName() throws Exception{
        WithoutSpring col = new WithoutSpring();
        String name = "AJ";
        String name2 = "Kobus";

        col.list(name);
        col.list(name2);

        Assert.assertEquals(name,name);
        Assert.assertEquals(name2,name2);

    }

    @Test
    public void testId() throws Exception{
        WithoutSpring col = new WithoutSpring();
        String id1 = "891122";
        String id2 = "891122";
        String id3 = "891133";

        col.set(id1);
        col.set(id2);
        col.set(id3);

        //Find the duplicates
        Assert.assertSame(id1,id2);

        //Find the uniques
        Assert.assertNotSame(id2,id3);
    }

    @Test
    public void testCountry() throws Exception{
        WithoutSpring col = new WithoutSpring();
        String key1="rsa";
        String val1="South Africa";

        String key2="usa";
        String val2="America";

        col.map(key1,val1);
        col.map(key2,val2);

        Assert.assertNotNull(val1,val2);
    }
}
