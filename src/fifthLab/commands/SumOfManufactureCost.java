package fifthLab.commands;

import fifthLab.CollectionManager;
import fifthLab.exceptions.InputException;
import fifthLab.parameters.Product;

import java.util.TreeSet;

public class SumOfManufactureCost implements CommandBuilder {
    public final CollectionManager manager;

    public SumOfManufactureCost(CollectionManager manager) {
        this.manager = manager;
    }


    @Override
    public Command build(String[] tokens) throws InputException {
        return () -> {
            TreeSet<Product> treeSet = new TreeSet<>(manager.elements);
            {
                int manufactureCost = 0;
                for (Product product : treeSet) {
                    manufactureCost += product.getManufactureCost();
                }System.out.println(manufactureCost);
            }
        };
    }

     @Override
            public String getDescription () {
                return "sum_of_manufacture_cost : вывести сумму значений поля manufacturer_cost для всех элементов";
            }
}


