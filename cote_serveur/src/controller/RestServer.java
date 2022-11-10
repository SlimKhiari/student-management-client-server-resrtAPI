package controller;

import static spark.Spark.get;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Group;
import model.Student;
import model.Subject;
import model.TeachingUnit;

public class RestServer {
	
	public void getStudents() {
		get("/students", (request, response) -> {
			StudentController studentController = new StudentController();
	    	
			JSONArray students = new JSONArray();
			
			for (Student s : studentController.getStudents()) {
				JSONObject jo = new JSONObject();
				
				jo.put("id", s.getId());
				jo.put("firstname", s.getFirstname());
				jo.put("lastname", s.getLastname());
				students.put(jo);
			}
			
			return students;
		});
	}
	
	public void getSubjects() {
		get("/subjects", (request, response) -> {
			SubjectController subjectController = new SubjectController();
	    	
			JSONArray subjects = new JSONArray();
			
			for (Subject s : subjectController.getSubjects()) {
				JSONObject jo = new JSONObject();
				
				jo.put("id", s.getId());
				jo.put("title", s.getTitle());
				jo.put("description", s.getDescription());
				subjects.put(jo);
			}
			
			return subjects;
		});
	}
	
	public void getTU() {
		get("/teachingunits", (request, response) -> {
			TeachingUnitController teachingUnitController = new TeachingUnitController();
	    	
			JSONArray teachingUnits = new JSONArray();
			
			for (TeachingUnit s : teachingUnitController.getTeachingUnits()) {
				JSONObject jo = new JSONObject();
				
				jo.put("id", s.getId());
				jo.put("title", s.getTitle());
				teachingUnits.put(jo);
			}
			
			return teachingUnits;
		});
	}
	
	public void getGroups() {
		get("/groups", (request, response) -> {
			GroupController groupController = new GroupController();
	    	
			JSONArray groups = new JSONArray();
			
			for (Group g : groupController.getListeGroupes()) {
				JSONObject jo = new JSONObject();
				
				jo.put("id", g.getId());
				jo.put("name", g.getName());
				jo.put("teachingUnitTitle", g.getTeachingUnit().getTitle());
				jo.put("subjectTitle", g.getSubject().getTitle());
				jo.put("students", new JSONArray(g.getStudents()));
				groups.put(jo);
				
			}
			
			return groups;
		});
	}
	
}
