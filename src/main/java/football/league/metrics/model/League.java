package football.league.metrics.model;

public class League {

  private int id;
  private String name;

  public League() {
  }

  public League(Integer leagueId, String leagueName) {
    this.id = leagueId;
    this.name = leagueName;
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
