package com.ottt.ottt.controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ottt.ottt.dao.login.LoginUserDao;
import com.ottt.ottt.domain.PageResolver;
import com.ottt.ottt.domain.SearchItem;
import com.ottt.ottt.dto.ArticleDTO;
import com.ottt.ottt.dto.UserDTO;
import com.ottt.ottt.service.community.QnA.QnAServiceImpl;

@Controller
@RequestMapping("/community")
public class QnAController {
	
	@Autowired
	QnAServiceImpl serviceImpl;
	@Autowired
	LoginUserDao loginUserDao;
	
	//QnA
		@GetMapping(value = "/QnA")
		public String QnA(SearchItem sc, Model m, HttpServletRequest request, HttpSession session) {
			
			try {
				UserDTO userDTO = loginUserDao.select((String) session.getAttribute("id"));
				char admin = (char) session.getAttribute("admin");
				if(admin=='Y') {
					int totalCnt = serviceImpl.getAllCount(sc);
					m.addAttribute("totalCnt", totalCnt);
					List<ArticleDTO> list = serviceImpl.getAllPage(sc);
					PageResolver pageResolver = new PageResolver(totalCnt, sc);
					m.addAttribute("list", list);
					m.addAttribute("pr", pageResolver);
				}else {
					int totalCnt = serviceImpl.getCount(sc, userDTO.getUser_no());
					m.addAttribute("totalCnt", totalCnt);
					List<ArticleDTO> list = serviceImpl.getPage(sc, userDTO.getUser_no());
					PageResolver pageResolver = new PageResolver(totalCnt, sc);
					m.addAttribute("list", list);
					m.addAttribute("pr", pageResolver);
				}	
			} catch (Exception e) {e.printStackTrace();}
			return "/community/QnA/QnA";		
		}
		
		@GetMapping("/QnA/read")
		public String read(Integer article_no, SearchItem sc, Model m, HttpSession session) {
			try {
				ArticleDTO articleDTO = serviceImpl.getArticle(article_no);
				m.addAttribute("articleDTO", articleDTO);
				
				if(session.getAttribute("id") != null) {
					UserDTO userDTO = loginUserDao.select((String) session.getAttribute("id"));
					m.addAttribute("userDTO", userDTO);			
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "redirect:/community/QnA";
			}
			return "/community/QnA/QnA board";
		}
		
		@PostMapping("/QnA/modify")
		public String modify(ArticleDTO articleDTO, RedirectAttributes rattr, Model m
			, HttpSession session, Integer page, Integer pageSize) {
			try {
				int a = serviceImpl.modify(articleDTO);
				if(a != 1) {
					throw new Exception("Modify failed");
				}
				rattr.addAttribute("page", page);
				rattr.addAttribute("pageSize", pageSize);
				rattr.addFlashAttribute("msg", "MOD_OK");
				return "redirect:/community/QnA/read?page="+page+"&pageSize="+pageSize+"&article_no="+articleDTO.getArticle_no();
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute(articleDTO);
				m.addAttribute("page", page);
				m.addAttribute("pageSize", pageSize);
				m.addAttribute("msg", "MOD_ERR");		
				return "/community/QnA/QnA board";
			}
		}
		
		@PostMapping("/QnA/remove")
		public String remove(Integer article_no, Integer page, Integer pageSize, RedirectAttributes rattr) {
			String msg = "DEL_OK";
			try {
				if(serviceImpl.remove(article_no) != 1) {
					throw new Exception("Delete failed");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg = "DEL_ERR";
			}
			
			rattr.addAttribute("page", page);
			rattr.addAttribute("pageSize", pageSize);
			rattr.addFlashAttribute("msg", msg);
			
			return "redirect:/community/QnA";
		}
		
		@GetMapping("/QnA/write")
		public String write(Model m) {
			m.addAttribute("mode", "new");
			return "/community/QnA/QnA board";
		}
		
		@PostMapping("/QnA/write")
		public String writePost(ArticleDTO articleDTO, RedirectAttributes rattr, Model m, HttpSession session) {
			String writer = (String)session.getAttribute("id");
			UserDTO userDTO = loginUserDao.select(writer);
			articleDTO.setUser_no(userDTO.getUser_no());
			try {
				if(serviceImpl.write(articleDTO) != 1) {
					throw new Exception("Write failed");
				}
				rattr.addFlashAttribute("msg", "WRT_OK");
				return "redirect:/community/QnA";
			} catch (Exception e) {
				e.printStackTrace();
				m.addAttribute("mode", "new");			//글쓰기 모드
				m.addAttribute("articleDTO", articleDTO);	//등록하려던 내용을 보여줘야함
				m.addAttribute("msg", "WRT_ERR");
				return "/community/QnA/QnA board";
			}
		}
}





























