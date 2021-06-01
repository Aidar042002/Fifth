package fifthLab;

import fifthLab.exceptions.ExitException;
import fifthLab.exceptions.InputException;

public class Main {
    public static void main(String[] args) {

        String str = null;

        if(args == null || args.length ==0){
            System.out.println("Файл не введен.");
        } else{
            str = args[0];
        }


        CommandManagement commandManagement = new CommandManagement(str);
        InputProvider<CommandPacking> inputProvider = new InputProvider<>("Введите команду: ", commandManagement::buildRequest);
        while (true) {
            CommandPacking commandPacking = inputProvider.provide();
            try {
                commandPacking.execute();
            } catch (ExitException exception) {
                return;
            }
        }
    }
}
