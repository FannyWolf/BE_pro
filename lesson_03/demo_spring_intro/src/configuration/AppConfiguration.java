package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import staff.administration.Director;
import staff.administration.ProductionChief;
import staff.administration.SalesChief;
import staff.prodaction.MachineOperator;
import staff.prodaction.Merchandiser;
import staff.prodaction.SaleManager;
import staff.prodaction.Storekeeper;


@Configuration
public class AppConfiguration {
    @Bean
    public MachineOperator machineOperator(){
        return new MachineOperator();
    }
    @Bean
    public Storekeeper storekeeper(){
        return new Storekeeper();
    }
    @Bean
    public SaleManager saleManager(){
        return new SaleManager();
    }
    @Bean
    public Merchandiser merchandiser(){
        return new Merchandiser();
    }
    @Bean
    public ProductionChief productionChief(){
        return new ProductionChief();
    }
    @Bean
    public SalesChief salesChief(){
        return new SalesChief();
    }
    @Bean
    public Director director(){
        return new Director();
    }

}
