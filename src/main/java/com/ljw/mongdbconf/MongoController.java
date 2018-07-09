package com.ljw.mongdbconf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ljw.mongdbconf.po.Student;
import com.ljw.mongdbconf.repository.StudentRepository;



/**
 *
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年8月18日下午8:49:35
 */
@RestController
public class MongoController {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping("/t")
	public List<Student> saveStu(){
		Student student =  new Student();
		
		student.setName("wangwu");
		student.setSex("man");
		mongoTemplate.save(student);
		List<Student> findAll = mongoTemplate.findAll(Student.class);
		return findAll;
	}
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/save")
	public Student saveStudent(){
		Student student =  new Student();
	
		student.setName("zhangsan");
		student.setSex("man");
		
		return studentRepository.save(student);
	}

	

	@RequestMapping("/test")
	public List<Student> find() {
		return studentRepository.findAll();
	}

	
	@RequestMapping("/find")
	public List<Student> findByUserPseudoCode(@RequestParam("name") String name) {
		return studentRepository.findByName(name);
	}

}