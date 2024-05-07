public class CokeDispenseHandler extends SnackDispenseHandler {
    @Override
    public void handleRequest(VendingMachine machine, String snackName, double money) {
        if (snackName.equalsIgnoreCase("Coke")) {
            machine.selectSnack(snackName);
            machine.insertMoney(money);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(machine, snackName, money);
        }
    }
}