package by.it_academy.notepad_project.controller;

import by.it_academy.notepad_project.dao.DaoException;
import by.it_academy.notepad_project.service.LogicException;

public class Controller {

	private final char paramDelimeter = '\n';
	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) throws DaoException, LogicException {

		String commandName;
		Command executionCommand;

		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName.toUpperCase());

		String response;
		response = executionCommand.execute(request);

		return response;
	}
}
