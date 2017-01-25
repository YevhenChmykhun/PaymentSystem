package com.chmykhun.servlet;

import com.chmykhun.command.ChooseLanguageCommand;
import com.chmykhun.command.Command;
import com.chmykhun.command.NoCommand;
import com.chmykhun.command.SignInCommand;
import com.chmykhun.command.admin.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {

    private static final String COMMAND = "command";
    private static HashMap<String, Command> commands = new HashMap<>();

    static {
        // common
        commands.put("sign_in", new SignInCommand());
        commands.put("choose_language", new ChooseLanguageCommand());

        //admin
        commands.put("activate_account", new ActivateAccountCommand());
        commands.put("admin_sign_out", new AdminSignOutCommand());
        commands.put("block_account", new BlockAccountCommand());
        commands.put("get_active_accounts", new GetActiveAccountsCommand());
        commands.put("get_blocked_accounts", new GetBlockedAccountsCommand());
        commands.put("get_card_account", new GetCardAccountCommand());
        commands.put("get_payments", new GetPaymentsCommand());
        commands.put("get_user_cards", new GetUserCardsCommand());
        commands.put("get_users", new GetUsersCommand());
        commands.put("statistics", new StatisticsCommand());

        // user
    }

    public static Command getCommand(HttpServletRequest request) {
        Command command = commands.get(request.getParameter(COMMAND));
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

}
