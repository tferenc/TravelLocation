import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tamás Ferenc on 2017. 09. 28..
 */
public class TravelOrder {

    private List<TravelLocation> order = new ArrayList<>();

    public List<TravelLocation> getOrder() {
        return order;
    }

    public void addLocation(TravelLocation... locations) {

        List<TravelLocation> locationList = Arrays.asList(locations);

        while (locationList.size() > order.size()) {

            for (TravelLocation tl : locationList) {

                checkNotSame(tl);
                checkLoop(tl);
                buildOrder(tl);
            }
        }
    }

    private void checkNotSame(TravelLocation tl) {
        if (tl.getPrevious() != null && tl.getPrevious().equals(tl)) {
            throw new IllegalArgumentException("Wrong previous parameter. Previous is the same as the current location!");
        }
    }

    private void checkLoop(TravelLocation tl) {
        if (tl.hasLoop()) {
            throw new IllegalArgumentException("The parameters has a loop!");
        }
    }

    private void buildOrder(TravelLocation tl) {
        if (!order.contains(tl)) {
            if (tl.getPrevious() == null) {
                order.add(tl);

            } else {
                for (int i = 0; i < order.size(); i++) {
                    if (tl.getPrevious().equals(order.get(i))) {
                        order.add(i + 1, tl);
                        break;
                    }
                }
            }
        }
    }
}
