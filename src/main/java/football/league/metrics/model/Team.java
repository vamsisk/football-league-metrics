package football.league.metrics.model;

public class Team {

  private int id;
  private String name;

  public Team() {
  }

  public Team(Integer teamId, String teamName) {
    this.id = teamId;
    this.name = teamName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
