package fifthLab.commands;

import fifthLab.CollectionManager;
import fifthLab.parameters.Product;

import java.util.Iterator;

public class MinByName implements CommandBuilder{
    private final CollectionManager manager;

    public MinByName(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public Command build(String[] tokens) {
        return () -> {
            Product minName;
            Iterator<Product> iterator = manager.elements.iterator();
            if (!iterator.hasNext()) {
                System.out.println("Нет никаких элементов в коллекции.");
                return;
            }
            minName = iterator.next();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (minName.getName() != null && minName.getName().compareTo(product.getName()) > 0)
                    minName = product;
            }
            System.out.println(minName.getInfoString());
        };
    }

    @Override
    public String getDescription() {
        return "min_by_name : вывести любой объект из коллекции, значение поля name которого является минимальным";
    }
}
