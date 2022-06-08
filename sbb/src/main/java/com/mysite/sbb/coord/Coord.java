package com.mysite.sbb.coord;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mysite.sbb.user.SiteUser;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Coord {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    
    
    @ManyToOne
    private SiteUser author;
    
    
    @Column(length = 1000)
    private String arrCoord;

    
    
    private LocalDateTime createDate;


    
   

}
   
