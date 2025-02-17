package by.it_academy.notepad_project.service;

import by.it_academy.notepad_project.service.impl.*;

public class LogicProvider {
	private static final LogicProvider instance = new LogicProvider();

	private LogicProvider() {
	}

	private NotepadLogic logic = new NotepadLogicImpl();

	public NotepadLogic getNotepadLogic() {
		return logic;
	}

	public static LogicProvider getInstance() {
		return instance;
	}
}
