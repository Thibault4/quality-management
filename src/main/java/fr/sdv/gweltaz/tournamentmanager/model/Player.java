package fr.sdv.gweltaz.tournamentmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "player")
public class Player
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String firstName;
    private Date birthDate;
    private String postalCode;
    private String city;


    @ManyToMany(mappedBy = "players")
    private List<Team> teams;

    public Integer getNumberOfTournamentsRegisteredIn()
    {
        return teams != null ? teams.stream()
                .map((team) -> team.getTournaments() != null ? team.getTournaments().size() : 0)
                .reduce(0, Integer::sum) : 0;
    }

    public Integer getNumberOfTournamentsWon()
    {
        return this.teams != null ? this.teams.stream()
                .map((team) -> team.getTournamentsWon() != null ? team.getTournamentsWon().size() : 0)
                .reduce(0, Integer::sum) : 0;
    }

    public Long countTournaments(StateTournament state)
    {
        return this.teams != null ? this.teams.stream().map((team) -> team.countTournaments(state)).reduce(0L, Long::sum) : 0;

    }

    public Long getNumberOfTournamentsPlanned()
    {
        return this.countTournaments(StateTournament.PLANNED);
    }

    public Long getNumberOfTournamentsPlayed()
    {
        return this.countTournaments(StateTournament.ENDED);
    }

    public Long getNumberOfTournamentsCurrentlyIn()
    {
        return this.countTournaments(StateTournament.INPROGRESS);
    }
}