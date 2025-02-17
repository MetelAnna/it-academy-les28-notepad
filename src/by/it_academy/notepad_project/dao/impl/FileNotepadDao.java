package by.it_academy.notepad_project.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.dao.DaoException;
import by.it_academy.notepad_project.dao.NotepadDao;

public final class FileNotepadDao implements NotepadDao {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-DD");

	private static FileNotepadDao instance = null;

	public static FileNotepadDao getInstance() {
		if (instance == null) {
			instance = new FileNotepadDao();
		}
		return instance;
	}

	public List<Note> save(Note note) throws DaoException {
		FileWriter writer = null;
		try {
			writer = new FileWriter("notes.txt", true);
			writer.write("Title: " + note.getTitle() + "\n");
			writer.write("Content: " + note.getContent() + "\n");
			writer.write("Date: " + note.getDate() + "\n");
			writer.write("-----\n");
			System.out.println("Note saved.");
		} catch (FileNotFoundException e) {
			System.err.println("Error saving note: " + e.getMessage());
			throw new DaoException(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error saving file: " + e.getMessage());
			throw new DaoException(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println("Error closing file: " + e.getMessage());
					throw new DaoException(e);
				}
			}
		}
		return null;
	}

	public List<Note> allNotes() throws DaoException {
		List<Note> notes = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
			String line;
			Note note = null;
			while ((line = reader.readLine()) != null) {
				note = processLine(line, note, notes);
			}
		} catch (ParseException e) {
			throw new DaoException("Error reading date: ", e);
		} catch (IOException e) {
			throw new DaoException("Error reading notes: ", e);
		}
		return notes;
	}

	private Note processLine(String line, Note note, List<Note> notes) throws ParseException {
		if (line.startsWith("Title: ")) {
			note = new Note();
			note.setTitle(line.substring(7));
		} else if (line.startsWith("Content: ")) {
			note.setContent(line.substring(9));
		} else if (line.startsWith("Date: ")) {
			note.setDate(DATE_FORMAT.parse(line.substring(6)));
		} else if (line.equals("----------")) {
			notes.add(note);
		}
		return note;
	}
}
