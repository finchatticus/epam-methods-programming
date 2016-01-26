package ua.kinr.monitoring.command.client;

import ua.kinr.monitoring.command.ActionCommand;
import ua.kinr.monitoring.command.LoginCommand;
import ua.kinr.monitoring.command.LogoutCommand;

public enum CommandEnum {
    LOGIN
            {
                {
                    this.command = new LoginCommand();
                }
            },
    LOGOUT
            {
                {
                    this.command = new LogoutCommand();
                }
            };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
