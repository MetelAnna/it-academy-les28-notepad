package by.it_academy.notepad_project.controller;

import java.util.HashMap;
import java.util.Map;

import by.it_academy.notepad_project.controller.impl.AddNoteCommand;
import by.it_academy.notepad_project.controller.impl.DisplayAllNotesCommand;
import by.it_academy.notepad_project.controller.impl.NoSuchCommand;
import by.it_academy.notepad_project.controller.impl.UpdateNoteCommand;
import by.it_academy.notepad_project.controller.impl.FindNoteByContentCommand;
import by.it_academy.notepad_project.controller.impl.FindNoteByDateCommand;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.FIND_BY_CONTENT, new FindNoteByContentCommand());
		repository.put(CommandName.FIND_BY_DATE, new FindNoteByDateCommand());
		repository.put(CommandName.DISPLAY_ALL, new DisplayAllNotesCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
