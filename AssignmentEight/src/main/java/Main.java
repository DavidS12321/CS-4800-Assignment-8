public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addSnack(new Snack("Coke", 2.49, 10));
        machine.addSnack(new Snack("Pepsi", 2.49, 10));
        machine.addSnack(new Snack("Cheetos", 1.99, 5));
        machine.addSnack(new Snack("Doritos", 1.99, 5));
        machine.addSnack(new Snack("KitKat", 0.99, 15));
        machine.addSnack(new Snack("Snickers", 0.99, 0));

        SnackDispenseHandler cokeHandler = new CokeDispenseHandler();
        SnackDispenseHandler pepsiHandler = new PepsiDispenseHandler();
        SnackDispenseHandler cheetosHandler = new CheetosDispenseHandler();
        SnackDispenseHandler doritosHandler = new DoritosDispenseHandler();
        SnackDispenseHandler kitKatHandler = new KitKatDispenseHandler();
        SnackDispenseHandler snickersHandler = new SnickersDispenseHandler();

        cokeHandler.setNextHandler(pepsiHandler);
        pepsiHandler.setNextHandler(cheetosHandler);
        cheetosHandler.setNextHandler(doritosHandler);
        doritosHandler.setNextHandler(kitKatHandler);
        kitKatHandler.setNextHandler(snickersHandler);

        cokeHandler.handleRequest(machine, "Coke", 2.49);
        pepsiHandler.handleRequest(machine, "Pepsi", 3.00);
        cheetosHandler.handleRequest(machine, "Cheetos", 2.00);
        doritosHandler.handleRequest(machine, "Doritos", 2.5);
        kitKatHandler.handleRequest(machine, "KitKat", 2.00);
        snickersHandler.handleRequest(machine, "Snickers", 1.00);
    }
}