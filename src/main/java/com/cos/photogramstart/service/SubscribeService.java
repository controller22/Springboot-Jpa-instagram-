package com.cos.photogramstart.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.web.dto.subscribe.SubscribeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscribeService {

	private final SubscribeRepository subscribeRepository;
	private final EntityManager em;//Repository는 EntityManager를 구현해서 만들어져 있는 구현체
	
	@Transactional(readOnly=true)
	public List<SubscribeDto> 구독리스트(int principalid, int pageUserId) {
	
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT u.id, u.username, u.profileImageUrl, ");
		sb.append("if((SELECT true FROM Subscribe WHERE fromUserId = ? AND toUserId = u.id),1,0) subscribeState, ");
		sb.append("if((?=u.id),1,0) equalUserState ");
		sb.append("FROM user u JOIN Subscribe s ");
		sb.append("ON u.id = s.toUserId ");
		sb.append("AND s.fromUserId = ?");//세미크론 첨부하면 안됨
		
		//1.물음표 principalid
		//2. 물음표 principalid
		//3. 마지막물음표 pageUserId
		
		//쿼리완성
		Query query= em.createNativeQuery(sb.toString())
				.setParameter(1, principalid)
				.setParameter(2, principalid)
				.setParameter(3, pageUserId);
				
		//쿼리실행(qlrm 라이브러리 필요 = DTO에 DB결과를 매핑하기 위해서)
		JpaResultMapper result=new JpaResultMapper();
		List<SubscribeDto> subscribeDtos = result.list(query, SubscribeDto.class);
		
		return subscribeDtos;
	}
	
	@Transactional
	public void 구독하기(int fromUserId,int toUserId) {
		try {
			subscribeRepository.mSubscribe(fromUserId, toUserId);
			}catch (Exception e) {
				throw new CustomApiException("이미 구독을 하셨습니다.");
			}
	}
	
	@Transactional
	public void 구독취소하기(int fromUserId,int toUserId) {
		subscribeRepository.mUnSubscribe(fromUserId, toUserId);
	}

	
}
