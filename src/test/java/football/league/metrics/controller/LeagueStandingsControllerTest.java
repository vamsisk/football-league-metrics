package football.league.metrics.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import football.league.metrics.model.Country;
import football.league.metrics.model.League;
import football.league.metrics.model.LeagueStanding;
import football.league.metrics.model.Team;
import football.league.metrics.service.LeagueService;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@MicronautTest
public class LeagueStandingsControllerTest {

  @Inject
  @Client("/")
  RxHttpClient client;

  @Inject
  LeagueService leagueService;


  @MockBean(LeagueService.class)
  LeagueService leagueService() {
    return mock(LeagueService.class);
  }

  @Test
  void testComputeNumToSquare() {

    Mockito.when(leagueService.getStandingsByLeagueCountryAndTeam(any()))
        .thenReturn(getMockStandings());

    final Collection<LeagueStanding> result = client
        .toBlocking()
        .retrieve(HttpRequest.GET("/league/standing/league/149"),
            Argument.listOf(LeagueStanding.class));

    assertEquals(
        2,
        result.size()
    );
    Mockito.verify(leagueService).getStandingsByLeagueCountryAndTeam(any());
  }

  private List<LeagueStanding> getMockStandings() {
    List<LeagueStanding> standings = new ArrayList<>();

    LeagueStanding leagueStanding1 = new LeagueStanding(
        new League(149, "League 149"),
        new Country("England"),
        new Team(592, "Team 592"),
        8
    );

    standings.add(leagueStanding1);

    LeagueStanding leagueStanding2 = new LeagueStanding(
        new League(149, "League 149"),
        new Country("England"),
        new Team(171, "Team 171"),
        12
    );

    standings.add(leagueStanding2);

    return standings;
  }

}