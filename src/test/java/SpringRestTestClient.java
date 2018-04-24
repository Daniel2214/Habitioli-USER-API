
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;
 
import com.websystique.springmvc.model.User;
 
public class SpringRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/Spring4MVCCRUDRestService";
     
    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User("prueba", "prueba@prueba.com");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/signup/", user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    public static void main(String args[]){
       
        createUser();
        
    }
}