### 전체요약
<table>
<tr>
  <td>회원가입 </td>
  <td>심동환</td>
  <td> 
    - 요청 DTO Entity </br>
    - Password 암호화 </br>
    - 유효성 체크
  </td>
</tr>
<tr>
 <td>로그인</td> 
  <td>심동환</td> 
  <td>
    - SecurityConfig</br>
    - UesrDetailsService, UesrDetails
  </td>
  <tr>
    <td> 회원정보수정 </td>
    <td>심동환 </td>
    <td>
      - 요청 DTO, Ajax 통신</br>
      - Security tags (Session 접근)</br>
      - 유효성 체크 
    </td>
  </tr>
  <tr>
    <td>구독하기 </td> 
  <td>심동환 </td> 
  <td>
    - API. NativeQuery</br>
    - 스칼라 서브쿼리</br>
    - qlrm 라이브러리 (DTO에 return)
  </td>
 <tr>
    <td>프로필페이지</td> 
     <td>심동환</td> 
   <td>
     - 요청 DTO, MulktipartpartFIle 바이트처리 및 저장</br>
    - @Value (파일 경로 설정 파일에 저장)</br>
    - 사진변경</br>
    - 렌더링 (WebMvcConfigurer 경로저장) </td>
 <tr>
    <td>메인 페이지</td>
    <td>심동환</td>
    <td>
      - 응답 후 JPA 페이징</br>
      - JavaScript에서 스크롤 코드 진행</td>
<tr>
  <td> 좋아요</td> 
  <td>심동환</td> 
  <td>
    - Likes Entity</br>
    - 최초 페이지 요청 / 클릭/ 개수 렌더링 </td>
<tr>
    <td> 인기 페이지</td>
    <td>심동환</td>  
    <td>
      - Inner Join</br>
      - 렌더링 
</td>
  <tr>
    <td> 댓글 기능</td>
    <td> 심동환 </td>
    <td>
      - Comment Entity</br>
      - 댓글 렌더링</br>
      - 댓글 쓰기/ 삭제
</td>
<tr>
    <td> Security</td> 
    <td> 심동환</td>
    <td>
      - 기본 세팅</br>
      - 로그인 페이지 및 OAuth 연동
    </td> 
</tr>
  <tr>
    <td> AOP</td>
    <td>심동환</td> 
    <td> - @Valid Exception 공통 처리 분리</td> 
  </tr>
<tr>
    <td> OAuth</td>
    <td> 심동환</td> 
    <td>- 페이스북 OAuth</td> 
</tr>
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
