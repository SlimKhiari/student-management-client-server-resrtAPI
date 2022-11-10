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
		String response = this.restClient.getData("students");
		String[] studentsString = response.split("\n");
		
		return stringListToStudentList(studentsString);
	}
	
	public ArrayList<Student> stringListToStudentList(String[] studentsString) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (String studentString : studentsString) {
			String[] paramsStudents = studentString.split(" ");
			students.add(new Student(Integer.parseInt(paramsStudents[0]), paramsStudents[1], paramsStudents[3]));
		}
		return students;
	}

	@Override
	public ArrayList<TeachingUnit> getTeachingUnits() {
		String response = this.restClient.getData("teachingUnits");
		String[] teachingUnitsString = response.split("\n");
		
		ArrayList<TeachingUnit> teachingUnits = new ArrayList<TeachingUnit>();
		
		for (String teachingUnitString : teachingUnitsString) {
			String[] paramsTU = teachingUnitString.split(" ");
			teachingUnits.add(new TeachingUnit(Integer.parseInt(paramsTU[0]), paramsTU[1]));
		}
		
		return teachingUnits;
	}

	@Override
	public ArrayList<Group> getGroups() {
		String response = this.restClient.getData("groups");
		String[] groupsString = response.split("\n");
		
		ArrayList<Group> groups = new ArrayList<Group>();
		
		for (String groupString : groupsString) {
			String[] paramsGroup = groupString.split(" ");
			TeachingUnit teachingUnit = getTeachingUnitByTitle(paramsGroup[2]);
			String[] studentsString = paramsGroup[2].split("\n");
			ArrayList<Student> students = stringListToStudentList(studentsString);
			Subject subject = getSubjectByTitle(paramsGroup[4]);
			groups.add(new Group(Integer.parseInt(paramsGroup[0]), paramsGroup[1], teachingUnit, students, subject));
		}
		
		return groups;
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		String response = this.restClient.getData("subjects");
		String[] subjectsString = response.split("\n");
		
		ArrayList<Subject> subjects = new ArrayList<Subject>();
		
		for (String subjectString : subjectsString) {
			String[] paramsSubject = subjectString.split(" ");
			subjects.add(new Subject(Integer.parseInt(paramsSubject[0]), paramsSubject[1], paramsSubject[2]));
		}
		
		return subjects;
	}

	@Override
	public TeachingUnit getTeachingUnitByTitle(String title) {
		String response = this.restClient.getTeachingUnitByTitle(title);
		String[] TUString = response.split(" ");
		
		return new TeachingUnit(Integer.parseInt(TUString[0]), TUString[1]);
	}

	@Override
	public Subject getSubjectByTitle(String title) {
		String response = this.restClient.getSubjectByTitle(title);
		String[] subjectString = response.split(" ");
		
		return new Subject(Integer.parseInt(subjectString[0]), subjectString[1], subjectString[2]);
	}

	@Override
	public Student getStudentById(int id) {
		String response = this.restClient.getStudentById(id);
		String[] studentString = response.split(" ");
		
		return new Student(Integer.parseInt(studentString[0]), studentString[1], studentString[3]);
	}

}
