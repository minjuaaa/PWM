package com.mysite.sbb.map;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MapForm {
	
	@NotEmpty(message="제목은 필수항목입니다.")
    private String latitude;	//제목칸 

    @NotEmpty(message="내용은 필수항목입니다.")
    private String longtitude;	//내용



}
