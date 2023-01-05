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
@Table(name = "tournament")
public class Tournament
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private StateTournament state;

    private Date date;

    @ManyToOne
    private Team winner;

    @ManyToMany(mappedBy = "tournaments")
    private List<Team> teams;

    public Integer getNumberOfPlayers()
    {
        return this.teams.stream().map((team -> team.getPlayers().size())).reduce(0, Integer::sum);
    }
}