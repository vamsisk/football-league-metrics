package football.league.metrics.service;

import football.league.metrics.model.LeagueStanding;
import football.league.metrics.model.StandingEntity;
import football.league.metrics.model.StandingsRequest;
import football.league.metrics.repository.LeagueRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Singleton;

/**
 * A business service to provide operations related to league standings.
 */
@Singleton
public class LeagueService {

  private LeagueRepository leagueRepository;


  public LeagueService(LeagueRepository leagueRepository) {
    this.leagueRepository = leagueRepository;
  }

  /**
   * A function to retrieve  standings for the given request parameters.
   *
   * @param standingsRequest a composite request object containing the various request parameters
   *                         including league ID, team ID and country name.
   * @return a collection of standings complying with the given request parameters.
   */
  public Collection<LeagueStanding> getStandingsByLeagueCountryAndTeam(
      StandingsRequest standingsRequest) {
    List<StandingEntity> standings = leagueRepository.getStandings(standingsRequest.getLeagueId());

    return standings
        .stream()
        .filter(standingEntity -> !standingsRequest.getTeamId().isPresent()
            || standingEntity.getTeamId().intValue() ==
            standingsRequest.getTeamId().get().intValue())
        .filter(standingEntity -> !standingsRequest.getCountryName().isPresent()
            || standingEntity.getCountryName()
            .equalsIgnoreCase(standingsRequest.getCountryName().get()))
        .map(StandingEntity::toModel)
        .collect(Collectors.toList());
  }
}
