package football.league.metrics.repository;

import static io.micronaut.core.type.Argument.listOf;

import football.league.metrics.model.StandingEntity;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import java.util.List;
import javax.inject.Inject;

/**
 * A repository to class to provide a various data access method to retrieve the league standing
 * data from apiv2.apifootball.com API provider.
 */
public class LeagueRepository {

  @Client(value = "${apifotball.url}")
  @Inject
  RxHttpClient httpClient;

  @Value("${apifotball.api-key}")
  private String apiKey;

  @Value("${apifotball.actions.get-standings}")
  private String getStandingsUri;

  /**
   * A method to retrive all the standings data based on the request parameters provided by the
   * service method.
   *
   * @param leagueId ID of the league for which standings have to be retrieved.
   * @return a collection of standings complying with the given league ID.
   */
  public List<StandingEntity> getStandings(Integer leagueId) {

    List<StandingEntity> entities = httpClient
        .retrieve(HttpRequest.GET(
            "/?action=" + getStandingsUri
                + "&league_id=" + leagueId
                + "&APIkey=" + apiKey),
            listOf(StandingEntity.class)
        )
        .blockingSingle();

    return entities;
  }
}
