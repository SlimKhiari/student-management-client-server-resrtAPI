package projetarchitecture2022.client.model;

import java.util.ArrayList;

public interface GroupInterface {
	
	// Group
	public void createGroup(int id, String name, int tId, String tTitle, int sId, String subjecTitle,
			String description, String studentId, String  firstname, String lastname);
	public void deleteGroup(int id, String name, int tId, String tTitle, int sId, String subjecTitle,
			String description, String studentId, String  firstname, String lastname);
	public ArrayList<Group> getGroups();
	public void deleteGroup(int id);
	public void addGroupe(Integer id, String name, ArrayList<Student> students, Subject subject,
			TeachingUnit teachingUnit);
	
	// Student
	public void createStudent(int id, String  firstname, String lastname);
	public void deleteStudent(int id, String  firstname, String lastname);
	public ArrayList<Student> getStudents();
	public Student getStudentById(int parseInt);
	
	// Subject
	public void createSubject(int id, String title, String description);
	public void deleteSubject(int id, String title, String description);
	public ArrayList<Subject> getSubjects();
	public Subject getSubjectByTitle(String string);
	
	// Teaching Unit
	public void createTeachingUnit(int id, String title);
	public void deleteTeachingUnit(int id, String title);
	public ArrayList<TeachingUnit> getTeachingUnits();
	public TeachingUnit getTeachingUnitByTitle(String string);
}