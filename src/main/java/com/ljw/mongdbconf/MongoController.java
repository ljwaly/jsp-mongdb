package com.ljw.mongdbconf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
	public List<Student> saveStu() {
		Student student = new Student();

		student.setName("wangwu");
		student.setSex("man");
		mongoTemplate.save(student);
		List<Student> findAll = mongoTemplate.findAll(Student.class);
		return findAll;
	}

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/save")
	public Student saveStudent() {
		Student student = new Student();

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

	@RequestMapping("/excel")
	public void excel(HttpServletResponse response) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("信息表");
		
		
		String fileName = "ljw" + ".xls";//设置要导出的文件的名字
		String[] headers = { "学号", "姓名", "身份类型", "登录密码" };

		List<Teacher> classmateList = new ArrayList<Teacher>();
		Teacher t1 =new Teacher("1001", "zhangxiaoyu", "410", "abc");
		Teacher t2 =new Teacher("1002", "zhangxiaoyu1", "4101", "abcd");
		Teacher t3 =new Teacher("1003", "zhangxiaoyu2", "4102", "abce");
		Teacher t4 =new Teacher("1004", "zhangxiaoyu3", "4103", "abcf");
		classmateList.add(t1);
		classmateList.add(t2);
		classmateList.add(t3);
		classmateList.add(t4);
		
		HSSFRow row = sheet.createRow(0);

		// 在excel表中添加表头
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		int rowNum = 1;
		// 在表中存放查询到的数据放入对应的列
		for (Teacher teacher : classmateList) {
			HSSFRow row1 = sheet.createRow(rowNum);
			row1.createCell(0).setCellValue(teacher.getTno());
			row1.createCell(1).setCellValue(teacher.getTname());
			row1.createCell(2).setCellValue(teacher.getType());
			row1.createCell(3).setCellValue(teacher.getTpassword());
			rowNum++;
		}

		response.setContentType("application/octet-stream");
       
		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());

	}
	
	public static void main(String[] args) {
		Field[] declaredFields = Teacher.class.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			System.out.println(declaredFields[i]);
		}
		
	}

}