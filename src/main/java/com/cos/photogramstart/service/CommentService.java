package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.comment.Comment;
import com.cos.photogramstart.domain.comment.CommentRepository;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
 private final CommentRepository commentRepository;
 private final UserRepository userRepository;
 
 	@Transactional
 	public Comment 댓글쓰기(String content, int imageId, int userId) {
 		
 		//Tip (객체 생성시 id만 담아서 insert 가능)
 		// 대신  rewturn 시 image객체와 user객체는 id 값만 가지고 있는 빈 객체를 리턴
 		Image image=new Image();
 		image.setId(imageId);
 		
 		User uesr=userRepository.findById(userId).orElseThrow(()->{
 			throw new CustomApiException("유저아이디를 찾을 수 없습니다.");
 		});
 		
 		Comment comment = new Comment();
 		comment.setContent(content);
 		comment.setImage(image);
 		comment.setUser(uesr);
 		
 		
 		return commentRepository.save(comment);
 	}
 	
 	@Transactional
 	public void 댓글삭제(int id) {
 		try {
 			commentRepository.deleteById(id);
 		}
 		catch(Exception e){
 			throw new CustomApiException(e.getMessage());
 		}

 	}
}
