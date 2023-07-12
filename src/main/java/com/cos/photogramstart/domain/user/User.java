package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.cos.photogramstart.domain.image.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA-Java Persistence API (자바로 데이터를 영구적으로 저장할 수 있는 API를 제공) 

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//번호증가 전략이 데이터베이스를 따라감
	private int id;
	
	@Column(length=100, unique=true) 
	private String username;
	@Column(nullable=false) 
	private String password;
	@Column(nullable=false) 
	private String name;
	private String website;// 웹사이트
	private String bio;//자기소개
	@Column(nullable=false) 
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; //사진
	private String role;//권한
	
	// 나는 연관관계의 주인이 아님=>테이블 칼럼 만들지마
	// User를 select 시 해당User id로 등록도힌 모든 image들 가져와
	// Lazy=User를 select시 해당 User id로 등록된 image 들 가져오지마-대신 getImages() 함수의 image들이 호출시 가져와!!
	// Eager= User를 select시 해당 User id로 등록된 image 들을 전부 join 해서 가져와
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"user"})//응답시 무한참조 막음
	private List<Image>images;//양방향 매핑
	
	private LocalDateTime createDate;
	
	@PrePersist //디비에 INSERT되기 직전에 실행
	public void creaetDate() {
		this.createDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", website="
				+ website + ", bio=" + bio + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", profileImageUrl=" + profileImageUrl + ", role=" + role + ", createDate="
				+ createDate + "]";
	}
}
