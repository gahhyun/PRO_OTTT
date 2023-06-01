package com.ottt.ottt.service.community.freecomuity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottt.ottt.dao.community.freecomuity.CommunityDao;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	CommunityDao communityDao;
	
	@Override
	public ArticleDTO select(ArticleDTO article_no) throws Exception {
		ArticleDTO articleDTO = communityDao.select(article_no);
		return articleDTO;
	}

	@Override
	public int delete(Integer article_no) throws Exception {
		communityDao.delete(article_no);
		return communityDao.delete(article_no);
	}

	@Override
	public int insert(ArticleDTO articleDTO) throws Exception {
		return communityDao.insert(articleDTO);
	}

	@Override
	public int modify(ArticleDTO articleDTO) throws Exception {
		return communityDao.update(articleDTO);
	}

	/**
	 * 페이징용 목록
	 */
	@Override
	public List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception {
		return communityDao.getArticleList(dto);
	}

	/**
	 * 총 개수
	 */
	@Override
	public int getArticleTotalCount(ArticleSearchDTO dto) throws Exception {
		return communityDao.getArticleTotalCount(dto);
	}
	
	/**
	 * 좋아요를 눌렀는지 개수 카운팅
	 */
	@Override
	public int selectLikeCount(ArticleLikeDTO articleDTO) throws Exception {
		return communityDao.selectLikeCount(articleDTO);
	}

	/**
	 * 좋아요 저장
	 */
	@Override
	public int insertLike(ArticleLikeDTO articleDTO) throws Exception {
		return communityDao.insertLike(articleDTO);
	}
	
	/**
	 * 좋아요 삭제
	 */
	@Override
	public int deleteLike(ArticleLikeDTO articleDTO) throws Exception {
		return communityDao.deleteLike(articleDTO);
	}
}
