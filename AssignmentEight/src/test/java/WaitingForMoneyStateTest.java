import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaitingForMoneyStateTest {
    private VendingMachine machine;
    private StateOfVendingMachine state;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        state = new waitingForMoneyState();
        machine.setState(state);
        machine.setSelectedSnack("Pepsi");
        machine.addSnack(new Snack("Pepsi", 1.50, 10));
    }

    @Test
    public void testInsertMoneyEnough() {
        state.insertMoney(machine, 2.0);
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
        assertTrue(machine.getState() instanceof IdleState);
    }

    @Test
    public void testInsertMoneyNotEnough() {
        state.insertMoney(machine, 1.0);
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
    }

    @Test
    public void testSelectSnack() {
        state.selectSnack(machine, "KitKat");
        assertEquals("Pepsi", machine.getSelectedSnack());
    }

    @Test
    public void testDispenseSnack() {
        state.dispenseSnack(machine);
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
    }
}