package com.mysite.sbb.coord;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.sbb.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service	//@Service 애너테이션이 붙은 클래스는 서비스로 인식
public class CoordService {

	
	
	
	@Autowired
    private final CoordRepository coordRepository;
	

    public List<Coord> getlist() {	//질문 목록을 조회하여 리턴하는 getList 메서드 
        return this.coordRepository.findAll();
    }
	
	public void create(String arrCoord, SiteUser author) {
        Coord m = new Coord();	
        m.setArrCoord(arrCoord);
        m.setCreateDate(LocalDateTime.now());
        m.setAuthor(author);
        
        this.coordRepository.save(m);
    }
    
    
	

}
