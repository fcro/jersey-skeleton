package fr.youngagain;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class Login {

	@GET
	@Path("/{login}")
	public User connect(@PathParam("login") String login) {
		User user = new User(login, "pass");
		return user;
	}
}
