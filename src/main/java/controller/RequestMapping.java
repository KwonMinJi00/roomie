package controller;

import java.util.HashMap;
import java.util.Map;

import controller.extra.AutoMatchController;
import controller.extra.ChatController;
import controller.extra.ScrapController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // ?? ??? uri?? ???? controller ????? ?????? HashMap ????
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// ?? uri?? ??????? controller ????? ???? ?? ????
        mappings.put("/", new ForwardController("/student/loginForm.jsp"));
        mappings.put("/student/login", new LoginController());
        mappings.put("/student/register/form", new RegisterController());
        mappings.put("/student/register", new RegisterController());
        mappings.put("/student/main", new ForwardController("/student/main.jsp"));
        mappings.put("/profile/update", new UpdateProfileController());
        mappings.put("/student/search", new SearchProfileController());
        mappings.put("/student/automatch", new AutoMatchController());
        mappings.put("/student/main/detail", new ViewProfileController());
        mappings.put("/scrap/view", new ScrapController());
        mappings.put("/chat/send", new ChatController());
        mappings.put("/chat/sendList", new ChatController());
        mappings.put("/chat/receiveList", new ChatController());
        

        // ????? ???? ???? ?? ????? ???? ??? ??? ????
//      mappings.put("/user/update/form", new UpdateUserFormController());
        mappings.put("/user/update/form", new UpdateProfileController());
        mappings.put("/user/update", new UpdateProfileController());
        mappings.put("/user/delete", new DeleteStudentController());

        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// ????? uri?? ??????? controller ????? ??? ???
        return mappings.get(uri);
    }
}
