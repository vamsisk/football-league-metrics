package football.league.metrics.service;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import football.league.metrics.model.LeagueStanding;
import football.league.metrics.model.StandingEntity;
import football.league.metrics.model.StandingsRequest;
import football.league.metrics.repository.LeagueRepository;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

@MicronautTest
class LeagueServiceTest {

  @Inject
  LeagueService leagueService;

  @Inject
  LeagueRepository leagueRepository;

  @Test
  void getStandingsByLeagueCountryAndTeam_for_a_given_league_without_filter() {

    doReturn(getMockStandingEntities())
        .when(leagueRepository)
        .getStandings(ArgumentMatchers.any());

    Collection<LeagueStanding> standings = leagueService
        .getStandingsByLeagueCountryAndTeam(new StandingsRequest(149, empty(), empty()));

    assertNotNull(standings);
    assertEquals(2, standings.size());

  }

  @Test
  void getStandingsByLeagueCountryAndTeam_for_a_given_league_with_team_filter() {

    doReturn(getMockStandingEntities())
        .when(leagueRepository)
        .getStandings(ArgumentMatchers.any());

    Collection<LeagueStanding> standings = leagueService
        .getStandingsByLeagueCountryAndTeam(new StandingsRequest(149, empty(), of(592)));

    assertNotNull(standings);
    assertEquals(1, standings.size());

  }

  @MockBean(LeagueRepository.class)
  LeagueRepository leagueRepository() {
    return Mockito.mock(LeagueRepository.class);
  }

  private List<StandingEntity> getMockStandingEntities() {
    List<StandingEntity> standings = new ArrayList<>();
    StandingEntity standingEntity1 = new StandingEntity();
    standingEntity1.setLeagueId(149);
    standingEntity1.setCountryName("England");
    standingEntity1.setTeamId(592);
    standingEntity1.setOverallLeaguePosition(8);

    standings.add(standingEntity1);

    StandingEntity standingEntity2 = new StandingEntity();
    standingEntity2.setLeagueId(149);
    standingEntity2.setCountryName("England");
    standingEntity2.setTeamId(171);
    standingEntity2.setOverallLeaguePosition(12);

    standings.add(standingEntity2);

    return standings;
  }

}