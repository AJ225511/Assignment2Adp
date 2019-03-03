package wiese.aj;

import Config.AppConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithSpringTest {

    private CollectionInterface mySpring;

    @Before
    public void setUp() throws Exception {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        mySpring  = (CollectionInterface)ctx.getBean("spring");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testName() throws Exception{
        String name = "AJ";
        String name2 = "Kobus";

        mySpring.list(name);
        mySpring.list(name2);

        Assert.assertEquals(name,name);
        Assert.assertEquals(name2,name2);

    }

    @Test
    public void testId() throws Exception{
        String id1 = "891122";
        String id2 = "891122";
        String id3 = "891133";

        mySpring.set(id1);
        mySpring.set(id2);
        mySpring.set(id3);

        //Find the duplicates
        Assert.assertSame(id1,id2);

        //Find the uniques
        Assert.assertNotSame(id2,id3);
    }

    @Test
    public void testCountry() throws Exception{
        String key1="rsa";
        String val1="South Africa";

        String key2="usa";
        String val2="America";

        mySpring.map(key1,val1);
        mySpring.map(key2,val2);

        //Check if the values are not null
        Assert.assertNotNull(val1,val2);
    }
}

