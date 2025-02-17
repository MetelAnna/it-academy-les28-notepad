package by.it_academy.notepad_project.util;

import java.util.regex.Pattern;

public class Patterns {

	public static final Pattern TITLE_PATTERN = Pattern.compile("^[A-Za-z0-9_ ]+$");
	public static final Pattern CONTENT_PATTERN = Pattern.compile("^[A-Za-z0-9_ .,!?;]+$");
	public static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}\\.\\d{2}\\.\\d{2}$");
	public static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");
}
