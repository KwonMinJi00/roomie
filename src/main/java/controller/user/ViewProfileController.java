package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Profile;
import model.service.ProfileManager;
import model.service.StudentNotFoundException;
import model.Student;

public class ViewProfileController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/student/login";		// login form 요청으로 redirect
        }

		ProfileManager manager = ProfileManager.getInstance();
		int userId = Integer.parseInt(request.getParameter("s_id"));

    	Profile profile = null;
    	try {
			profile = manager.findProfile(userId);	// 사용자 정보 검색
		} catch (StudentNotFoundException e) {
	        return "redirect:/student/main";
		}	
		
    	request.setAttribute("profile", profile);		// 사용자 정보 저장
		return "/student/main/detail.jsp";				// 사용자 보기 화면으로 이동
    }
}
