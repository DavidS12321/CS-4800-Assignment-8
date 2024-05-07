public class IdleState implements StateOfVendingMachine {

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Snack selected: " + snackName);
        machine.setSelectedSnack(snackName);
        machine.setState(new waitingForMoneyState());
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("No snack selected. Please select a snack first.");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please select a snack and insert money first.");
    }
}