package fr.sdv.gweltaz.tournamentmanager.tournamentmanager.mapper;

import fr.sdv.gweltaz.tournamentmanager.mapper.PlayerMapper;
import fr.sdv.gweltaz.tournamentmanager.mapper.TeamMapper;
import fr.sdv.gweltaz.tournamentmanager.mapper.TournamentMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mapstruct.factory.Mappers;
import org.springframework.test.util.ReflectionTestUtils;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseMapperTest
{
    protected final PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);
    protected final TeamMapper teamMapper = Mappers.getMapper(TeamMapper.class);
    protected final TournamentMapper tournamentMapper = Mappers.getMapper(TournamentMapper.class);

    @BeforeAll
    public void beforeAll(){
        /*ReflectionTestUtils.setField(
                this.teamMapper,
                "tournamentMapper",
                Mappers.getMapper(TournamentMapper.class)
        );
        ReflectionTestUtils.setField(
                this.teamMapper,
                "playerMapper",
                Mappers.getMapper(PlayerMapper.class)
        );
        ReflectionTestUtils.setField(
                this.tournamentMapper,
                "teamMapper",
                Mappers.getMapper(TeamMapper.class)
        );
        ReflectionTestUtils.setField(
                this.tournamentMapper,
                "playerMapper",
                Mappers.getMapper(PlayerMapper.class)
        );
        ReflectionTestUtils.setField(
                this.playerMapper,
                "teamMapper",
                Mappers.getMapper(TeamMapper.class)
        );
        ReflectionTestUtils.setField(
                this.playerMapper,
                "tournamentMapper",
                Mappers.getMapper(TournamentMapper.class)
        );*/
    }
}
