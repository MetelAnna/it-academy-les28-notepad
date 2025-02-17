package by.it_academy.notepad_project.service;

import java.util.Date;
import java.util.List;
import by.it_academy.notepad_project.entity.Note;

public interface NotepadLogic {

	public void add(Note note) throws LogicException;

	public void add(String title, String content) throws LogicException;

	public List<Note> allNotes() throws LogicException;

	List<Note> findNotesByContent(String content) throws LogicException;

	List<Note> findNotesByDate(Date date) throws LogicException;
}
