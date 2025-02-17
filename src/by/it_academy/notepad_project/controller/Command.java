package by.it_academy.notepad_project.controller;

import by.it_academy.notepad_project.dao.DaoException;
import by.it_academy.notepad_project.service.LogicException;

public interface Command {
	String execute(String request) throws DaoException, LogicException;
}
