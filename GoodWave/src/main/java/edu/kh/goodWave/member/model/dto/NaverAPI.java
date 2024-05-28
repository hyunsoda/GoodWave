package edu.kh.goodWave.member.model.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@PropertySource("classpath:/config.properties")
@Component
public class NaverAPI{
	

//    @Value("${naver.client_id}")
//    private String naverClientId;
//    
//    @Value("${naver.redirect_uri}")
//    private String naverRedirectUri;
//    
//    @Value("${naver.client_secret}")
//    private String naverClientSecret;
//    
    
    
    
//    
//    public String getAccessToken(String code, String state)
//    {
//    	
//        String reqUrl = "https://nid.naver.com/oauth2.0/token";
//        RestTemplate restTemplate = new RestTemplate();
//        
//        // HttpHeader Object
//        HttpHeaders headers = new HttpHeaders();
//        
//        // HttpBody Object
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "authorization_code");
//        params.add("client_id", naverClientId);
//        params.add("client_secret", naverClientSecret);
//        params.add("code", code);
//        params.add("state", state);
//        
//        // http body params 와 http headers 를 가진 엔티티
//        HttpEntity<MultiValueMap<String, String>> naverTokenRequest = new HttpEntity<>(params, headers);
//        
//        // reqUrl로 Http 요청, POST 방식
//        ResponseEntity<String> response = restTemplate.exchange(reqUrl,
//                                                  HttpMethod.POST,
//                                                  naverTokenRequest,
//                                                  String.class);
//        
//        String responseBody = response.getBody();
//        
//        JSONObject asJsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
//        return asJsonObject.get("access_token").getAsString();
//    }
    
    
    
    
}
