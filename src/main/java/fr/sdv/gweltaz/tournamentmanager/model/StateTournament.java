package fr.sdv.gweltaz.tournamentmanager.model;

public enum StateTournament
{
    PLANNED("planned"),
    INPROGRESS("in progress"),
    ENDED("ended");
    private final String state;

    StateTournament(String _state)
    {
        this.state = _state;
    }

    public String getState()
    {
        return this.state;
    }
}