public class KitKatDispenseHandler extends SnackDispenseHandler {

    @Override
    public void handleRequest(VendingMachine machine, String snackName, double money) {
        if (snackName.equalsIgnoreCase("KitKat")) {
            machine.selectSnack(snackName);
            machine.insertMoney(money);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(machine, snackName, money);
        }
    }
}
