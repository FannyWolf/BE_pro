package staff;

import staff.administration.Director;
import staff.administration.ProductionChief;
import staff.administration.SalesChief;
import staff.prodaction.MachineOperator;
import staff.prodaction.Merchandiser;
import staff.prodaction.SaleManager;
import staff.prodaction.Storekeeper;

public class Main {
    public static void main(String[] args) {
        MachineOperator machineOperator = new MachineOperator();
        Storekeeper storekeeper = new Storekeeper();
        SaleManager saleManager = new SaleManager();
        Merchandiser merchandiser = new Merchandiser();

        ProductionChief productionChief = new ProductionChief();
        productionChief.setMachineOperator(machineOperator);
        productionChief.setStorekeeper(storekeeper);

        SalesChief salesChief = new SalesChief();
        salesChief.setSalesManager(saleManager);
        salesChief.setMerchandiser(merchandiser);

        Director director = new Director();
        director.setSalesChief(salesChief);
        director.setProductionChief(productionChief);

        director.manageCompany();

    }





}
