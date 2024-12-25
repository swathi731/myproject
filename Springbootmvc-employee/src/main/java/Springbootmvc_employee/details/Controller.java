package Springbootmvc_employee.details;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@org.springframework.stereotype.Controller
public class Controller {
	@GetMapping("/empform")
	public String getempform()
	{
		return"add-employee";
	}
	
    @PostMapping("/saveemployee")
    public String saveemployee(Employee employee)
    {
    	System.out.println(employee);
    	return "success";
    }
    
}
