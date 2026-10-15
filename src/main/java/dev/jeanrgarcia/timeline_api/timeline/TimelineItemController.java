package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<TimelineItemResponse> create(@Valid @RequestBody CreateTimelineItemRequest request) {
        TimelineItemResponse created = service.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}