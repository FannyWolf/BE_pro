package staff.administration;

import org.springframework.beans.factory.annotation.Autowired;
import staff.prodaction.MachineOperator;
import staff.prodaction.Storekeeper;

public class ProductionChief {
    @Autowired
    private MachineOperator machineOperator;
    @Autowired
    private Storekeeper storekeeper;


    public void giveOrders(){
        machineOperator.work();
        storekeeper.work();
    }


}
