import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(100.0); // Initialize with $100 balance
        System.out.println("Test started, account initialized with $100");
    }

    @AfterEach
    void teardown() {
        account = null;
        System.out.println("Test finished, account reset");
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should be $150 after $50 deposit");
    }

    @Test
    void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), "Balance should be $70 after $30 withdrawal");
    }

    @RepeatedTest(5)
    void testMultipleWithdrawals(RepetitionInfo repInfo) {
        double withdrawalAmount = 20.0;
        account.withdraw(withdrawalAmount);
        double expectedBalance = 100.0 - (withdrawalAmount * repInfo.getCurrentRepetition());
        assertEquals(expectedBalance, account.getBalance(), 
            String.format("Balance should be $%.2f after %d withdrawals of $%.2f", 
                expectedBalance, repInfo.getCurrentRepetition(), withdrawalAmount));
    }

    @Test
    void testInsufficientFunds() {
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(150.0), 
            "Withdrawing more than balance should throw InsufficientFundsException");
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}