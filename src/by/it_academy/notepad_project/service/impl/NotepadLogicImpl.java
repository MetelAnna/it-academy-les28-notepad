package by.it_academy.notepad_project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.it_academy.notepad_project.dao.DaoException;
import by.it_academy.notepad_project.dao.DaoProvider;
import by.it_academy.notepad_project.dao.NotepadDao;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.NotepadLogic;
import by.it_academy.notepad_project.util.Validation;

public class NotepadLogicImpl implements NotepadLogic {

	private final DaoProvider provider = DaoProvider.getIsntance();
	private final NotepadDao notepadDao = provider.getNotepadDao();

	public void add(Note note) throws LogicException {
		try {
			notepadDao.save(note);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public void add(String title, String content) throws LogicException {
		if (!Validation.isTitleValid(title)) {
			throw new LogicException("Wrong title format.");
		}
		if (!Validation.isContentValid(content)) {
			throw new LogicException("Wrong content format.");
		}
	}

	public List<Note> findNotesByContent(String text) throws LogicException {
		List<Note> result = new ArrayList<Note>();
		List<Note> existentNotes = null;

		try {
			existentNotes = notepadDao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}

		for (Note note : existentNotes) {
			if (isTextInNote(note, text)) {
				result.add(note);
			}
		}
		return result;
	}

	private boolean isTextInNote(Note note, String text) {
		return note.getTitle().contains(text) || note.getContent().contains(text);
	}

	public List<Note> findNotesByDate(Date date) throws LogicException {
		List<Note> result = new ArrayList<Note>();
		List<Note> existentNotes = null;

		try {
			existentNotes = notepadDao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}

		for (Note note : existentNotes) {
			if (note.getDate().equals(date)) {
				result.add(note);
			}
			return result;
		}
		return result;
	}

	public List<Note> allNotes() throws LogicException {
		try {
			return notepadDao.allNotes();
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}