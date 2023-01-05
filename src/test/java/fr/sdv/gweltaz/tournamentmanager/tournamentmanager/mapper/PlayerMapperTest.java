package fr.sdv.gweltaz.tournamentmanager.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.DTO.*;
import fr.sdv.gweltaz.tournamentmanager.model.Player;
import fr.sdv.gweltaz.tournamentmanager.model.StateTournament;
import fr.sdv.gweltaz.tournamentmanager.model.Team;
import fr.sdv.gweltaz.tournamentmanager.model.Tournament;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Testing Mapper for Player entity")
public class PlayerMapperTest extends BaseMapperTest
{

    @Test
    @DisplayName("Mapping from and to PlayerIdDTO")
    public void testPlayerIdDTOMapping()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        PlayerIdDTO dto = this.playerMapper.playerToPlayerIdDTO(player);

        Assertions.assertEquals(player.getId(), dto.id());

        PlayerIdDTO dto1 = new PlayerIdDTO(1L);
        Player player1 = this.playerMapper.playerIdDTOToPlayer(dto1);

        Assertions.assertEquals(dto1.id(), player1.getId());
    }

    @Test
    @DisplayName("Mapping from Player to PlayerNoRelationsDTO")
    public void testPlayerToPlayerNoRelationsDTO()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        PlayerNoRelationsDTO dto = this.playerMapper.playerToPlayerNoRelationsDTO(player);

        Assertions.assertEquals(player.getId(), dto.id());
        Assertions.assertEquals(player.getAddress(), dto.address());
        Assertions.assertEquals(player.getName(), dto.name());
    }

    @Test
    @DisplayName("Mapping from Player to PlayerWithStatsDTO without any history")
    public void testPlayerToPlayerWithStatsDTOWithoutAnyHistory()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");
        player.setTeams(new ArrayList<>());

        PlayerWithStatsDTO dto = this.playerMapper.playerToPlayerWithStatsDTO(player);

        Assertions.assertEquals(player.getId(), dto.id());
        Assertions.assertEquals(player.getAddress(), dto.address());
        Assertions.assertEquals(player.getName(), dto.name());

        Assertions.assertEquals(0, dto.teamsPlayedIn());
        Assertions.assertEquals(0, dto.tournamentsWon());
        Assertions.assertEquals(0, dto.tournamentsPlanned());
        Assertions.assertEquals(0, dto.tournamentsCurrentlyIn());
        Assertions.assertEquals(0, dto.tournamentsRegisteredIn());
        Assertions.assertEquals(0, dto.tournamentsPlayed());
    }

    @Test
    @DisplayName("Mapping from Player to PlayerWithStatsDTO without tournament history")
    public void testPlayerToPlayerWithStatsDTOWithoutTournamentHistory()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setPlayers(List.of(player));
        team2.setPlayers(List.of(player));
        team3.setPlayers(List.of(player));
        team4.setPlayers(List.of(player));

        player.setTeams(List.of(team1, team2, team3, team4));

        PlayerWithStatsDTO dto = this.playerMapper.playerToPlayerWithStatsDTO(player);

        Assertions.assertEquals(player.getId(), dto.id());
        Assertions.assertEquals(player.getAddress(), dto.address());
        Assertions.assertEquals(player.getName(), dto.name());

        Assertions.assertEquals(4, dto.teamsPlayedIn());
        Assertions.assertEquals(0, dto.tournamentsWon());
        Assertions.assertEquals(0, dto.tournamentsPlanned());
        Assertions.assertEquals(0, dto.tournamentsCurrentlyIn());
        Assertions.assertEquals(0, dto.tournamentsRegisteredIn());
        Assertions.assertEquals(0, dto.tournamentsPlayed());
    }

    @Test
    @DisplayName("Mapping from Player to PlayerWithStatsDTO")
    public void testPlayerToPlayerWithStatsDTO()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setPlayers(List.of(player));
        team2.setPlayers(List.of(player));
        team3.setPlayers(List.of(player));
        team4.setPlayers(List.of(player));

        Tournament t1 = new Tournament();
        Tournament t2 = new Tournament();
        Tournament t3 = new Tournament();
        Tournament t4 = new Tournament();
        Tournament t5 = new Tournament();
        Tournament t6 = new Tournament();
        Tournament t7 = new Tournament();
        Tournament t8 = new Tournament();
        Tournament t9 = new Tournament();
        Tournament t10 = new Tournament();
        Tournament t11 = new Tournament();
        Tournament t12 = new Tournament();

        t1.setState(StateTournament.ENDED);
        t2.setState(StateTournament.PLANNED);
        t3.setState(StateTournament.INPROGRESS);
        t4.setState(StateTournament.ENDED);
        t5.setState(StateTournament.PLANNED);
        t6.setState(StateTournament.INPROGRESS);
        t7.setState(StateTournament.ENDED);
        t8.setState(StateTournament.PLANNED);
        t9.setState(StateTournament.INPROGRESS);
        t10.setState(StateTournament.ENDED);
        t11.setState(StateTournament.PLANNED);
        t12.setState(StateTournament.INPROGRESS);

        team1.setTournaments(List.of(t1,t2,t3));
        team1.setTournamentsWon(List.of(t1));
        team2.setTournaments(List.of(t4,t5,t6));
        team2.setTournamentsWon(List.of(t4,t5));
        team3.setTournaments(List.of(t7,t8,t9));
        team3.setTournamentsWon(List.of(t7,t8,t9));
        team4.setTournaments(List.of(t10,t11,t12));

        player.setTeams(List.of(team1, team2, team3, team4));

        PlayerWithStatsDTO dto = this.playerMapper.playerToPlayerWithStatsDTO(player);

        Assertions.assertEquals(player.getId(), dto.id());
        Assertions.assertEquals(player.getAddress(), dto.address());
        Assertions.assertEquals(player.getName(), dto.name());

        Assertions.assertEquals(4, dto.teamsPlayedIn());
        Assertions.assertEquals(6, dto.tournamentsWon());
        Assertions.assertEquals(4, dto.tournamentsPlanned());
        Assertions.assertEquals(4, dto.tournamentsCurrentlyIn());
        Assertions.assertEquals(12, dto.tournamentsRegisteredIn());
        Assertions.assertEquals(4, dto.tournamentsPlayed());
    }

    @Test
    @DisplayName("Mapping from Player to PlayerWithTournamentsDTO")
    public void testPlayerToPlayerWithTournamentsDTO()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setPlayers(List.of(player));
        team2.setPlayers(List.of(player));
        team3.setPlayers(List.of(player));
        team4.setPlayers(List.of(player));

        Tournament t1 = new Tournament();
        Tournament t2 = new Tournament();
        Tournament t3 = new Tournament();
        Tournament t4 = new Tournament();
        Tournament t5 = new Tournament();
        Tournament t6 = new Tournament();
        Tournament t7 = new Tournament();
        Tournament t8 = new Tournament();
        Tournament t9 = new Tournament();
        Tournament t10 = new Tournament();
        Tournament t11 = new Tournament();
        Tournament t12 = new Tournament();

        t1.setState(StateTournament.ENDED);
        t2.setState(StateTournament.PLANNED);
        t3.setState(StateTournament.INPROGRESS);
        t4.setState(StateTournament.ENDED);
        t5.setState(StateTournament.PLANNED);
        t6.setState(StateTournament.INPROGRESS);
        t7.setState(StateTournament.ENDED);
        t8.setState(StateTournament.PLANNED);
        t9.setState(StateTournament.INPROGRESS);
        t10.setState(StateTournament.ENDED);
        t11.setState(StateTournament.PLANNED);
        t12.setState(StateTournament.INPROGRESS);

        team1.setTournaments(List.of(t1,t2,t3));
        team1.setTournamentsWon(List.of(t1));
        team2.setTournaments(List.of(t4,t5,t6));
        team2.setTournamentsWon(List.of(t4,t5));
        team3.setTournaments(List.of(t7,t8,t9));
        team3.setTournamentsWon(List.of(t7,t8,t9));
        team4.setTournaments(List.of(t10,t11,t12));

        player.setTeams(List.of(team1, team2, team3, team4));

        TeamWithTournamentsDTO team1Dto = this.teamMapper.teamToTeamWithTournamentsDTO(team1);
        TeamWithTournamentsDTO team2Dto = this.teamMapper.teamToTeamWithTournamentsDTO(team2);
        TeamWithTournamentsDTO team3Dto = this.teamMapper.teamToTeamWithTournamentsDTO(team3);
        TeamWithTournamentsDTO team4Dto = this.teamMapper.teamToTeamWithTournamentsDTO(team4);

        PlayerWithTournamentsDTO playerWithTournamentsDTO = this.playerMapper.playerToPlayerWithTournamentsDTO(player);
        Assertions.assertEquals(player.getId(), playerWithTournamentsDTO.id());
        Assertions.assertEquals(player.getAddress(), playerWithTournamentsDTO.address());
        Assertions.assertEquals(player.getName(), playerWithTournamentsDTO.name());

        Assertions.assertArrayEquals(
                Arrays.stream((new TeamWithTournamentsDTO[]{team1Dto, team2Dto, team3Dto, team4Dto})).toArray(),
                playerWithTournamentsDTO.teams().toArray()
        );
    }

    @Test
    @DisplayName("Mapping from Player to PlayerDTO")
    public void testPlayerToPlayerDTO()
    {
        Player player = new Player();
        player.setId(1L);
        player.setAddress("Test address");
        player.setName("Test player");

        Team team1 = new Team();
        Team team2 = new Team();
        Team team3 = new Team();
        Team team4 = new Team();

        team1.setPlayers(List.of(player));
        team2.setPlayers(List.of(player));
        team3.setPlayers(List.of(player));
        team4.setPlayers(List.of(player));

        Tournament t1 = new Tournament();
        Tournament t2 = new Tournament();
        Tournament t3 = new Tournament();
        Tournament t4 = new Tournament();
        Tournament t5 = new Tournament();
        Tournament t6 = new Tournament();
        Tournament t7 = new Tournament();
        Tournament t8 = new Tournament();
        Tournament t9 = new Tournament();
        Tournament t10 = new Tournament();
        Tournament t11 = new Tournament();
        Tournament t12 = new Tournament();

        t1.setState(StateTournament.ENDED);
        t2.setState(StateTournament.PLANNED);
        t3.setState(StateTournament.INPROGRESS);
        t4.setState(StateTournament.ENDED);
        t5.setState(StateTournament.PLANNED);
        t6.setState(StateTournament.INPROGRESS);
        t7.setState(StateTournament.ENDED);
        t8.setState(StateTournament.PLANNED);
        t9.setState(StateTournament.INPROGRESS);
        t10.setState(StateTournament.ENDED);
        t11.setState(StateTournament.PLANNED);
        t12.setState(StateTournament.INPROGRESS);

        team1.setTournaments(List.of(t1,t2,t3));
        team1.setTournamentsWon(List.of(t1));
        team2.setTournaments(List.of(t4,t5,t6));
        team2.setTournamentsWon(List.of(t4,t5));
        team3.setTournaments(List.of(t7,t8,t9));
        team3.setTournamentsWon(List.of(t7,t8,t9));
        team4.setTournaments(List.of(t10,t11,t12));

        player.setTeams(List.of(team1, team2, team3, team4));

        TeamNoRelationsDTO team1Dto = this.teamMapper.teamToTeamNoRelationsDTO(team1);
        TeamNoRelationsDTO team2Dto = this.teamMapper.teamToTeamNoRelationsDTO(team2);
        TeamNoRelationsDTO team3Dto = this.teamMapper.teamToTeamNoRelationsDTO(team3);
        TeamNoRelationsDTO team4Dto = this.teamMapper.teamToTeamNoRelationsDTO(team4);

        PlayerDTO playerDTO = this.playerMapper.playerToPlayerDTO(player);
        Assertions.assertEquals(player.getId(), playerDTO.id());
        Assertions.assertEquals(player.getAddress(), playerDTO.address());
        Assertions.assertEquals(player.getName(), playerDTO.name());

        Assertions.assertArrayEquals(
                Arrays.stream((new TeamNoRelationsDTO[]{team1Dto, team2Dto, team3Dto, team4Dto})).toArray(),
                playerDTO.teams().toArray()
        );
    }
}
