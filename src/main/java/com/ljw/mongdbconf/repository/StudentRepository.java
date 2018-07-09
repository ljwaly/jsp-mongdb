package com.ljw.mongdbconf.repository;


import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ljw.mongdbconf.po.Student;


/**
 * 
 * 
 * 
 * 
 * 继承自MongoRepository接口，MongoRepository接口包含了常用的CRUD操作，
 * 例如：save、insert、findall等等。我们可以定义自己的查找接口，
 * 例如根据demoInfo的name搜索，具体的DemoInfoRepository接口代码如下：
 * @author gengxiaojie
 * 
 * MongoRepository会自动转化对象，复杂对象时造成内存泄漏，禁止使用，推荐使用MongoTemplate
 * 
 *
 * @date 2017年6月26日
 */
public interface StudentRepository  extends MongoRepository<Student, ObjectId>{
	List<Student> findByName(String name);
}
