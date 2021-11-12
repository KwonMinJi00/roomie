package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Profile;
import model.service.ProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class UpdateProfileController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateProfileController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
    		int s_id = Integer.parseInt(request.getParameter("s_id"));

    		log.debug("UpdateForm Request : {}", s_id);
    		
    		ProfileManager manager = ProfileManager.getInstance();
			Profile profile = manager.findProfile(s_id);	// 수정하려는 사용자 정보 검색
			request.setAttribute("profile", profile);

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(s_id, session) ||
				UserSessionUtils.isLoginUser(0, session)) {  //관리자의 s_id = 0

				return "/profile/updateForm.jsp";   // 검색한 사용자 정보를 update form으로 전송
			}    
			
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/student/loginForm.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	Profile updateStudent = new Profile(
				Integer.parseInt(request.getParameter("s_id")),
				Boolean.parseBoolean(request.getParameter("activation")),
				request.getParameter("name"),
				Integer.parseInt(request.getParameter("pr_img")),
				Integer.parseInt(request.getParameter("age")),
				Integer.parseInt(request.getParameter("sleep_habit")),
				Integer.parseInt(request.getParameter("lifestyle")),
				Integer.parseInt(request.getParameter("smoking")),
				Integer.parseInt(request.getParameter("grade")),
				request.getParameter("major"),
				Integer.parseInt(request.getParameter("cleaning")),
				Integer.parseInt(request.getParameter("indoor_eating")),
				Integer.parseInt(request.getParameter("mbti")),
				Integer.parseInt(request.getParameter("sharing")),
				Integer.parseInt(request.getParameter("habitude"))
		);

    	log.debug("Update User : {}", updateStudent);

		ProfileManager manager = ProfileManager.getInstance();
		manager.update(updateStudent);
        return "redirect:/profile/view";
    }
}
