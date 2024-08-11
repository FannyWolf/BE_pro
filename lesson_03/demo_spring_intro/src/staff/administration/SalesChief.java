package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;
import staff.prodaction.Merchandiser;
import staff.prodaction.SaleManager;

public class SalesChief {
    @Autowired
    private SaleManager salesManager;
    @Autowired
    private Merchandiser merchandiser;

    public void giveOrders(){
        merchandiser.work();
        salesManager.work();
    }
}
