package edu.kh.goodWave.common.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/config.properties") // classpath == src/main/resources
public class DBConfig {

	@Autowired // (DI, 의존성 주입)
	private ApplicationContext applicationContext; // application scope 객체 : 즉, 현재 프로젝트
		// spring이 관리하는 bean 객체 중에 맞는 것을 주입 => DI
	
	//////////// HirkariCP 설정 ////////////////////////
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		
		return new HikariConfig();
	}
	
	
	@Bean
	public DataSource dataSource(HikariConfig config) { // 위에서 만든 config가 주입됨
		// 매개변수 HikariConfig config
		//  -> 등록된 Bean 중 HikariConfig 타입의 Bean 자동으로 주입
		
		DataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	
	///////////// Mybatis 설정 /////////////////////
	
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception{
		
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		
		// mapper.xml(SQL) 파일이 모이는 경로 지정
		// -> Mybatis 코드 수행 시 mapper.xml을 읽을 수 있음
		// sessionFactoryBean.setMapperLocations("현재프로젝트자원.어떤파일");
		
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**.xml"));  
																			// **.xml => .xml로 끝나는 모든 파일
		
		// 해당 패키지 내 모든 클래스의 별칭을 등록
		// - Mybatis는 특정 클래스 지정 시 패키지명.클래스명을 모두 작성해야 함
		// -> 너무 길다.. 긴 이름을 짧게 부를 별칭 설정할 수 있음
		
		// setTypeAliasesPackage("패키지") 이용 시
		// 클래스 파일명이 별칭으로 등록
		
		// ex) edu.kh.project.model.dto.Member	--> Member (별칭 등록)
		sessionFactoryBean.setTypeAliasesPackage("edu.kh.goodWave");
		
		// 마이바티스 설정 파일 경로 지정
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
		
		// 설정 내용이 모두 적용된 객체 반환
		return sessionFactoryBean.getObject();
		
	}
	
	// SqlSessionTemplate : Connection + DBCP + Mybatis + 트랜잭션 제어 처리
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
		
	return new SqlSessionTemplate(sessionFactory);
	}
	
	
	// DataSourceTransactionManager : 트랜잭션 매니저 (제어 처리)
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		
	return new DataSourceTransactionManager(dataSource);
	}
}
