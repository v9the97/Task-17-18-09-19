package com.wp;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HibernateController {

	EmpDao dao=new EmpDao();
	@RequestMapping("saveinputform")
	public String showSaveEmplForm()
	{
		return "saveEmp.jsp";
	}
	
	@RequestMapping("deleteinputform")
	public String showDeleteEmplForm()
	{
		return "deleteEmp.jsp";
	}
	
	@RequestMapping("searchinputform")
	public String showSearchEmplForm()
	{
		return "searchEmp.jsp";
	}
	
	@RequestMapping("updateinputform")
	public String showUpdateEmplNoForm()
	{
		return "empNoUpdate.jsp";
	}
	
	
	@RequestMapping("showFetchedForm")
	public ModelAndView showUpdateEmpForm(@ModelAttribute("info") Emp emp) {
		
		
		Emp e=dao.searchEmployee(emp);
		ModelAndView mv = new ModelAndView("updateEmp.jsp");
		mv.addObject("e", e);
		return mv;
	}	 
	
	@RequestMapping("save")
	public ModelAndView saveEmployee(@ModelAttribute("info") Emp emp) {
		
		
		dao.saveEmployee(emp);
		ModelAndView mv = new ModelAndView("addedEmpdetails.jsp");
		return mv;
	}	 
	
	@RequestMapping("delete")
	public ModelAndView deleteEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=dao.deleteEmployee(emp);
		if(e!=null)
		{
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("deletedEmpdetails.jsp");
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("deleteEmp.jsp");
			mv.addObject("deleteErr","Cannot Delete");
			
			return mv;
		}
	}
	
	@RequestMapping("search")
	public ModelAndView searchEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=dao.searchEmployee(emp);
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("searchedEmpdetails.jsp");
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView updateEmployee(@ModelAttribute ("info") Emp emp)
	{
		Emp e=dao.updateEmployee(emp);
		emp.setEname(e.getEname());
		emp.setEno(e.getEno());
		emp.setSal(e.getSal());
		ModelAndView mv=new ModelAndView("updatedEmpdetails.jsp");
		return mv;
	}
	
	@RequestMapping("viewallEmployees")
	public ModelAndView showAllEmployees()
	{
		List<Emp> empList=dao.getAllEmployees();
		ModelAndView mv=new ModelAndView("ViewEmpDetails.jsp");
		mv.addObject("empList", empList);
		return mv;
		
	}
}
