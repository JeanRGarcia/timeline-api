package dev.jeanrgarcia.timeline_api.timeline;

import java.util.UUID;

public class TimelineItemNotFoundException extends RuntimeException {

    public TimelineItemNotFoundException(UUID id) {
        super("Timeline item not found: " + id);
    }
}