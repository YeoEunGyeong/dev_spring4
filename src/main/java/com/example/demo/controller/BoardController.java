package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.example.demo.logic.BoardLogic;
// 왜 나는 상속 ??? 웹 서비스를 받으려면 요청이 필요(메인 메서드 대신에 URL패턴)
public class BoardController extends MultiActionController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardLogic boardLogic = null;
	// setter 객체 주입법 - 자바 코드에서 객체 주입을 처리할 때 사용
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	// void doGet(req, res) > ActionForward execute(req, res) > String execute(req, res) > String XXX(req, res)
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("boardList 호출");
		List<Map<String, Object>> bList = null;
		bList = boardLogic.boardList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardList");
		mav.addObject("bList", bList);
		return mav;
	}
}