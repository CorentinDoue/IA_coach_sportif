package fr.emse.IA.IA_coach_sportif.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception sent when a login problem occurs. Translated to a HTTP 401 status code.
 * @author JB Nizet
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {}