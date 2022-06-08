package com.mysite.sbb.coord;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;


import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CoordController {
	
	private final CoordService coordService;
	private final UserService userService;
	
	
	
	 @PostMapping("/map/endmeasure")
	    public String coordCreate(@Valid CoordForm coordForm, BindingResult bindingResult, Principal principal) {
	    	
	    
	    	
	    	SiteUser siteUser = this.userService.getUser(principal.getName());
			coordService.create(coordForm.getArrCoord(), siteUser);
			
			
	        return "redirect:/"; // 질문 저장후 질문목록으로 이동
	    }
	
	

}
