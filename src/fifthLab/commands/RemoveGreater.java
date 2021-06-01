package fifthLab.commands;

import fifthLab.CollectionManager;
import fifthLab.exceptions.EmptyFieldException;
import fifthLab.exceptions.InputException;
import fifthLab.exceptions.UncorrectFieldException;
import fifthLab.parameters.Product;

/**
 * За критерий взята стоимость
 */

public class RemoveGreater implements CommandBuilder{
    public final CollectionManager manager;

    public RemoveGreater(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public Command build(String[] tokens) throws InputException {
        if (tokens.length > 1) {
            try {
                Product product= new Product();
                long price = Long.parseLong(tokens[1]);
                long ID = Long.parseLong(tokens[1]);
                return () -> {
                    if (price <= product.getPrice() && product.getId() != ID) {
                        manager.removeElement(ID);
                        System.out.printf("Элемент (ID: %d) успешно удалён.%n", ID);
                    } else {
                        System.out.println("Нет элемента с таким price.");
                    }
                };
            } catch (NumberFormatException exception) {
                throw new UncorrectFieldException("ID");
            }
        } else {
            throw new EmptyFieldException("price");
        }
    }

    @Override
    public String getDescription() {
        return "remove_greater {element} : удалить все элементы, превосходящие заданный";
    }
}
