### 전체요약
<table>
<tr>
  <td>회원가입 </td><td>심동환</td>|<td> 
    - 요청 DTO Entity - Password 암호화 - 유효성 체크</td>
</tr>
| --- | --- | --- |
| 로그인 | 심동환 | - SecurityConfig
- UesrDetailsService, UesrDetails |
| 회원정보수정 | 심동환 | - 요청 DTO, Ajax 통신
- Security tags (Session 접근)
- 유효성 체크 |
| 구독하기 | 심동환 | - API. NativeQuery
- 스칼라 서브쿼리
- qlrm 라이브러리 (DTO에 return)  |
| 프로필페이지 | 심동환 | - 요청 DTO, MulktipartpartFIle 바이트처리 및 저장
- @Value (파일 경로 설정 파일에 저장)
- 사진변경
- 렌더링 (WebMvcConfigurer 경로저장) |
| 메인 페이지 | 심동환 | - 응답 후 JPA 페이징
- JavaScript에서 스크롤 코드 진행 |
| 좋아요 | 심동환 | - Likes Entity
- 최초 페이지 요청 / 클릭/ 개수 렌더링 |
| 인기 페이지 | 심동환 | - Inner Join
- 렌더링 |
| 댓글 기능 | 심동환 | - Comment Entity
- 댓글 렌더링
- 댓글 쓰기/ 삭제 |
| Security | 심동환 | - 기본 세팅
- 로그인 페이지 및 OAuth 연동 |
| AOP | 심동환 | - @Valid Exception 공통 처리 분리 |
| OAuth | 심동환 | - 페이스북 OAuth |
</table>

## 기술 스택

### Back-End

- SpringBoot
- Java
- SpringBootSecurity
- Jpa
- MariaDB

## 사용 라이브러리

- spring-boot-starter-web
- spring-boot-starter-validation
- spring-boot-starter-security
- spring-boot-starter-data-jpa
- spring-boot-starter-oauth2-client
- spring-boot-starter-aop
- spring-security-taglibs
- spring-boot-devtools
- mariadb-java-client
- qlrm
- lombok

## 테이블 설계
![image (2)](https://github.com/controller22/Springboot-Jpa-instagram-/assets/122349890/fa9ef34b-a90e-49d9-83fd-fbf4aa8d8018)
