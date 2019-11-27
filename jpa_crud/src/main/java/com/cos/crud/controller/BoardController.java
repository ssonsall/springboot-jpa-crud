package com.cos.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.model.User;
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.utils.Script;

@Controller
public class BoardController {

	@Autowired
	private BoardRepository mRepo;

	@PostMapping("/board/list")
	public String boardList(Model model) {
		List<Board> boards = mRepo.findAll();
		model.addAttribute("boards", boards);
		return "/board/list";
	}

	@GetMapping("/board/detail/{id}")
	public String boardDetail(@PathVariable int id, Model model) {
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board", board.get());
		return "board/detail";

	}

	@GetMapping("/board/writeForm")
	public String boardWriteForm(HttpSession session) {
		// 인터셉터 AOP 처리로 (세션확인)해야함

		// 일단은 날코딩
		User user = (User) session.getAttribute("user");
//		if (user != null) { //interceptor 처리 전엔 이렇게 하나하나 처리해줘야 함.
//			return "/board/writeForm";
//		} else {
//			return "/user/loginForm";
//		}
		
		return "board/writeForm";
	}

	@PostMapping("/board/write")
	public String boardWrite(Board board, HttpSession session) {
		// 일단은 날코딩
		User user = (User) session.getAttribute("user");
//		if (user != null) {
//			board.setUser(user);
//			mRepo.save(board);
//			return Script.href("/board/list");
//		} else {
//			return Script.href("/user/loginForm");
//		}
		board.setUser(user);
		mRepo.save(board);
		return "redirect: /board/list";
	}

	@DeleteMapping("/board/delete/{id}")
	public String boardDelete(@PathVariable int id) {
		// 원래는 session 검사해서 자기것만 수정가능해야함.
		mRepo.deleteById(id);
		return "redirect:/board/list";
	}

	@GetMapping("/board/updateForm/{id}")
	public String boardUpdateForm(@PathVariable int id, Model model) {
		// 원래는 session 검사해서 자기것만 수정가능해야함.
		Optional<Board> board = mRepo.findById(id);
		model.addAttribute("board", board.get());
		return "board/updateForm";
	}

	@PutMapping("/board/update")
	public String boardUpdate(Board board, HttpSession session) {
		// 원래는 session 검사해서 자기것만 수정가능해야함.
		User user = (User)session.getAttribute("user");
//		if(user != null) {
//			board.setUser(user);
//			mRepo.save(board);
//			return "redirect:/board/list";
//		}else {
//			return "user/loginForm";
//		}
		
		board.setUser(user);
		mRepo.save(board);
		return "redirect:/board/list";
	}

}
