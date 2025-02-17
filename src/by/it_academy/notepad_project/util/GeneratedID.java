package by.it_academy.notepad_project.util;

public final class GeneratedID {

	private GeneratedID() {
	}

	private static int nextID = 1;

	public static int nextID() {
		return nextID++;
	}
}
