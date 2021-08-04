package com.infotech.student.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.infotech.student.dao.Studentdao;
import com.infotech.student.entities.Student;
@Service
public class StudentService implements IStudentService{

	@Autowired
	private Studentdao studentDao;
	
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}

	public Optional<Student> getClassid(Integer classid) {
		return studentDao.findById(classid);
	}

	 public ArrayList<Student> getAllStudents() {
		
		ArrayList<Student> s= new ArrayList<>();		
		for (Student student : studentDao.findAll()) {
	        if(student.getName().startsWith("a")) {
	        	s.add(student);
	        }
	     }
		return s;
	}
	
	 

	
	
	@Override
		public List<Student> findPaginated(int pageNo, int pageSize) {
			// TODO Auto-generated method stub
			
	
		// TODO Auto-generated method stub
		Pageable paging= PageRequest.of(pageNo,pageSize);
		Page<Student> pageResult=studentDao.findAll(paging);
		return pageResult.toList();
	}

	public List<Student> getStudents() {
		
	List<Student> startswitha=new ArrayList<>();
	for(Student a:(List<Student>) studentDao.findAll()) {
	String n=a.getName();
	if( n.startsWith("a") ){
		startswitha.add(a);
		
		
	}
	
	}
	return startswitha;
	
	
	
		
	}

	public ArrayList<Student> sortbyname() {
		// TODO Auto-generated method stub
		

		ArrayList<Student> s= new ArrayList<>();		
		for (Student student : studentDao.findAll()) {
	       
	        	s.add(student);
	        
	     }
		ArrayList<Student> getbyname=(ArrayList<Student>) s.stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		return getbyname;
		
		
		
		
	}

	public ArrayList<Student> sortbylocation() {
		// TODO Auto-generated method stub
		
		ArrayList<Student> s= new ArrayList<>();		
		for (Student student : studentDao.findAll()) {
	       
	        	s.add(student);
	        
	     }
		ArrayList<Student> getbylocation=(ArrayList<Student>) s.stream().sorted(Comparator.comparing(Student::getLocation))
				.collect(Collectors.toList());
		return getbylocation;
		
	}

	public ArrayList<Student> sortbyclass() {
		// TODO Auto-generated method stub
		ArrayList<Student> s= new ArrayList<>();		
		for (Student student : studentDao.findAll()) {
	       
	        	s.add(student);
	        
	     }
		ArrayList<Student> getbyclass=(ArrayList<Student>) s.stream().sorted(Comparator.comparing(Student::getClassid))
				.collect(Collectors.toList());
		return getbyclass;
		
	}
	
	
	/*sorted the students details and printed only students whose name starts with "a"*/
	public ArrayList<Student> sortbynameandfilterbyletter_a() {
		// TODO Auto-generated method stub
		

		ArrayList<Student> s= new ArrayList<>();		
		for (Student student : studentDao.findAll()) {
	       
	        	s.add(student);
	        
	     }
		ArrayList<Student> getbyname=(ArrayList<Student>) s.stream().sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		//return getbyname;
		
		
		ArrayList<Student> startswitha=new ArrayList<>();
		for(Student a:getbyname) {
			String n=a.getName();
			if( n.startsWith("a") ){
				startswitha.add(a);
				
				
			}
		
	}
		return startswitha;
	}

	

	
	
	
	

	

	


	
	
	

}
