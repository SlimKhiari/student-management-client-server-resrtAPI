package controller;

import static spark.Spark.get;
import static spark.Spark.post;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Group;
import model.Student;
import model.Subject;
import model.TeachingUnit;

public class RestServer {
	
	JsonParser jsonParser = new JsonParser();
	
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
	public void createStudent() {
		post("/createStudent", (request, response) -> {
			String result = "{ \"result\" : \"error\" }";
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			// System.out.println(jsonRequest.get("command").toString().equals("\"asba\""));
			// if (jsonRequest.get("command").toString().equals("\"createPerson\"")) {
			System.out.println("Creation d'une personne");
			String studentId = jsonRequest.get("studentId").toString().replaceAll("\"", "");
			String firstName = jsonRequest.get("firstName").toString().replaceAll("\"", "");
			String lastName = jsonRequest.get("lastName").toString().replaceAll("\"", "");
			
			System.out.print(studentId + "id of student");
			
			Student st = new Student(Integer.parseInt(studentId),firstName,lastName);
		
			StudentController.createStudent(st);
			
			
			return result;
		});
	}
	public void deleteStudent() {
		post("/deleteStudent", (request, response) -> {
			String result = "{ \"result\" : \"error\" }";
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Suppression d'une personne");
			String studentId = jsonRequest.get("studentId").toString().replaceAll("\"", "");
			String firstName = jsonRequest.get("firstName").toString().replaceAll("\"", "");
			String lastName = jsonRequest.get("lastName").toString().replaceAll("\"", "");
			
			System.out.println(studentId + "id of student");
			
			Student st = new Student(Integer.parseInt(studentId),firstName,lastName);
		
			StudentController.deleteStudent(st);
			
			
			return result;
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
	public void createSubjects() {
		post("/createSubject", (request, response) -> {
			String result = "{ \"result\" : \"error\" }";
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Create subject");
			String subjectId = jsonRequest.get("subjectId").toString().replaceAll("\"", "");
			String subjectTitle = jsonRequest.get("subjectTitle").toString().replaceAll("\"", "");
			String subjectDescription = jsonRequest.get("subjectDescription").toString().replaceAll("\"", "");
			
			System.out.print(subjectId + "id of student");
			
			Subject sb = new Subject(Integer.parseInt(subjectId),subjectTitle,subjectDescription);
		
			SubjectController.createSubject(sb);
			
			
			return result;
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
	
	public void getTUByTitle() {
		get("/teachingunit/:title", (request, response) -> {
			TeachingUnitController teachingUnitController = new TeachingUnitController();
	    	
			TeachingUnit t = teachingUnitController.getTeachingUnitByTitle(request.params(":title"));
			JSONObject jo = new JSONObject();
			
			jo.put("id", t.getId());
			jo.put("title", t.getTitle());

			return jo;
		});
	}
	
	public void getSubjectByTitle() {
		get("/subject/:title", (request, response) -> {
			SubjectController subjectController = new SubjectController();
	    	
			Subject s = subjectController.getSubjectByTitle(request.params(":title"));
			JSONObject jo = new JSONObject();
			
			jo.put("id", s.getId());
			jo.put("title", s.getTitle());
			jo.put("description", s.getDescription());

			return jo;
		});
	}
	
	public void getStudentById() {
		get("/student/:id", (request, response) -> {
			System.out.println("ok");
			StudentController studentController = new StudentController();
	    	
			Student s = studentController.getStudentById(Integer.parseInt(request.params(":id")));
			JSONObject jo = new JSONObject();
			
			jo.put("id", s.getId());
			jo.put("firstname", s.getFirstname());
			jo.put("lastname", s.getLastname());

			System.out.println(jo);
			return jo;
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