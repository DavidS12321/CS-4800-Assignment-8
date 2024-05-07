public interface StateOfVendingMachine {
    void insertMoney(VendingMachine machine, double amount);
    void selectSnack(VendingMachine machine, String snackName);
    void dispenseSnack(VendingMachine machine);
}