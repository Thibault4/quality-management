package fr.sdv.gweltaz.tournamentmanager.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceType, Long id) {
        super(resourceType + " with id [" + id + "] not found");
    }
}
