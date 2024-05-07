public class waitingForMoneyState implements StateOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("A snack is already selected. Please insert money.");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        Snack selectedSnack = machine.getSnack(machine.getSelectedSnack());
        if (selectedSnack != null) {
            if (amount >= selectedSnack.getPrice()) {
                if (selectedSnack.getQuantity() > 0) {
                    machine.setInsertedMoney(amount);
                    machine.setState(new DispensingSnackState());
                    machine.dispenseSnack();
                } else {
                    System.out.println("Selected snack is out of stock.");
                    machine.returnMoney(amount);
                }
            } else {
                System.out.println("Insufficient money inserted. Please add more money.");
                machine.returnMoney(amount); // This should set insertedMoney to 0
            }
        }
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Waiting for sufficient money to dispense snack.");
    }
}