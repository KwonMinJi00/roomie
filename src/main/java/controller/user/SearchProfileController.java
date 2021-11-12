package controller.user;

import controller.Controller;
import model.Profile;
import model.service.ProfileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SearchProfileController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(SearchProfileController.class);

    private static final int countProfilePage = 10;	// 한 화면에 출력할 사용자 수

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
        // 로그인 여부 확인
        if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/student/login";		// login 요청으로 redirect
        }

        if (request.getMethod().equals("GET")) {
            // GET request: 검색필터
            int s_id = Integer.parseInt(request.getParameter("s_id"));

            log.debug("SearchForm Request : {}", s_id);

            return "/student/searchResult.jsp";

        }

        /* POST */
        else {
            String currentpagePro = request.getParameter("currentPage");
            int currentPage = 1;
            if (currentpagePro != null && !currentpagePro.equals("")) {
                currentPage = Integer.parseInt(currentpagePro);
            }

            //지금 s_id로만 매개변수 전달하여 프로필리스트 생성, 고쳐야함 manager에 메소드 새로 생성 + DAO에 검색필터 매개변수 추가하여 메소드
            int s_id = (int)UserSessionUtils.getLoginUserId(request.getSession());
            ProfileManager manager = ProfileManager.getInstance();
            List<Profile> profileList = (List<Profile>) manager.findProfile(s_id);
//		List<Profile> profileList = manager.findProfileList(currentPage, countProfilePage);


            // profileList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
            request.setAttribute("profileList", profileList);
            request.setAttribute("s_id", s_id);

            // 사용자 리스트 화면으로 이동(forwarding)
            return "/student/searchResult.jsp";
        }
    }

}
