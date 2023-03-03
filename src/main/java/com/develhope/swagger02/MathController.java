package com.develhope.swagger02;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
@Tag(name = "MathController", description = "API for performing arithmetic operations")

public class MathController {

    @GetMapping("")
    @Operation(summary = "Welcome message")
    public String welcomeMathMsg() {
        return "Welcome to the MathController!";
    }

    @GetMapping("/division-info")
    @Operation(summary = "Get information about division operation")
    public ArithmeticOperation divisionInfo() {
        ArithmeticOperation division = new ArithmeticOperation();
        division.setName("Division");
        division.setMinNumberOfOperands(2);
        division.setDescription("Returns the quotient of the two operands.");
        division.setProperties(new String[] { "operand1", "operand2" });
        return division;
    }

    @GetMapping("/multiplication")
    @Operation(summary = "Perform multiplication operation")
    public int multiplication(@RequestParam int operand1, @RequestParam int operand2) {
        return operand1 * operand2;
    }

    @GetMapping("/square/{n}")
    @Operation(summary = "Calculate square of a number")
    public int square(@PathVariable int n) {
        return n * n;
    }
}

