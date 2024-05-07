import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IdleStateTest {
    private VendingMachine machine;
    private StateOfVendingMachine state;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        state = new IdleState();
        machine.setState(state);
    }

    @Test
    public void testSelectSnack() {
        state.selectSnack(machine, "Coke");
        assertEquals("Coke", machine.getSelectedSnack());
        assertTrue(machine.getState() instanceof waitingForMoneyState);
    }

    @Test
    public void testInsertMoney() {
        state.insertMoney(machine, 1.0);
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
    }

    @Test
    public void testDispenseSnack() {
        state.dispenseSnack(machine);
        assertEquals(0.0, machine.getInsertedMoney(), 0.001);
    }
}