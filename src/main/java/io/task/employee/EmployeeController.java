package io.task.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	EmployeeDao empDao=new EmployeeDao();
	public String getHome() {
	
		return "index.jsp";
	}
   @RequestMapping("/add")
   public String save(@RequestParam("name") String name,@RequestParam("number") int num) {
	Employee e=new Employee();
	e.setName(name);
	e.setNumber(num);
	empDao.save(e);
	return "show.jsp";
   }
   @RequestMapping("/update")
   public ModelAndView update(@RequestParam("name") String id) {
	   ModelAndView mv=new ModelAndView();
	   mv.setViewName("update.jsp");
	   mv.addObject("id",id);
	   return mv;
   }
   @RequestMapping("/saveAndRedirect")
   public String show(@RequestParam("name") String name,@RequestParam("num") int number) {
	   Employee e=new Employee();
	   e.setName(name);
	   e.setNumber(number);
	   empDao.update(e);
	   return "show.jsp";
   }
   @RequestMapping("/delete")
   public String killEmployee(@RequestParam("name") String id) {
	
	   empDao.delete(id);
	   return "show.jsp";
	
   }
}
