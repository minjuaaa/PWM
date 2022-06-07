package com.mysite.sbb.map;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service	//@Service 애너테이션이 붙은 클래스는 서비스로 인식
public class MapService {	
	
	//Controller -> Service -> Repository구조로 데이터를 처리
	@Autowired
    private final MapRepository mapRepository;
	
	

    public List<Map> getList() {	//질문 목록을 조회하여 리턴하는 getList 메서드
        return this.mapRepository.findAll();
    }
    
    

   
    
    public void create(String latitude, String longtitude, SiteUser author) {
        Map m = new Map();	
        m.setLatitude(latitude);
        m.setLongtitude(longtitude);
        m.setCreateDate(LocalDateTime.now());
        m.setAuthor(author);
        
        this.mapRepository.save(m);
    }
    
    
    
	/*
	 * void testJpa() { 
	 * 	Optional<Question> oq = this.questionRepository.findById(1); id 값으로 데이터 조회하기... 근데 findById의 리턴타입은 Optional임!!
	 * 	if(oq.isPresent()) { 
	 * 		Question q = oq.get();  Optional은 null 처리를 유연하게 처리하기 위해 사용하는 클래스로 위와 같이 isPresent로 null이 아닌지를 확인한 후에 get으로 실제 Question 객체 값을 얻어야 한다.
	 * 		assertEquals("sbb가 무엇인가요?", q.getSubject()); }
	 * 
	 * List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
     * Question q = qList.get(0);
     * assertEquals("sbb가 무엇인가요?", q.getSubject());
	 */
}