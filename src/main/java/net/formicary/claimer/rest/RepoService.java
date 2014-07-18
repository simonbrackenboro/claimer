package net.formicary.claimer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
public class RepoService {
  @GET()
  @Path("/repositories")
  @Produces(MediaType.APPLICATION_JSON)
  public String[] getRepositories() {
    return new String[]{"DSWP1", "DSWP2", "PSWP1"};
  }

  @GET()
  @Path("/repositories/{repository}")
  @Produces(MediaType.APPLICATION_JSON)
  public String[] getBranches(@PathParam("repository") String repository) {
    if (repository.equals("DSWP1"))
      return new String[]{"master", "topic_1", "topic2"};
    else if (repository.equals("DSWP2"))
      return new String[]{"master", "branch_1", "branch2", "topic2"};
    return new String[]{"master"};
  }

  @GET()
  @Path("/repositories/{repository}/{branch}")
  @Produces(MediaType.APPLICATION_JSON)
  public String[] getBranches(@PathParam("repository") String repository, @PathParam("branch") String branch) {
    if (repository.equals("DSWP1") && branch.equals("master"))
      return new String[]{"18563", "544987", "545454"};
    else if (repository.equals("DSWP2"))
      return new String[]{"654654654", "654654654", "545465454"};
    return new String[]{"2544"};
  }
}

