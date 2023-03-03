package com.example.demo.logic;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.dao.BoardDao;

public class BoardLogic {
	private static final Logger logger = LoggerFactory.getLogger(BoardLogic.class);
	//@Autowired
	// 아래 코드는 자바 코드(내부)에서 직접 인스턴스화 하지 않음 ; 제어 역전 아님
	private BoardDao boardDao = null;
	// 직접 인스턴스화 하는 것 대신에 해야할 일이 있다 - 생서자 객체 주입법과 setter 객체 주입법
	// 생성자 객체 주입은 xml, setter 객체 주입은 자바
	// 양이 줄어드는 것은 아님 - 객체 라이프 사이클 관리 받음 ; 제어 역전 IoC
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public List<Map<String, Object>> boardList() {
		logger.info("boardList");
		List<Map<String, Object>> bList = new ArrayList<>();
		bList = boardDao.boardList();
		return bList;
	}

}