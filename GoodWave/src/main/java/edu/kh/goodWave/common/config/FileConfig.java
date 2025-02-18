package edu.kh.goodWave.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.MultipartConfigElement;


@Configuration
@PropertySource("classpath:/config.properties")
public class FileConfig implements WebMvcConfigurer{
	
	// 파일 업로드 몇 크기가지는 메모리에 저장하다가 초과시 디스크에 저장
		@Value("${spring.servlet.multipart.file-size-threshold}")
		private long fileSizeThreshold;
		
		
		@Value("${spring.servlet.multipart.max-request-size}")
		private long maxRequestSize;
		
		@Value("${spring.servlet.multipart.max-file-size}")
		private long maxFileSize;
		
		@Value("${spring.servlet.multipart.location}")
		private String location;
		
		
		
		// board-----------------------------------
		
		@Value("${my.board.resource-handler}")
		private String boardResourceHandler;
		
		@Value("${my.board.resource-location}")
		private String boardResourceLocation;
		
		
		// 요청 주소에 따라
			// 서버 컴퓨터의 어떤 경로에 접근할지 설정
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				
				registry
				.addResourceHandler(boardResourceHandler) // 클라이언트 요청 주소 패턴
				.addResourceLocations(boardResourceLocation); 
				// 클라이언트가 /myPage/file/** 패턴으로 이미지를 요청할 때
				// 요청을 연결해서 처리해줄 서버 폴더 경로 연결
				
				// 프로필 이미지 요청 - 서버 폴더 연결 추가
	
				// /myPage/profile/**
			 // file:///C:/uploadFiles/profile/
				
				// file : ///C : 는 파일 시스템의 루트 디렉토리 
				
				// file:// 은 URL 스킴, 파일 시스템의 리소스
				// /C : 는 Windows 시스템에서 c 드라이브 를 가르킴
				
				//file:///C : 는 C드라이브 루트 디렉토리 를 의미함 최상위 경로
				
			
				
			}
		
		 
			/* MultipartResolver 설정 */
			@Bean
			public MultipartConfigElement configElement() {
				// MultipartConfigElement :
				// 파일 업로드를 처리하는데 사용되는 MultipartConfigElement를 구성하고 반환
				// 파일 업로드를 위한 구성 옵션을 설정하는데 사용
				// 업로드 파일의 최대 크기, 메모리에서의 임시 저장 경로 등을 설정 가능
				
				MultipartConfigFactory factory = new MultipartConfigFactory();
				
				factory.setFileSizeThreshold(DataSize.ofBytes(fileSizeThreshold));
				
				factory.setMaxFileSize(DataSize.ofBytes(maxFileSize));
				
				factory.setMaxRequestSize(DataSize.ofBytes(maxRequestSize));
				
				factory.setLocation(location);
				
				return factory.createMultipartConfig();
				
			}
		
		
		//MultipartResolver 객체를 Bean 으로 추가
		// -> 추가 후 위에서 만든 MultipartConfig 자동으로 이용함
		
			// MultipartResolver 객체를 Bean으로 추가
			// -> 추가 후 위에서 만든 MultipartConfig 자동으로 이용함
			@Bean
			public MultipartResolver multipartResolver() {
				// MultipartResolver : MultipartFile을 처리해주는 해결사..
				// MultipartResolver는 클라이언트로부터 받은 멀티파트 요청을 처리하고,
				// 이 중에서 업로드된 파일을 추출하여 MultipartFile 객체로 제공하는 역할
				
				
				//MultipartResolver의 자식 
				StandardServletMultipartResolver multipartResolver
					= new StandardServletMultipartResolver();
			
				return multipartResolver;
			}
	
}
