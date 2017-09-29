import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Tamás Ferenc on 2017. 09. 28..
 */
public class TravelOrderTest {

    TravelOrder travelOrder = new TravelOrder();

    @Test
    public void test1(){
        TravelLocation u = new TravelLocation("u");
        TravelLocation v = new TravelLocation("v");
        TravelLocation w = new TravelLocation("w");
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");

        List<TravelLocation> expectedList = Arrays.asList(u,x,z,w,v,y);
        y.setPrevious(v);
        x.setPrevious(u);
        w.setPrevious(z);
        v.setPrevious(w);

        travelOrder.addLocation(u,v,w,x,y,z);
        assertEquals(travelOrder.getOrder(), expectedList);

    }

    @Test

    public void test2(){
        TravelLocation x = new TravelLocation("x");
        x.setPrevious(x);

        assertThrows(IllegalArgumentException.class, ()->travelOrder.addLocation(x));
    }

    @Test

    public void test3(){

        TravelLocation x = new TravelLocation("x");


        List<TravelLocation> expectedList = Arrays.asList(x);


        travelOrder.addLocation(x);
        assertEquals(travelOrder.getOrder(), expectedList);
    }

    @Test
    public void test4(){
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");

        List<TravelLocation> expectedList = Arrays.asList(x,y,z);

        travelOrder.addLocation(x,y,z);
        assertEquals(travelOrder.getOrder(), expectedList);
    }

    @Test
    public void test5(){
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");

        List<TravelLocation> expectedList = Arrays.asList(x,z,y);

        y.setPrevious(z);

        travelOrder.addLocation(x,y,z);
        assertEquals(travelOrder.getOrder(), expectedList);
    }


    @Test
    public void test6(){
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");


        x.setPrevious(y);
        y.setPrevious(x);

        assertThrows(IllegalArgumentException.class, ()->travelOrder.addLocation(x,y));
    }

    @Test
    public void test7(){
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");


        x.setPrevious(y);
        y.setPrevious(x);

        assertThrows(IllegalArgumentException.class, ()->travelOrder.addLocation(z,x,y));
    }

    @Test
    public void test8(){
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");

        List<TravelLocation> expectedList = Arrays.asList(z,y,x);

        x.setPrevious(y);
        y.setPrevious(z);

        travelOrder.addLocation(x,y,z);
        assertEquals(travelOrder.getOrder(), expectedList);
    }

    @Test
    public void test9(){
        TravelLocation a = new TravelLocation("a");
        TravelLocation b = new TravelLocation("b");
        TravelLocation c = new TravelLocation("c");
        TravelLocation d = new TravelLocation("d");
        TravelLocation e = new TravelLocation("e");
        TravelLocation f = new TravelLocation("f");
        TravelLocation g = new TravelLocation("g");
        TravelLocation h = new TravelLocation("h");
        TravelLocation i = new TravelLocation("i");
        TravelLocation j = new TravelLocation("j");
        TravelLocation k = new TravelLocation("k");
        TravelLocation l = new TravelLocation("l");


        a.setPrevious(j);
        b.setPrevious(c);
        c.setPrevious(d);
        d.setPrevious(l);
        e.setPrevious(i);
        f.setPrevious(a);
        g.setPrevious(l);
        i.setPrevious(f);
        j.setPrevious(l);
        h.setPrevious(e);
        l.setPrevious(h);

        assertThrows(IllegalArgumentException.class, ()->travelOrder.addLocation(a,b,c,d,e,f,g,h,i,j,k,l));

    }

    @Test
    public void test10() {
        TravelLocation a = new TravelLocation("a");
        TravelLocation b = new TravelLocation("b");
        TravelLocation c = new TravelLocation("c");
        TravelLocation d = new TravelLocation("d");
        TravelLocation e = new TravelLocation("e");
        TravelLocation f = new TravelLocation("f");
        TravelLocation g = new TravelLocation("g");
        TravelLocation h = new TravelLocation("h");
        TravelLocation i = new TravelLocation("i");
        TravelLocation j = new TravelLocation("j");
        TravelLocation k = new TravelLocation("k");
        TravelLocation l = new TravelLocation("l");

        List<TravelLocation> expectedList = Arrays.asList(f, i, e, h, l, j, a, g, d, c, b, k);

        a.setPrevious(j);
        b.setPrevious(c);
        c.setPrevious(d);
        d.setPrevious(l);
        e.setPrevious(i);
        g.setPrevious(l);
        i.setPrevious(f);
        j.setPrevious(l);
        h.setPrevious(e);
        l.setPrevious(h);

        travelOrder.addLocation(a, b, c, d, e, f, g, h, i, j, k, l);
        assertEquals(expectedList, travelOrder.getOrder());
    }
}
