import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SnackDispenseHandlerTest {
    private VendingMachine machine;
    private CokeDispenseHandler cokeHandler;
    private SnackDispenseHandler nextHandler;

    @Before
    public void setUp() {
        machine = new VendingMachine();
        cokeHandler = new CokeDispenseHandler();
        nextHandler = new SnackDispenseHandler() {
            @Override
            public void handleRequest(VendingMachine machine, String snackName, double money) {
            }
        };

        cokeHandler.setNextHandler(nextHandler);
        machine.addSnack(new Snack("Coke", 2.49, 10));
    }

    @Test
    public void testHandleRequest_WithCoke() {
        cokeHandler.handleRequest(machine, "Coke", 2.49);
        assertEquals("Coke", machine.getSelectedSnack());
        assertTrue("Expected IdleState but found " + machine.getState().getClass().getSimpleName(),
                machine.getState() instanceof IdleState);
        assertEquals(0.0, machine.getInsertedMoney(), 0.01);
    }

    @Test
    public void testHandleRequest_WithNonCoke() {
        String nonCoke = "Pepsi";
        cokeHandler.handleRequest(machine, nonCoke, 1.00);
        assertNull(machine.getSelectedSnack());
        assertEquals(0.0, machine.getInsertedMoney(), 0.01);
    }
}