package spring_mvc;

import javax.validation.Valid;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee")
public class controller {

    @RequestMapping( "/")
    public String showFirstView() {
        return "first-view";
    }
    @RequestMapping( "/askDetails")
    public String askEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }


    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "ask-emp-details-view";
        }
        else {
            return "show-emp-details-view";}
    }
}




