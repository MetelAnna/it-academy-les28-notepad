package by.it_academy.notepad_project.controller.impl;

import by.it_academy.notepad_project.controller.Command;

public class NoSuchCommand implements Command {

	@Override
	public String execute(String request) {
		return "Request error";
	}
}
