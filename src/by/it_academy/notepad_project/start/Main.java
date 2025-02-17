package by.it_academy.notepad_project.start;

import by.it_academy.notepad_project.controller.Controller;
import by.it_academy.notepad_project.dao.DaoException;
import by.it_academy.notepad_project.service.LogicException;

public class Main {

	public static void main(String[] args) throws LogicException, DaoException {

		Controller controller = new Controller();
		String request;
		String response;

		request = "ADD\ntitle=First note\nсоntent=Monday";
		response = controller.doAction(request);
		System.out.println(response);

		request = "ADD\ntitle=Second note\nсоntent=Tuesday";
		response = controller.doAction(request);
		System.out.println(response);

		request = "UPDATE\nid=1\ntitle=First note\ncontent=Wednesday\ndate=2025-16-02";
		response = controller.doAction(request);
		System.out.println(response);

		request = "FIND_BY_DATE\ndate=2025-16-02";
		response = controller.doAction(request);
		System.out.println(response);

		request = "FIND_BY_CONTENT\nid=1";
		response = controller.doAction(request);
		System.out.println(response);

		request = "DISPLAY_ALL\n";
		response = controller.doAction(request);
		System.out.println(response);
	}
}
