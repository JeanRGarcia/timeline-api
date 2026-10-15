package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/timeline-items")
public class TimelineItemController {

    private final TimelineItemService service;

    public TimelineItemController(TimelineItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<TimelineItemResponse> findAll() {
        return service.findAll();
    }
}