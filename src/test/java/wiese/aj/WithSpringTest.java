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

        Set idTest = new HashSet<>();
        idTest.add("881199");
        idTest.add("881199");
        idTest.add("881199");
        idTest.add("881199");
        idTest.add("881199");

        //Duplicates not allowed
        Assert.assertEquals(1, idTest.size());
    }

    @Test
    public void testCountry() throws Exception{

        Map mapTest = new HashMap();

        mapTest.put("rsa", "South Africa");
        mapTest.put("usa", "America");
        mapTest.put("aus", "Australia");

        //Test if there's 3
        Assert.assertEquals(3, mapTest.size());

        //New value
        mapTest.put("rsa", "South America");
        Assert.assertEquals("South America", mapTest.get("rsa"));

        //Remove key and check size
        mapTest.remove("rsa");
        Assert.assertEquals(2, mapTest.size());

        //Check content of map
        Assert.assertTrue(mapTest.containsKey("usa"));
        Assert.assertFalse(mapTest.containsKey("ngn"));

        Assert.assertTrue(mapTest.containsValue("America"));
        Assert.assertFalse(mapTest.containsValue("New Guinnea"));
    }
}


