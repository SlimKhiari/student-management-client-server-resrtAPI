package controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;

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
			
			return st;
		});
	}
	public void deleteStudent() {
		delete("/deleteStudent", (request, response) -> {
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Suppression d'une personne");
			String studentId = jsonRequest.get("studentId").toString().replaceAll("\"", "");
			String firstName = jsonRequest.get("firstName").toString().replaceAll("\"", "");
			String lastName = jsonRequest.get("lastName").toString().replaceAll("\"", "");
			
			System.out.println(studentId + "id of student");
			
			Student st = new Student(Integer.parseInt(studentId),firstName,lastName);
		
			StudentController.deleteStudent(st);
			
			return st;
		});
	}
	
	public void deleteSubject() {
		delete("/deleteSubject", (request, response) -> {
			SubjectController subjectController = new SubjectController();
	    	
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			String subjecttId = jsonRequest.get("subjectId").toString().replaceAll("\"", "");
			String subjectTitle = jsonRequest.get("subjectTitle").toString().replaceAll("\"", "");
			String subjectDescription = jsonRequest.get("subjectDescription").toString().replaceAll("\"", "");
			
			Subject su = new Subject(Integer.parseInt(subjecttId),subjectTitle,subjectDescription);
		
			subjectController.deleteSubject(su);
			
			return su;
		});
	}
	
	public void deleteTU() {
		delete("/deleteTeachingUnit", (request, response) -> {
			TeachingUnitController tuController = new TeachingUnitController();
	    	
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			String tuId = jsonRequest.get("teachingUnitId").toString().replaceAll("\"", "");
			String tuTitle = jsonRequest.get("teachingUnitTitle").toString().replaceAll("\"", "");
	
			TeachingUnit tu = new TeachingUnit(Integer.parseInt(tuId),tuTitle);
		
			tuController.deleteTeachingunit(tu);
			
			return tu;
		});
	}
	
	public void deleteGroup() {
		delete("/deleteGroup", (request, response) -> {
			GroupController groupController = new GroupController();
	    	
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			String groupName = jsonRequest.get("groupName").toString().replaceAll("\"", "");
		
			Group gr = new Group(0,groupName,null,null,null);
		
			groupController.deleteGroup(gr);
			
			return gr;
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
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Create subject");
			String subjectId = jsonRequest.get("subjectId").toString().replaceAll("\"", "");
			String subjectTitle = jsonRequest.get("subjectTitle").toString().replaceAll("\"", "");
			String subjectDescription = jsonRequest.get("subjectDescription").toString().replaceAll("\"", "");
			
			System.out.print(subjectId + "id of student");
			
			Subject sb = new Subject(Integer.parseInt(subjectId),subjectTitle,subjectDescription);
		
			SubjectController.createSubject(sb);
			
			return sb;
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
	public void creatTU() {
		post("/createTeachingUnit", (request, response) -> {
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Creation of TU");
			String teachingUnitId = jsonRequest.get("teachingUnitId").toString().replaceAll("\"", "");
			String teachingUnitTitle = jsonRequest.get("teachingUnitTitle").toString().replaceAll("\"", "");
			
			System.out.print(teachingUnitId + "id of TU");
			
			TeachingUnit tu = new TeachingUnit(Integer.parseInt(teachingUnitId),teachingUnitTitle);
			
			TeachingUnitController.createTeachingunit(tu);
			
			return tu;
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
	public void creatgroups() {
		post("/createGroup", (request, response) -> {
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Creation des groups");
			String groupId = jsonRequest.get("groupId").toString().replaceAll("\"", "");
			String groupName = jsonRequest.get("groupName").toString().replaceAll("\"", "");
			String teachingUnitId = jsonRequest.get("teachingUnitId").toString().replaceAll("\"", "");
			String teachingUnitTitle = jsonRequest.get("teachingUnitTitle").toString().replaceAll("\"", "");
			String subjectId = jsonRequest.get("subjectId").toString().replaceAll("\"", "");
			String subjectTitle = jsonRequest.get("subjectTitle").toString().replaceAll("\"", "");
			String subjectDescription = jsonRequest.get("subjectDescription").toString().replaceAll("\"", "");
			
			System.out.print(groupId + "id of Grp");
			System.out.print(teachingUnitId + "id of TU");
			System.out.print(subjectId + "id of Sub");
			
			TeachingUnit tu = new TeachingUnit(Integer.parseInt(teachingUnitId),teachingUnitTitle);
			Subject sb = new Subject(Integer.parseInt(subjectId),subjectTitle,subjectDescription);

			Group gr = new Group(Integer.parseInt(groupId),groupName,tu,null,sb);
			
			GroupController.addGroupe(gr);
			
			
			return gr;
		});
	}
	public void creatgroupStudent() {
		post("/createGroupStudent", (request, response) -> {
			String result = "{ \"result\" : \"test\" }";
			JsonObject jsonRequest = jsonParser.parse(request.body()).getAsJsonObject();

			System.out.println(request);
			System.out.println("Creation des groups");
			String idgroup = jsonRequest.get("idgroup").toString().replaceAll("\"", "");
			String studentId = jsonRequest.get("studentId").toString().replaceAll("\"", "");
			
			System.out.print(studentId + "id of student");
			System.out.print(idgroup + "id of grp");
			
			Student st= StudentController.getStudentById(Integer.parseInt(studentId));
			
			//Group gr = new Group(Integer.parseInt(groupId),groupName,tu,null,sb);
			
			//GroupController.addGroupe(GroupController.);
			return result;
		});
	}

	
}