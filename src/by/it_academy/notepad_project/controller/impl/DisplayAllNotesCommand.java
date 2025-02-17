package by.it_academy.notepad_project.controller.impl;

import java.util.List;

import by.it_academy.notepad_project.controller.Command;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.LogicProvider;
import by.it_academy.notepad_project.service.NotepadLogic;

public class DisplayAllNotesCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotepadLogic logic = logicProvider.getNotepadLogic();

	@Override
	public String execute(String request) {
		StringBuilder response = new StringBuilder();

		try {
			List<Note> n = logic.allNotes();
			for (Note note : n) {
				response.append(note.toString()).append("\n");
			}
		} catch (LogicException e) {
			response.append("Error getting notes: ").append(e);
			return response.toString();
		}
		return request;
	}
}
