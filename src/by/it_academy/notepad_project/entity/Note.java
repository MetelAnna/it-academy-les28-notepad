package by.it_academy.notepad_project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import by.it_academy.notepad_project.util.GeneratedID;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String content;
	private Date date;

	public Note() {
	}

	public Note(int id, String title, String content, Date date) {
		this.id = GeneratedID.nextID();
		this.title = title;
		this.content = content;
		this.date = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date) && id == other.id
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Note{" + "id =" + id + ", title ='" + title + '\'' + ", content ='" + content + '\'' + ", date =" + date
				+ '}';
	}
}
