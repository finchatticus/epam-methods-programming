package ua.kinr.monitoring.command;

import ua.kinr.monitoring.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {

    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
    // уничтожение сессии
        request.getSession().invalidate();
        return page;
    }
}
