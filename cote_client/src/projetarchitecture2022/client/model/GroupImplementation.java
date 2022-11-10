package projetarchitecture2022.client.model;

import java.util.ArrayList;

import projetarchitecture2022.client.controller.RestClient;

public class GroupImplementation implements GroupInterface {

	public RestClient restClient;
	
	public void initRestClient(String x, String y)
	{
		this.restClient = new RestClient(x, y);
	}
	
	@Override
	public void createGroup(int id, String name, int tId, String tTitle, int sId, String subjecTitle,
			String description, String studentId, String firstname, String lastname) {
		this.restClient.postCreateGroup(id, name, tId, tTitle, sId, subjecTitle, description, studentId, firstname, lastname);
	}

	@Override
	public void deleteGroup(int id, String name, int tId, String tTitle, int sId, String subjecTitle,
			String description, String studentId, String firstname, String lastname) {
		this.restClient.postDeleteGroup(id, name, tId, tTitle, sId, subjecTitle, description, studentId, firstname, lastname);
	}

	@Override
	public void createStudent(int id, String firstname, String lastname) {
		this.restClient.postCreateStudent(Integer.toString(id), firstname, lastname);
	}

	@Override
	public void deleteStudent(int id, String firstname, String lastname) {
		this.restClient.postDeleteStudent(Integer.toString(id), firstname, lastname);
	}

	@Override
	public void createSubject(int id, String title, String description) {
		this.restClient.postCreateSubject(id, title, description);
	}

	@Override
	public void deleteSubject(int id, String title, String description) {
		this.restClient.postDeleteSubject(id, title, description);
	}

	@Override
	public void createTeachingUnit(int id, String title) {
		this.restClient.postCreateTeachingUnit(id, title);
	}

	@Override
	public void deleteTeachingUnit(int id, String title) {
		this.restClient.postDeleteTeachingUnit(id, title);
	}

	@Override
	public ArrayList<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeachingUnit> getTeachingUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Group> getGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGroup(int id) {
		// TODO Auto-generated method stub
		
	}

	public void addGroupe(Integer id, String name, ArrayList<Student> students, Subject subject,
			TeachingUnit teachingUnit) {
		// TODO Auto-generated method stub
		
	}

	public TeachingUnit getTeachingUnitByTitle(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Subject getSubjectByTitle(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudentById(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

}
