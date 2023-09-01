package RenderFirst.com;

import RenderFirst.com.entity.User;
import RenderFirst.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RenderFirstApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RenderFirstApplication.class, args);
	}
	@GetMapping("count-user")
	public String getCountUser(){
		long numberUsers = userRepository.count();
		return "Number of users = " + numberUsers;
	}

	@GetMapping("add-users")
	public String addUser(){
		User user = new User();
		user.setFirstName("Mausam");
		user.setLastName("Rai");
		userRepository.save(user);
		return "user has been added successfully";
	}

}
