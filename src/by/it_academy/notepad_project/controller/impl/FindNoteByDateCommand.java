package by.it_academy.notepad_project.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import by.it_academy.notepad_project.controller.Command;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.LogicProvider;
import by.it_academy.notepad_project.service.NotepadLogic;
import by.it_academy.notepad_project.util.Validation;

public class FindNoteByDateCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotepadLogic logic = logicProvider.getNotepadLogic();

	@Override
	public String execute(String request) {
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		String response = null;
		String[] params;

		params = request.split("\n");

		if (params.length < 2 || !Validation.isDateValid(params[1])) {
			return "Wrong date format. Use YYYY-MM-DD.";
		}
		try {
			for (Note note : logic.findNotesByDate(formatter.parse(params[1]))) {
				response = response + note.toString() + "\n";
			}
		} catch (LogicException | ParseException e) {
			response = "Try again.";
		}
		return response;
	}
}
