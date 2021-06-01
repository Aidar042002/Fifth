package fifthLab.commands;

import com.sun.xml.internal.bind.v2.model.core.ID;
import fifthLab.CollectionManager;
import fifthLab.exceptions.InputException;
import fifthLab.parameters.Product;

import java.util.TreeSet;

public class FilterStartsWithPartNumber implements CommandBuilder{
    public final CollectionManager manager;

    public FilterStartsWithPartNumber(CollectionManager manager) {
        this.manager = manager;
    }


    @Override
    public Command build(String[] tokens) throws InputException {
        return () -> {
            TreeSet<Product> treeSet = new TreeSet<>(manager.elements);
            {
                long partNumber = 0;
                for (Product product : treeSet) {
                    partNumber++;
                }System.out.println(partNumber);
            }
        };
    }

    @Override
    public String getDescription() {
        return "filter_starts_with_part_number : вывести part number с заданной подстроки";
    }
}
