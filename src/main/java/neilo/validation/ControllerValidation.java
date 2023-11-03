package neilo.validation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerValidation {

    @ExceptionHandler(Exception.class)
    public String handleExceptions(Model model,
                                   Exception exception,
                                   BindingResult bindingResult) {
        List<String> errors = bindingResult.getAllErrors().stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        model.addAttribute("errors", errors);

        return "validationError";
    }
}
