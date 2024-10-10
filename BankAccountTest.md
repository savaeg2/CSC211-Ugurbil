1. We've created a `BankAccount` class with `deposit`, `withdraw`, and `getBalance` methods. It also includes a custom `InsufficientFundsException`.
2. In the `BankAccountTest` class: a. `@BeforeEach` annotation:
    
    - The `setup()` method runs before each test.
    - It initializes a new `BankAccount` with $100 balance.
    - This ensures each test starts with a fresh account.
    
    a. `@AfterEach` annotation:
    
    - The `teardown()` method runs after each test.
    - It sets the account to null, helping with garbage collection and preventing state leakage between tests.
    
    b. Regular `@Test` methods:
    
    - `testDeposit()` and `testWithdraw()` test basic functionality.
    - `testInsufficientFunds()` tests the exception throwing.
    
    c. `@RepeatedTest` annotation:
    - `testMultipleWithdrawals()` is repeated 5 times.
    - It demonstrates how to test the same operation multiple times with different expected results.
    - `RepetitionInfo` provides information about the current repetition.
3. The `@RepeatedTest` is particularly useful here because:
    - It allows us to test multiple withdrawals without writing separate test methods.
    - We can verify the balance after each withdrawal, ensuring the method works correctly over multiple operations.
    - It helps catch issues that might only appear after multiple operations (e.g., rounding errors in financial calculations).
4. The `@BeforeEach` and `@AfterEach` methods:
    - Ensure a consistent starting state for each test.
    - Help isolate tests from each other by resetting the state after each test.
    - Can be used for setting up and tearing down resources (like database connections in more complex scenarios).

This example demonstrates how to use JUnit's lifecycle annotations to manage test setup and teardown, as well as how to use repeated tests for scenarios where an operation needs to be tested multiple times with varying results.