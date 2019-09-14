package football.league.metrics.model;

import java.util.Optional;

public class StandingsRequest {

  private Integer leagueId;

  private Optional<String> countryName;

  private Optional<Integer> teamId;

  public StandingsRequest(
      Integer leagueId, Optional<String> countryName, Optional<Integer> teamId) {
    this.leagueId = leagueId;
    this.countryName = countryName;
    this.teamId = teamId;
  }

  public Integer getLeagueId() {
    return leagueId;
  }

  public Optional<String> getCountryName() {
    return countryName;
  }

  public Optional<Integer> getTeamId() {
    return teamId;
  }
}
