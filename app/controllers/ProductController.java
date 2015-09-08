package controllers;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.DB;
import com.mongodb.MongoClient;

import models.Friend;
import models.Product;
import play.libs.Json;
import play.mvc.*;
import play.mvc.Http.RequestBody;

public class ProductController extends Controller {

	public  Result index(){
		System.out.println("Inside product controller index");
		Product product = new Product();
		product.setId(123);
		product.setName("sdasda");
		//return product;
		//return ok(product);
		return ok(Json.toJson(product));
	
	}

	@BodyParser.Of(BodyParser.Json.class)
	public  Result create(){
		System.out.println("Inside product controller create");
		RequestBody requestBody = request().body();
		JsonNode json = requestBody.asJson();
		int id = json.findPath("id").asInt();
		String name = json.findPath("name").textValue();
		
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		//return product;
		//return ok(product);
		return ok(Json.toJson(product));
	}
	
	public  Result get(Long id){
		System.out.println("Inside product controller get id:"  + id);
		return ok("product get id : " + id);
		
	}
	
	public  Result getJson(Long id){
		System.out.println("Inside product controller get json id:"  + id);
		Product product = new Product();
		//product.setId(33L);
		product.setName("Mango");
		//JsonNode json = Json.toJson(product);
		//Result jsonResult = ok(json);
 ;
		
		return ok("product get json id : " + id);
	}
	
	public  Result update(){
		System.out.println("Inside product controller update");
		return ok("product update");
	}
	
	public Result mongo(){
		System.out.println("Inside play productcontroller mongo action");
		Friend one = null;
		try {
			DB db = new MongoClient().getDB("play");
			
			Jongo jongo = new Jongo(db);
			MongoCollection friends = jongo.getCollection("friends");
			//MongoCursor mc;
			//MongoCursor<Friend> all = friends.find("{name: 'Joe'}").as(Friend.class);
			one = friends.findOne("{name: 'Joe'}").as(Friend.class);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return ok("test mongo");
		return ok(Json.toJson(one));
	}
}
