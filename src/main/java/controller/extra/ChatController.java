package controller.extra;

import controller.Controller;
import controller.user.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 로그인 여부 확인
        if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/student/login";		// login form 요청으로 redirect
        }

        int s_id = (int)UserSessionUtils.getLoginUserId(request.getSession());
        request.setAttribute("s_id", s_id);
        return "/chat/sendList.jsp";
    }


    /*
        1. <12, 14>
        2. <1, 2>
        3. <3, 4, 5>
        4. <6, 13>

        1. /student/registerForm.jsp  (o)
        2. /student/loginForm.jsp     (o)
        3. /student/main.jsp          (o)
        4. /profile/mypage.jsp           (o)
        5. /profile/mypage/updateForm.jsp      (o)
        6. /scrap/view.jsp              (o)
        7. /chat/sendList.jsp
        8. /chat/receiveList.jsp
        9. /chat/sendForm.jsp
        10. /myroomie/view.jsp          (마지막)  (o)
        11. /profile/automatch.jsp
        12. /student/searchResult.jsp   (검색버튼누르면 뿅) (o)
        13. /student/main/detail.jsp     (o)
        14. /student/search.jsp        (main->search)   (o)
     */

}
