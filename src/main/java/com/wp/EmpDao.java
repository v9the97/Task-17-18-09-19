package com.wp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.ModelAttribute;



public class EmpDao {

	
		
		public void saveEmployee(@ModelAttribute("info") Emp emp)
		{
			SessionFactory sf = Util.getSF();
			Session session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.save(emp);
			tr.commit();
		}

		
		public Emp deleteEmployee(@ModelAttribute("info") Emp emp)
		{
			SessionFactory sf=Util.getSF();
			Session session=sf.openSession();
			Transaction tr = session.beginTransaction();
			Emp e=session.get(Emp.class,emp.getEno());
			if(e==null)
				return null;
			session.delete(e);
			tr.commit();
			return e;
		}
		
		public Emp searchEmployee(@ModelAttribute("info") Emp emp)
		{
			SessionFactory sf=Util.getSF();
			Session session=sf.openSession();
			Emp e=session.get(Emp.class,emp.getEno());
			return e;
			
		}
		
		public Emp updateEmployee(@ModelAttribute("info") Emp emp)
		{
			SessionFactory sf=Util.getSF();
			Session session=sf.openSession();
			Emp e=session.get(Emp.class,emp.getEno());
			e.setEname(emp.getEname());
			e.setSal(emp.getSal());
			session.update(e);
			Transaction tr = session.beginTransaction();
			tr.commit();
			return e;
			
		}
		
		public List<Emp> getAllEmployees()
		{
			SessionFactory sf=Util.getSF();
			Session session=sf.openSession();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Emp.class);
			@SuppressWarnings("unchecked")
			List<Emp> emplist=cr.list();
			session.close();
			return emplist;
			
		}
	}


