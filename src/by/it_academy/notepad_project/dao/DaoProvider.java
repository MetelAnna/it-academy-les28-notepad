package by.it_academy.notepad_project.dao;

import by.it_academy.notepad_project.dao.impl.FileNotepadDao;

public class DaoProvider {
	private static final DaoProvider INSTANCE = new DaoProvider();

	private DaoProvider() {
	}

	private final NotepadDao notepadDao = new FileNotepadDao();

	public NotepadDao getNotepadDao() {
		return notepadDao;
	}

	public static DaoProvider getIsntance() {
		return INSTANCE;
	}
}
