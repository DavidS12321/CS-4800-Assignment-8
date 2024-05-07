import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DispensingSnackStateTest {
    private VendingMachine machine;
    private StateOfVendingMachine state;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        state = new DispensingSnackState();
        machine.setState(state);
        Snack snack = new Snack("Cheetos", 2.0, 5);
        machine.addSnack(snack);
        machine.setSelectedSnack("Cheetos");
        machine.setInsertedMoney(2.1);
    }

    @Test
    public void testDispenseSnack() {
        state.dispenseSnack(machine);
        assertEquals(4, machine.getSnack("Cheetos").getQuantity());
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
        assertTrue(machine.getState() instanceof IdleState);
    }

    @Test
    public void testSelectSnackDuringDispense() {
        state.selectSnack(machine, "Doritos");
        assertEquals("Cheetos", machine.getSelectedSnack());
    }

    @Test
    public void testInsertMoneyDuringDispense() {
        state.insertMoney(machine, 1.0);
        assertEquals(2.1, machine.getInsertedMoney(), 0.001);
    }
}