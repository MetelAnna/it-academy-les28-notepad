package by.it_academy.notepad_project.util;

import java.util.regex.Matcher;

public class Validation {

	public static boolean isTitleValid(String title) {
		Matcher matcher = Patterns.TITLE_PATTERN.matcher(title);
		return matcher.matches();
	}

	public static boolean isContentValid(String content) {
		Matcher matcher = Patterns.CONTENT_PATTERN.matcher(content);
		return matcher.matches();
	}

	public static boolean isDateValid(String date) {
		Matcher matcher = Patterns.DATE_PATTERN.matcher(date);
		return matcher.matches();
	}

	public static boolean isIdValid(String id) {
		Matcher matcher = Patterns.ID_PATTERN.matcher(id);
		return matcher.matches();
	}
}
