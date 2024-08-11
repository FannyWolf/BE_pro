package staff.administration;

import staff.prodaction.Merchandiser;
import staff.prodaction.SaleManager;

public class SalesChief {
    private SaleManager salesManager;
    private Merchandiser merchandiser;

    public void setSalesManager(SaleManager salesManager) {
        this.salesManager = salesManager;
    }

    public void setMerchandiser(Merchandiser merchandiser) {
        this.merchandiser = merchandiser;
    }

    public void giveOrders(){
        merchandiser.work();
        salesManager.work();
    }
}
