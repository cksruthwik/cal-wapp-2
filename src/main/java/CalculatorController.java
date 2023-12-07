

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("operand1") double operand1,
                            @RequestParam("operand2") double operand2,
                            @RequestParam("operator") String operator,
                            Model model) {
        double result = performCalculation(operand1, operand2, operator);
        model.addAttribute("result", result);
        return "calculator";
    }

    private double performCalculation(double operand1, double operand2, String operator) {
        // Add logic to perform calculations based on the operator
        switch (operator) {
            case "addition":
                return operand1 + operand2;
            case "subtraction":
                return operand1 - operand2;
            case "multiplication":
                return operand1 * operand2;
            case "division":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    // Handle division by zero
                    return Double.POSITIVE_INFINITY; // You can customize this behavior
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
