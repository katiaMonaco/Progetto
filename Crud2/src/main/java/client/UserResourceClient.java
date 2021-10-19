package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;

public class UserResourceClient {

    public static void main(String[] args) {
        //getUsers();
        getUser();
       // createUser();
       // updateUser();
       //deleteUser();
    }

    private static void getUsers() {
        Client client = ClientBuilder.newClient();

        String entity = client.target("http://localhost:8080/Crud2/api").path("users")
        .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);

        System.out.println(entity);
    }

    private static void getUser() {
        Client client = ClientBuilder.newClient();

        String entity = client.target("http://localhost:8080/Crud2/api").path("users").path("user/100")
       .request(MediaType.APPLICATION_JSON).header("some-header", "true").get(String.class);

        System.out.println(entity);
    }
 
    private static void createUser() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/Crud2/api").path("users");

        User user = new User();
        user.setId(1);
        user.setName("Ramesh");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }

    private static void updateUser() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/Crud2/api").path("users")
        .path("user/1");

        User user = new User();
        user.setId(1);
        user.setName("Ramesh");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));

        String userJson = response.readEntity(String.class);

        System.out.println(response.getStatus());
        System.out.println(userJson);
    }

    private static void deleteUser() {

         Client client = ClientBuilder.newClient();
         WebTarget webTarget = client.target("http://localhost:8080/Crud2/api").path("users")
        .path("user/100");

         User user = new User();
         user.setId(1);
         user.setName("Ramesh");

         Invocation.Builder invocationBuilder = webTarget.request();
         Response response = invocationBuilder.delete();

         System.out.println(response.getStatus());
         System.out.println(response.readEntity(String.class));
    }
}