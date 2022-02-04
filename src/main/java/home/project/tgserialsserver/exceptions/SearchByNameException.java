package home.project.tgserialsserver.exceptions;

public class SearchByNameException extends RuntimeException {
    private SearchByNameException(String message) {
        super(message);
    }

    public static SearchByNameException filmNotFound() {
        return new SearchByNameException("Film didn't find.");
    }

    public static SearchByNameException requestError() {
        return new SearchByNameException("Response code isn't 200 (OK).");
    }

    public static SearchByNameException bodyIsNull() {
        return new SearchByNameException("Request body is null");
    }


}
