package fr.emse.IA.IA_coach_sportif.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception used to signal that a user is not allowed to access a resource. Translated to a HTTP 403 status.
 * @author JB Nizet
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
}
