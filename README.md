# rpn-cli
A Simple Right Polish Notation calculator with CLI interface

## Requirements
JDK: 1.8

## Run CLI

Use `./gradlew run --console=plain` to run the application.

`q` + enter to return

## Run tests

`gradlew test` - executes the unit tests

## Implementation

`RpnCalculatorBuilder` - the core class of the application as it does calculations.
Method `addOperand` - adds operands (numbers) to the builder.
Evaluation happens immediately on call `applyOperator` method - this approach does not require additional
operators stack\queue.

Due to simplicity, error handling is not included in this applicaton. All errors are ignored and printed in the console error output.

