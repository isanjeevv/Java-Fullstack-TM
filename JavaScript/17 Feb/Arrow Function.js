const calculate = () => {
    let operation = prompt("Choose an operation: add, subtract, multiply, divide");
    let num1 = parseFloat(prompt("Enter first number:"));
    let num2 = parseFloat(prompt("Enter second number:"));

    switch (operation) {
        case "add":
            console.log(Sum: ${num1 + num2});
            break;
        case "subtract":
            console.log(Difference: ${num1 - num2});
            break;
        case "multiply":
            console.log(Product: ${num1 * num2});
            break;
        case "divide":
            if (num2 !== 0) {
                console.log(Quotient: ${num1 / num2});
                console.log(Remainder: ${num1 % num2});
            } else {
                console.log("Division by zero is not allowed.");
            }
            break;
        default:
            console.log("Invalid operation");
    }
};

// Invoke the function
calculate();
