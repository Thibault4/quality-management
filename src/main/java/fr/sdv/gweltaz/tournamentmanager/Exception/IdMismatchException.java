package fr.sdv.gweltaz.tournamentmanager.Exception;

public class IdMismatchException extends RuntimeException {
    public IdMismatchException(Long pathId, Long bodyId) {
        super("The request body's id ["+bodyId+"] and the path's id ["+pathId+"] do not match");
    }
}
