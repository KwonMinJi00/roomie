package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.College;
import model.Student;
import model.service.CollegeManager;
import model.service.ExistingStudentException;
import model.service.StudentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class RegisterController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 등록 form 요청
			log.debug("RegisterForm Request");

			List<College> colList = CollegeManager.getInstance().findCollegeList();	// 커뮤니티 리스트 검색
			request.setAttribute("commList", colList);

			return "/student/registerForm.jsp";   // 검색한 사용자 정보를 update form으로 전송
		}

		// POST request (회원정보가 parameter로 전송됨)
		Student student = new Student (
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("password"),
				Integer.parseInt(request.getParameter("gender")),
				request.getParameter("college"));

		log.debug("Create Student : {}", student);

		try {
			StudentManager manager = StudentManager.getInstance();
			manager.create(student);
			return "redirect:/student/loginForm.jsp";

		} catch (ExistingStudentException e) {	// 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("student", student);
			return "/student/registerForm.jsp";
		}
	}
}
