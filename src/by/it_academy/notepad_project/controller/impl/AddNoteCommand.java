package by.it_academy.notepad_project.controller.impl;

import by.it_academy.notepad_project.controller.Command;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.LogicProvider;
import by.it_academy.notepad_project.service.NotepadLogic;
import by.it_academy.notepad_project.util.Validation;

public class AddNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotepadLogic logic = logicProvider.getNotepadLogic();

	@Override
	public String execute(String request) {
		String response = null;
		String[] params;
		Note newNote;

		params = request.split("\n");

		if (params.length < 3 || !params[1].startsWith("title=") || !params[2].startsWith("content=")) {
			return "Wrong request format. Please enter title and content in correct order.";
		}
		String title = params[1].split("=")[1];
		String content = params[2].split("=")[1];

		if (!Validation.isTitleValid(title) || !Validation.isContentValid(content)) {
			return "Wrong format of title or content.";
		}

		newNote = new Note();
		newNote.setTitle(title);
		newNote.setContent(content);

		try {
			logic.add(newNote);
			response = "Note was successfully added";
		} catch (LogicException e) {
			response = "Try again.";
		}
		return response;
	}
}
