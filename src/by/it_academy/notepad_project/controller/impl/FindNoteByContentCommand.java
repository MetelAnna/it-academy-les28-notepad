package by.it_academy.notepad_project.controller.impl;

import java.util.List;

import by.it_academy.notepad_project.controller.Command;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.LogicProvider;
import by.it_academy.notepad_project.service.NotepadLogic;
import by.it_academy.notepad_project.util.Validation;

public class FindNoteByContentCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotepadLogic logic = logicProvider.getNotepadLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		List<Note> notesByContent = null;

		params = request.split("\n");

		if (params.length < 2 || !Validation.isContentValid(params[1])) {
			return "Wrong format of content.";
		}

		try {
			notesByContent = logic.findNotesByContent(params[1]);
		} catch (LogicException e) {
			return "Try again.";
		}

		if (notesByContent == null || notesByContent.isEmpty()) {
			response = "Nothing found.";
		} else {
			for (Note note : notesByContent) {
				response = response + note.toString() + "\n";
			}
		}
		return response;
	}
}
