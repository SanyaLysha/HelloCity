package Hello;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloTest {

    Hello h = new Hello();
    @Test
    @Before
    public void notNullTest()
    {
        Assert.assertNotNull("Object h not null ",h);
    }
    @Test
    public void Test1()
    {
        h.setNameCity("London");
        Assert.assertEquals("Is equals",h.getNameCity(),"London");
    }
    @Test
    public void Test2()
    {
        h.setNameTimeZone("GMT:+3:00");
        Assert.assertEquals(h.getNameTimeZone(),"GMT:+3:00");
    }
    @Test
    public void Test3()
    {
        h.setNameTimeZone("Europe/Kiev");
        Assert.assertEquals("Europe/Kiev",h.getNameTimeZone());
    }
    @Test
    public void Test4()
    {
        h=new Hello();
        Assert.assertNotNull(h.getWelcome());
    }
    @Test
    public void Test5()
    {
        h=new Hello("Partizanskoe","GMT+3:00");
        Assert.assertNotNull(h.getWelcome());

    }
    @Test
    public void Test6()
    {
        h.setNameCity("New_York");
        Assert.assertTrue(h.getWelcome().lastIndexOf("str")==0);
    }
    @Test
    public void Test7()
    {
        h=new Hello("Partizanskoe","GMT+3:00");
        Assert.assertTrue(h.getWelcome().lastIndexOf("str")==0);

    }
}

