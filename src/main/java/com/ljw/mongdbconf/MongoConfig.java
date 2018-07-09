package com.ljw.mongdbconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * 配置mongdb的ip和port
 * 
 * @author PC
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.ljw.mongdbconf") // 启用MongoDB的Repository功能
public class MongoConfig extends AbstractMongoConfiguration {

	/**
	 * 数据库名称
	 */
	private static final String mongDataBaseName = "mongdbljw";

	/**
	 * ip
	 */
	private static final String host = "localhost";
	/**
	 * port
	 */
	private static final int port = 27017;

	/**
	 * 连接指定的数据库
	 */
	@Override
	protected String getDatabaseName() {
		return MongoConfig.mongDataBaseName;
	}

	/**
	 * 创建Mongo客户端，连接服务端（连接对应数据库的host和ip）
	 * 可以在下边的MongoClientFactoryBean内进行设置，也可以在这里进行设置
	 */
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(host, port);// 默认本地

	}

	/**
	 * 连接服务端（连接对应数据库的host和ip） 并为下一个方法的Mongo 提供支持、
	 * 
	 * @return
	 */
	@Bean
	public MongoClientFactoryBean getFactory() {

		MongoClientFactoryBean mongoFactory = new MongoClientFactoryBean();
		// mongoFactory.setHost(host);
		// mongoFactory.setPort(port);
		return mongoFactory;

	}

	@Bean // 创建MongoTemplate bean;
	public MongoOperations getMongoTemplate(Mongo mongo) {

		return new MongoTemplate(mongo, MongoConfig.mongDataBaseName);

	}

}
