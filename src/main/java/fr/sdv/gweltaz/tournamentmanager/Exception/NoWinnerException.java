package fr.sdv.gweltaz.tournamentmanager.Exception;

public class NoWinnerException extends RuntimeException{
    public NoWinnerException() {
        super("No winner specified for a tournament that has ended");
    }
}
