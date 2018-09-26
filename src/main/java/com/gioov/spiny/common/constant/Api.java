package com.gioov.spiny.common.constant;

/**
 * @author godcheese
 * @date 2018-02-22
 */
public class Api extends Url {


    public static final String SYSTEM = API + Url.SYSTEM;
    public static final String USER = API + Url.USER;

    public static final String API_PATH_PATTERN = API + ALL_PATH_PATTERN;

    public class System {

        public static final String API = SYSTEM + "/api";
        public static final String API_CATEGORY = SYSTEM + "/api_category";

        public static final String VIEW_PAGE = SYSTEM + "/view_page";
        public static final String VIEW_PAGE_CATEGORY = SYSTEM + "/view_page_category";

        public static final String VIEW_PAGE_API = SYSTEM + "/view_page_api";

        public static final String VIEW_PAGE_COMPONENT_CATEGORY = SYSTEM + "/view_page_component_category";
        public static final String VIEW_PAGE_COMPONENT = SYSTEM + "/view_page_component";
        public static final String VIEW_PAGE_COMPONENT_API = SYSTEM + "/view_page_component_api";

        public static final String DICTIONARY = SYSTEM + "/dictionary";
        public static final String DICTIONARY_CATEGORY = SYSTEM + "/dictionary_category";

        public static final String EMAIL = SYSTEM + "/email";

        public static final String OPERATION_LOG = SYSTEM + "/operation_log";

    }

    public class User {

        public static final String LOGIN = USER + "/login";
        public static final String REGISTER = USER + "/register";
        public static final String LOGOUT = USER + "/logout";

        public static final String FORGOT_PASSWORD = USER + "/forgot_password";

        public static final String SEND_PASSWORD_EMAIL = USER + "/send_password_email";
        public static final String SEND_PASSWORD_SMS = USER + "/send_password_sms";

        public static final String ROLE = USER + "/role";
        public static final String ROLE_AUTHORITY = USER + "/role_authority";
        public static final String USER_ROLE = USER + "/user_role";

        public static final String VIEW_MENU = USER + "/view_menu";
        public static final String VIEW_MENU_CATEGORY = USER + "/view_menu_category";

    }


}
