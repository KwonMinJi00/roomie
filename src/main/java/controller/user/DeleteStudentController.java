package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Student;
import model.service.StudentManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class DeleteStudentController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(DeleteStudentController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteId = request.getParameter("userId");
		log.debug("Delete User : {}", deleteId);

		StudentManager manager = StudentManager.getInstance();
		HttpSession session = request.getSession();

		if ((UserSessionUtils.isLoginUser("admin", session) && 	// 로그인한 사용자가 관리자이고
				!deleteId.equals("admin"))							// 삭제 대상이 일반 사용자인 경우,
				|| 												// 또는
				(!UserSessionUtils.isLoginUser("admin", session) &&  // 로그인한 사용자가 관리자가 아니고
						UserSessionUtils.isLoginUser(deleteId, session))) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)

			manager.remove(deleteId);				// 사용자 정보 삭제
			if (UserSessionUtils.isLoginUser("admin", session))	// 로그인한 사용자가 관리자
				return "redirect:/student/main";		// 사용자 리스트로 이동
			else 									// 로그인한 사용자는 이미 삭제됨
				return "redirect:/student/logout";		// logout 처리
		}

		/* 삭제가 불가능한 경우 */
		Student student = manager.findStudent(deleteId);	// 사용자 정보 검색
		request.setAttribute("user", student);
		request.setAttribute("deleteFailed", true);
		String msg = (UserSessionUtils.isLoginUser("admin", session))
				? "시스템 관리자 정보는 삭제할 수 없습니다."
				: "타인의 정보는 삭제할 수 없습니다.";
		request.setAttribute("exception", new IllegalStateException(msg));
		return "/student/main.jsp";		// 사용자 보기 화면으로 이동 (forwarding)
	}
}
