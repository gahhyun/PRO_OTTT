package com.ottt.ottt.dao.community.freecomuity;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.ArticleLikeDTO;
import com.ottt.ottt.dto.ArticleSearchDTO;

@Repository
public class CommunityDaoImpl implements CommunityDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.ottt.ottt.dao.CommunityMapper.";
	
	@Override
	public ArticleDTO select(ArticleDTO dto) throws Exception {
		return session.selectOne(namespace + "select", dto);
	}

	@Override
	public int insert(ArticleDTO dto) throws Exception {
		return session.insert(namespace + "insert", dto);
	}


	@Override
	public int delete(Integer article_no) throws Exception {
		System.out.println("daoimpl");
		return session.delete(namespace + "delete", article_no);
	}

	@Override
	public int update(ArticleDTO articleDTO) throws Exception {
		return session.update(namespace + "update", articleDTO);
	}

	/**
	 * 페이징용 목록
	 */
	@Override
	public List<ArticleDTO> getArticleList(ArticleSearchDTO dto) throws Exception {
		return session.selectList(namespace + "getArticleList", dto);
	}
	
	@Override
	public int getArticleTotalCount(ArticleSearchDTO dto) throws Exception {
		return session.selectOne(namespace +"getArticleTotalCount", dto);
	}

	/**
	 * 좋아요를 눌렀는지 개수 카운팅
	 */
	@Override
	public int selectLikeCount(ArticleLikeDTO dto) throws Exception {
		return session.selectOne(namespace + "selectLikeCount", dto);
	}

	/**
	 * 좋아요 저장
	 */
	@Override
	public int insertLike(ArticleLikeDTO dto) throws Exception {
		return session.insert(namespace + "insertLike", dto);
	}
	
	/**
	 * 좋아요 삭제 
	 */
	@Override
	public int deleteLike(ArticleLikeDTO dto) throws Exception {
		return session.delete(namespace + "deleteLike", dto);
	}

}
