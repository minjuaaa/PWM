package com.mysite.sbb.map;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/map")
@RequiredArgsConstructor
@Controller
public class MapController {
	
	private final MapService mapService;
	private final UserService userService;
	
	

	
	
	@GetMapping("/measure")	//새글쓰기 버튼인듯.... ㅅㅂ 이거 누르면 질문 폼 나옴 근데 이건 get방식으로 처리되는 일들
    public String measure(MapForm mapForm) {
    	//	@Valid BindingResult bindingResult, Principal principal)  { //questionCreate 메서드에 매개변수로 QuestionForm 객체를 추가. 이렇게 하면 이제 GET 방식에서도 question_form 템플릿에 QuestionForm 객체가 전달
	//	SiteUser siteUser = this.userService.getUser(principal.getName());
		// 아 씨발 근데 principal이 null인 경우도 대비해야함 ->아예 이 페이지 접근 못하게
	//	this.mapService.create(mapForm.getLatitude(), mapForm.getLongtitude(), siteUser);
		
		return "measure";
    }
    
    @PostMapping("/measure")
    public String measureCreate(@Valid MapForm mapForm, BindingResult bindingResult, Principal principal) {
    	
    
    	
    	SiteUser siteUser = this.userService.getUser(principal.getName());
		mapService.create(mapForm.getLatitude(), mapForm.getLongtitude(), siteUser);
		
		
        return "redirect:/map/endmeasure"; // 질문 저장후 질문목록으로 이동
    }
	
    
  
	
	
    
    
    @GetMapping("/endmeasure")	//새글쓰기 버튼인듯.... ㅅㅂ 이거 누르면 질문 폼 나옴 근데 이건 get방식으로 처리되는 일들
    public String endMeasureG () { //questionCreate 메서드에 매개변수로 QuestionForm 객체를 추가. 이렇게 하면 이제 GET 방식에서도 question_form 템플릿에 QuestionForm 객체가 전달
        return "end_measure";
    }
    
    
    @PostMapping("/endmeasure")	//새글쓰기 버튼인듯.... ㅅㅂ 이거 누르면 질문 폼 나옴 근데 이건 get방식으로 처리되는 일들
    public String endMeasureP () { //questionCreate 메서드에 매개변수로 QuestionForm 객체를 추가. 이렇게 하면 이제 GET 방식에서도 question_form 템플릿에 QuestionForm 객체가 전달
        return "end_measure";
    }
    
    

}
