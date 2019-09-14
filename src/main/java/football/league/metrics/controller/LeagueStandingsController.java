package football.league.metrics.controller;

import football.league.metrics.model.LeagueStanding;
import football.league.metrics.model.StandingsRequest;
import football.league.metrics.service.LeagueService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;
import java.util.Collection;
import java.util.Optional;

/**
 * A controller class to expose various end points for accessing league standings data.
 */
@Controller("/league/standing")
public class LeagueStandingsController {

  private LeagueService leagueService;

  public LeagueStandingsController(LeagueService leagueService) {
    this.leagueService = leagueService;
  }

  /**
   * @param leagueId    League ID for which standings have to retrieved.
   * @param countryName To filter the standings by given country name
   * @param teamId      to filter the standings by given team ID.
   * @return a collection of standings for the given league id filtered by country name and team ID.
   */
  @Get("/league/{leagueId}{?countryName,teamId}")
  public Collection<LeagueStanding> getStandingsByCountry(
      @PathVariable Integer leagueId,
      @QueryValue Optional<String> countryName,
      @QueryValue Optional<Integer> teamId
  ) {

    return leagueService
        .getStandingsByLeagueCountryAndTeam(new StandingsRequest(leagueId, countryName, teamId));
  }

}
