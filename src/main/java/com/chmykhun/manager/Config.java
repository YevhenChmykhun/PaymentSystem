package com.chmykhun.manager;

import java.util.ResourceBundle;

public class Config {

    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "config";

    public static final String ADMIN_ACCOUNT_PAGE = "page.admin.account";
    public static final String ADMIN_ACTIVE_ACCOUNTS_PAGE = "page.admin.active_accounts";
    public static final String ADMIN_BLOCKED_ACCOUNTS_PAGE = "page.admin.blocked_accounts";
    public static final String ADMIN_CARDS_PAGE = "page.admin.cards";
    public static final String ADMIN_ERROR_PAGE = "page.admin.error";
    public static final String ADMIN_MAIN_PAGE = "page.admin.main";
    public static final String ADMIN_PAYMENTS_PAGE = "page.admin.payments";
    public static final String ADMIN_USERS_PAGE = "page.admin.users";

    public static final String EXCHANGE_SOURCE = "exchange_source";
    public static final String SIGN_IN_PAGE = "page.index";

    public static final String USER_ERROR_PAGE = "page.user.error";
    public static final String USER_MAIN_PAGE = "page.user.main";

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return resource.getString(key);
    }

}
