package ismail.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProjectIdExceptionResponse {

    private String projectIdentifier;
    private final HttpStatus httpStatus;
    private final int status;

    public ProjectIdExceptionResponse(String projectIdentifier, HttpStatus httpStatus, int status) {
        this.projectIdentifier = projectIdentifier;
        this.httpStatus = httpStatus;
        this.status = status;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatus() {
        return status;
    }
}
