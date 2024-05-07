public class DispensingSnackState implements StateOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Currently dispensing another snack, please wait.");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Dispensing snack, please wait.");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        Snack selectedSnack = machine.getSnack(machine.getSelectedSnack());
        if (selectedSnack != null && selectedSnack.getQuantity() > 0) {
            double change = machine.getInsertedMoney() - selectedSnack.getPrice();
            if (change >= 0) {
                selectedSnack.setQuantity(selectedSnack.getQuantity() - 1);
                System.out.println("Dispensing: " + selectedSnack.getName());
                if (change > 0) {
                    machine.returnMoney(change);
                } else {
                    machine.setInsertedMoney(0); // Explicitly setting to zero if there's no change.
                }
                machine.setState(new IdleState());
            } else {
                System.out.println("Insufficient funds.");
                machine.returnMoney(machine.getInsertedMoney()); // Return all money if insufficient funds
                machine.setState(new IdleState());
            }
        } else {
            System.out.println("Error: Snack out of stock or insufficient funds.");
            machine.returnMoney(machine.getInsertedMoney());
            machine.setState(new IdleState());
        }
    }

}