package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TimelineItemNotFoundException extends RuntimeException {

    public TimelineItemNotFoundException(UUID id) {
        super("Timeline item not found: " + id);
    }
}