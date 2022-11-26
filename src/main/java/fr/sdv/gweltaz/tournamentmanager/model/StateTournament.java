package fr.sdv.gweltaz.tournamentmanager.model;

public enum StateTournament {
    PLANNED("planned"),
    INPROGRESS("in progress"),
    ENDED("ended") ;
    private String state;

    private StateTournament(String _state){
        this.state = _state;
    }

    public String getState() {
        return this.state;
    }
}