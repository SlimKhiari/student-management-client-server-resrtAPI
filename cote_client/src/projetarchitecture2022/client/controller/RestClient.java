package projetarchitecture2022.client.controller;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;

public class RestClient {
	private String url;
	
	public RestClient (String x,String y) {
		url= x+":"+y;
	}
	
	public String postCreateStudent(String id, String  firstname, String lastname)
	{		
		HttpResponse<String> response = Unirest.post("http://"+url+"/createStudent")
				  .header("Content-Type", "application/json")
				  .body("{ \"studentId\" :"
					  		+ " \""+id+"\" , \"firstName\" : \""+firstname+"\" , \"lastName\" : "
					  		+ "\""+lastname+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String postCreateSubject(int id, String title, String description)
	{
		HttpResponse<String> response = Unirest.post("http://"+url+"/createSubject")
				  .header("Content-Type", "application/json")
				  .body("{ \"subjectId\" : \""+id+"\" , "
				  		+ "\"subjectTitle\" : \""+title+"\" ,"
				  		+ " \"subjectDescription\" : \""+description+"\" }\n")
				  .asString();
		return response.getBody();
	}

	public String postCreateTeachingUnit(int id, String title)
	{
		HttpResponse<String> response = Unirest.post("http://"+url+"/createTeachingUnit")
				  .header("Content-Type", "application/json")
				  .body("{  \"teachingUnitId\" : \""+id+"\" ,"
				  		+ " \"teachingUnitTitle\" : \""+title+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String postCreateGroup(int id, String name, int tId, String tTitle, int sId, String subjecTitle,
			String description)
	{
		HttpResponse<String> response = Unirest.post("http://"+url+"/createGroup")
				  .header("Content-Type", "application/json")
				  .body("{ \"groupId\" : \""+id+"\" ,"
				  		+ " \"groupName\" : \""+name+"\" , "
				  		+ "\"teachingUnitId\" : \""+tId+"\" , "
				  		+ "\"teachingUnitTitle\" : \""+tTitle+"\" ,"
				  		+ " \"subjectId\" : \""+sId+"\" ,"
				  		+ "\"subjectTitle\" : \""+subjecTitle+"\" , "
				  		+ " \"subjectDescription\" : \""+description+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String postCreateGroupStudent(int studentId, String firstname, String lastname, int idgroup) {
		HttpResponse<String> response = Unirest.post("http://"+url+"/createGroupStudent")
				  .header("Content-Type", "application/json")
				  .body("{ \"studentId\" : \""+studentId+"\" ,"
						+ "\"idgroup\" : \""+idgroup+"\" }\n")
				  .asString();
		return response.getBody();
	}

	public String postDeleteStudent(String id, String  firstname, String lastname)
	{		
		HttpResponse<String> response = Unirest.delete("http://"+url+"/deleteStudent")
				  .header("Content-Type", "application/json")
				  .body("{ \"studentId\" :"
					  		+ " \""+id+"\" , \"firstName\" : \""+firstname+"\" , \"lastName\" : "
					  		+ "\""+lastname+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String postDeleteSubject(int id, String title, String description)
	{
		HttpResponse<String> response = Unirest.delete("http://"+url+"/deleteSubject")
				  .header("Content-Type", "application/json")
				  .body("{ \"subjectId\" : \""+id+"\" , "
				  		+ "\"subjectTitle\" : \""+title+"\" ,"
				  		+ " \"subjectDescription\" : \""+description+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String postDeleteTeachingUnit(int id, String title)
	{
		HttpResponse<String> response = Unirest.delete("http://"+url+"/deleteTeachingUnit")
				  .header("Content-Type", "application/json")
				  .body("{  \"teachingUnitId\" : \""+id+"\" ,"
				  		+ " \"teachingUnitTitle\" : \""+title+"\" }\n")
				  .asString();
		return response.getBody();
	}
	  
	public String postDeleteGroup(String name)
	{
		HttpResponse<String> response = Unirest.delete("http://"+url+"/deleteGroup")
				  .header("Content-Type", "application/json")
				  .body("{ \"groupName\" : \""+name+"\" }\n")
				  .asString();
		return response.getBody();
	}
	
	public String getData(String param)
	{
		HttpResponse<String> response = Unirest.get("http://"+url+"/"+param)
				  .header("Content-Type", "application/json")
				  .asString();
		return response.getBody();
	}
	
	public String getTeachingUnitByTitle(String title)
	{
		HttpResponse<String> response = Unirest.get("http://"+url+"/teachingunit/"+title)
				  .header("Content-Type", "application/json")
				  .asString();
		return response.getBody();
	}
	
	public String getSubjectByTitle(String title)
	{
		HttpResponse<String> response = Unirest.get("http://"+url+"/subject/"+title)
				  .header("Content-Type", "application/json")
				  .asString();
		return response.getBody();
	}
	
	public String getStudentById(int id)
	{
		HttpResponse<String> response = Unirest.get("http://"+url+"/student/"+id)
				  .header("Content-Type", "application/json")
				  .asString();
		return response.getBody();
	}

}