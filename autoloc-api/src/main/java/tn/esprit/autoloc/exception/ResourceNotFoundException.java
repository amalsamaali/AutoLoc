package tn.esprit.autoloc.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " non trouvé avec l'identifiant : " + id);
    }
}
