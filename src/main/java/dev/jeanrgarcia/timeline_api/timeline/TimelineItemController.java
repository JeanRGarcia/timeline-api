package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public TimelineItemResponse findById(@PathVariable UUID id) {
        return service.findById(id);
    }
}