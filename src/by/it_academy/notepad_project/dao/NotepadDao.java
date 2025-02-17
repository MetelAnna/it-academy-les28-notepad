package by.it_academy.notepad_project.dao;

import java.util.List;
import by.it_academy.notepad_project.entity.*;

public interface NotepadDao {

	List<Note> save(Note note) throws DaoException;

	List<Note> allNotes() throws DaoException;
}
