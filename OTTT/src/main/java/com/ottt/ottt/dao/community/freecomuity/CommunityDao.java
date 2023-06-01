package com.ottt.ottt.dao.community.freecomuity;

import java.util.List;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

public interface CommunityDao {
	
	ArticleDTO select(ArticleDTO dto) throws Exception;
	
	int insert(ArticleDTO dto) throws Exception;
	
	int delete(Integer article_no) throws Exception;
	
	int update(ArticleDTO articleDTO) throws Exception;

	List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception;
	
	int getArticleTotalCount(ArticleSearchDTO dto) throws Exception;
	
	int selectLikeCount(ArticleLikeDTO dto) throws Exception;
	
	int insertLike(ArticleLikeDTO dto) throws Exception;

	int deleteLike(ArticleLikeDTO dto) throws Exception;
	
}
