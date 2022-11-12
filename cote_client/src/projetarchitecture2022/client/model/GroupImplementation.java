package projetarchitecture2022.client.model;

import java.util.ArrayList;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import projetarchitecture2022.client.controller.RestClient;

public class GroupImplementation implements GroupInterface {

	public RestClient restClient;
	
	public void initRestClient(String x, String y)
	{
		this.restClient = new RestClient(x, y);
	}
	
	@Override
	public void addGroupe(Integer id, String name, ArrayList<Student> students, Subject subject,
			TeachingUnit teachingUnit) {
		this.restClient.postCreateGroup(id, name, teachingUnit.getId(), teachingUnit.getTitle(), subject.getId(), subject.getTitle(), subject.getDescription());
		for (Student student : students)
			this.restClient.postCreateGroupStudent(student.getId(), student.getFirstname(), student.getLastname(), id);
	}

	@Override
	public void deleteGroup(String name) {
		this.restClient.postDeleteGroup(name);
	}

	@Override
	public void createStudent(int id, String firstname, String lastname) {
		this.restClient.postCreateStudent(id, firstname, lastname);
	}

	@Override
	public void deleteStudent(int id, String firstname, String lastname) {
		// System.out.println("My ID: "+id+" /////////// "+Integer.toString(id));
		this.restClient.postDeleteStudent(Integer.toString(id), firstname, lastname);
	}

	@Override
	public void createSubject(int id, String title, String description) {
		 System.out.println("My ID: "+id+" /////////// "+id);

		this.restClient.postCreateSubject(id, title, description);
	}

	@Override
	public void deleteSubject(int id, String title, String description) {
		this.restClient.postDeleteSubject(id, title, description);
	}

	@Override
	public void createTeachingUnit(int id, String title) {
		System.out.println("My ID: "+id+" /////////// "+id);
		this.restClient.postCreateTeachingUnit(id, title);
	}

	@Override
	public void deleteTeachingUnit(int id, String title) {
		this.restClient.postDeleteTeachingUnit(id, title);
	}

	@Override
	public ArrayList<Student> getStudents() {
		String response = this.restClient.getData("students");
		
		JSONArray ja = new JSONArray(response);
		
		return JSONToStudentList(ja);
	}
	
	public ArrayList<Student> JSONToStudentList(JSONArray studentsJSON) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (int i=0; i<studentsJSON.length(); i++) {
			JSONObject objStudent = studentsJSON.getJSONObject(i);  
			students.add(new Student(objStudent.getInt("id"), objStudent.getString("firstname"), objStudent.getString("lastname")));		
		}
		
		return students;
	}

	@Override
	public ArrayList<TeachingUnit> getTeachingUnits() {
		String response = this.restClient.getData("teachingunits");

		JSONArray tuJSON = new JSONArray(response);
		ArrayList<TeachingUnit> teachingUnits = new ArrayList<TeachingUnit>();
		
		for (int i=0; i<tuJSON.length(); i++) {
			JSONObject objTU = tuJSON.getJSONObject(i);  
			teachingUnits.add(new TeachingUnit(objTU.getInt("id"), objTU.getString("title")));
		}
		
		return teachingUnits;
	}

	@Override
	public ArrayList<Group> getGroups() {
		String response = this.restClient.getData("groups");
		
		JSONArray groupJSON = new JSONArray(response);
		
		ArrayList<Group> groups = new ArrayList<Group>();
		
		for (int i=0; i<groupJSON.length(); i++) {
			JSONObject objGroup = groupJSON.getJSONObject(i);  
			ArrayList<Student> students = JSONToStudentList(objGroup.getJSONArray("students"));
			Subject subject = getSubjectByTitle(objGroup.getString("subjectTitle"));
			TeachingUnit teachingUnit = getTeachingUnitByTitle(objGroup.getString("teachingUnitTitle"));
			groups.add(new Group(objGroup.getInt("id"), objGroup.getString("name"), teachingUnit, students, subject));
		}
		
		return groups;
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		String response = this.restClient.getData("subjects");
		
		JSONArray subjectsJSON = new JSONArray(response);
		
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		for (int i=0; i<subjectsJSON.length(); i++) {
			JSONObject objSubject = subjectsJSON.getJSONObject(i);  
			subjects.add(new Subject(objSubject.getInt("id"), objSubject.getString("title"), objSubject.getString("description")));
		}

		return subjects;
	}

	@Override
	public TeachingUnit getTeachingUnitByTitle(String title) {
		String response = this.restClient.getTeachingUnitByTitle(title);		

		System.out.println(response);
		JSONObject tuJSON = new JSONObject(response);
		
		return new TeachingUnit(tuJSON.getInt("id"), tuJSON.getString("title"));
	}

	@Override
	public Subject getSubjectByTitle(String title) {
		String response = this.restClient.getSubjectByTitle(title);
		JSONObject subjectJSON = new JSONObject(response);
		
		return new Subject(subjectJSON.getInt("id"), subjectJSON.getString("title"), subjectJSON.getString("description"));
	}

	@Override
	public Student getStudentById(int id) {
		String response = this.restClient.getStudentById(id);
		JSONObject studentJSON = new JSONObject(response);
		
		return new Student(studentJSON.getInt("id"), studentJSON.getString("firstname"), studentJSON.getString("lastname"));
	}

}
