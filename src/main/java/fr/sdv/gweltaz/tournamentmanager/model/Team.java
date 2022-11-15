package fr.sdv.gweltaz.tournamentmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "team_players")
    private List<Player> players;

    @ManyToMany
    @JoinTable(name = "team_tournaments")
    private List<Tournament> tournaments;

    @OneToMany(mappedBy = "winner")
    private List<Tournament> tournamentsWon;


}