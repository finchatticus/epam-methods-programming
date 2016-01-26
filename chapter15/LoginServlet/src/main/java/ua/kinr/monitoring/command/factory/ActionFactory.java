package ua.kinr.monitoring.command.factory;


import ua.kinr.monitoring.command.ActionCommand;
import ua.kinr.monitoring.command.EmptyCommand;
import ua.kinr.monitoring.command.client.CommandEnum;
import ua.kinr.monitoring.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
        // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try
        {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        }
        catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
