package by.it_academy.notepad_project.controller.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.it_academy.notepad_project.controller.Command;
import by.it_academy.notepad_project.entity.Note;
import by.it_academy.notepad_project.service.LogicException;
import by.it_academy.notepad_project.service.LogicProvider;
import by.it_academy.notepad_project.service.NotepadLogic;
import by.it_academy.notepad_project.util.Validation;

public class UpdateNoteCommand implements Command {

	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotepadLogic logic = logicProvider.getNotepadLogic();

	@Override
	public String execute(String request) throws LogicException {
		String response = null;
		String[] params;
		Note newNote;

		params = request.split("\n");
		newNote = new Note();

		if (params.length < 5 || !Validation.isIdValid(params[1].split("=")[1])) {
			return "Wrong ID.";
		}
		newNote.setId(Integer.parseInt(params[1].split("=")[1]));

		if (!Validation.isTitleValid(params[2].split("=")[1])) {
			return "Wrong title format.";
		}
		newNote.setTitle(params[2].split("=")[1]);

		if (!Validation.isContentValid(params[3].split("=")[1])) {
			return "Wrong content format.";
		}
		newNote.setContent(params[3].split("=")[1]);

		if (!Validation.isDateValid(params[4].split("=")[1])) {
			return "Wrong date format. Use YYYY-MM-DD.";
		}

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("YYYY-MM-DD");
		Date date;
		try {
			date = format.parse(params[4].split("=")[1]);
			newNote.setDate(date);
			logic.add(newNote);
			response = "Note was updated successfully.";
		} catch (ParseException e) {
			response = "Note was not updated.";
		} catch (LogicException e) {
			response = "Try again.";
		}
		return response;
	}
}
