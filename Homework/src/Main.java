
/**
 * Created by Tamás Ferenc on 2017. 09. 28..
 */
public class Main {

    public static void main(String[] args) {
        TravelLocation u = new TravelLocation("u");
        TravelLocation v = new TravelLocation("v");
        TravelLocation w = new TravelLocation("w");
        TravelLocation x = new TravelLocation("x");
        TravelLocation y = new TravelLocation("y");
        TravelLocation z = new TravelLocation("z");

        TravelOrder travelOrder = new TravelOrder();

       v.setPrevious(w);
       w.setPrevious(z);
       x.setPrevious(u);
       y.setPrevious(v);


        travelOrder.addLocation(u, v, w,x, y, z);


      for (TravelLocation t:travelOrder.getOrder()) {
            System.out.println(t.getName());
        }
    }
}
