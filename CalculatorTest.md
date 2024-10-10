1. We start by importing the necessary JUnit classes:
    - `org.junit.jupiter.api.Test`: This annotation is used to mark test methods.
    - `org.junit.jupiter.api.Assertions.*`: This static import allows us to use assertion methods directly.
2. We define a `CalculatorTest` class that will contain our test methods.
3. The `testAddition` method:
    - It's annotated with `@Test`, indicating it's a test method.
    - We create a new `Calculator` object.
    - We use `assertEquals` to check if `calculator.add(2, 3)` returns 5.
    - The third argument in `assertEquals` is an optional message that will be displayed if the test fails.
4. The `testDivision` method:
    - It tests two scenarios for the division operation.
    - First, it checks if `calculator.divide(6, 3)` returns 2.
    - Then, it uses `assertThrows` to check if dividing by zero throws an `ArithmeticException`.
5. Finally, we have a simple `Calculator` class with `add` and `divide` methods to demonstrate what we're testing.

This example showcases a few important concepts in unit testing:

- Testing normal operations (addition and division)
- Testing edge cases (division by zero)
- Using different types of assertions (`assertEquals` and `assertThrows`)
- Providing meaningful error messages for failed tests

