import java.util.HashMap;
import java.util.Map;


public class VendingMachine {

    private StateOfVendingMachine state;
    private Map<String, Snack> snacks = new HashMap<>();
    private double insertedMoney = 0.0;
    private String selectedSnack = null;


    public VendingMachine() {
        this.state = new IdleState();
    }

    public void addSnack(Snack snack) {
        snacks.put(snack.getName(), snack);
    }


    public Snack getSnack(String name) {
        return snacks.get(name);
    }


    public void setSelectedSnack(String snackName) {
        this.selectedSnack = snackName;
    }


    public String getSelectedSnack() {
        return selectedSnack;
    }


    public void setInsertedMoney(double money) {
        this.insertedMoney = money;
    }


    public double getInsertedMoney() {
        return insertedMoney;
    }


    public void returnMoney(double amount) {
        System.out.println("Returning $" + String.format("%.2f", amount));
        this.insertedMoney = 0;
    }


    public void setState(StateOfVendingMachine newState) {
        this.state = newState;
    }


    public StateOfVendingMachine getState() {
        return state;
    }


    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }


    public void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }


    public void dispenseSnack() {
        state.dispenseSnack(this);
    }
}