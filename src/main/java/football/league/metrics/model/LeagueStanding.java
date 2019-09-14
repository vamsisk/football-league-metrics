package football.league.metrics.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class LeagueStanding {

  private League league;

  private Country country;

  private Team team;

  private int leaguePosition;

  @JsonCreator
  public LeagueStanding() {
  }

  public LeagueStanding(League league, Country country, Team team, int leaguePosition) {
    this.country = country;
    this.league = league;
    this.team = team;
    this.leaguePosition = leaguePosition;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public League getLeague() {
    return league;
  }

  public void setLeague(League league) {
    this.league = league;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public int getLeaguePosition() {
    return leaguePosition;
  }

  public void setLeaguePosition(int leaguePosition) {
    this.leaguePosition = leaguePosition;
  }
}
