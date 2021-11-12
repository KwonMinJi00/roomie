package controller.extra;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Profile;
import model.service.ProfileManager;
import model.service.StudentManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScrapController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int s_id = Integer.parseInt(request.getParameter("s_id"));

        try {
             //모델에 로그인 처리를 위임
            ProfileManager manager = ProfileManager.getInstance();
            Profile profile = manager.findProfile(s_id);	// 스크랩하려는 사용자 정보 검색
            request.setAttribute("profile", profile);

            return "/scrap/view.jsp";
        } catch (Exception e) {
            return "/student/main/detail.jsp";
        }
    }

}
