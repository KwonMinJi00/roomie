package controller.user;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Profile;
import model.service.ProfileManager;

public class ListProfileController implements Controller {
	private static final int countProfilePage = 10;	// 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/student/login";		// login form 요청으로 redirect
        }

    	String currentpagePro = request.getParameter("currentPage");
		int currentPage = 1;
		if (currentpagePro != null && !currentpagePro.equals("")) {
			currentPage = Integer.parseInt(currentpagePro);
		}

		int s_id = (int)UserSessionUtils.getLoginUserId(request.getSession());
		ProfileManager manager = ProfileManager.getInstance();
		List<Profile> profileList = (List<Profile>) manager.findProfile(s_id);
//		List<Profile> profileList = manager.findProfileList(currentPage, countProfilePage);


		// profileList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("profileList", profileList);
		request.setAttribute("s_id", s_id);

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/student/main.jsp";
    }
}
