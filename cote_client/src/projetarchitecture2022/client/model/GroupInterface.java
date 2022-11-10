package projetarchitecture2022.client.model;

import java.util.ArrayList;

public interface GroupInterface {
	
	// Group
	public void addGroupe(Integer id, String name, ArrayList<Student> students, Subject subject,
			TeachingUnit teachingUnit);
	public void deleteGroup(String name);
	public ArrayList<Group> getGroups();
	
	// Student
	public void createStudent(int id, String  firstname, String lastname);
	public void deleteStudent(int id, String  firstname, String lastname);
	public ArrayList<Student> getStudents();
	public Student getStudentById(int id);
	
	// Subject
	public void createSubject(int id, String title, String description);
	public void deleteSubject(int id, String title, String description);
	public ArrayList<Subject> getSubjects();
	public Subject getSubjectByTitle(String title);
	
	// Teaching Unit
	public void createTeachingUnit(int id, String title);
	public void deleteTeachingUnit(int id, String title);
	public ArrayList<TeachingUnit> getTeachingUnits();
	public TeachingUnit getTeachingUnitByTitle(String title);
}