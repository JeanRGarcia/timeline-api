package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class TimelineItemService {

    private final TimelineItemRepository repository;

    public TimelineItemService(TimelineItemRepository repository) {
        this.repository = repository;
    }

    public List<TimelineItemResponse> findAll() {
        return repository.findAllByOrderBySortOrderAscStartDateAsc().stream()
                .map(TimelineItemResponse::from)
                .toList();
    }

    public TimelineItemResponse findById(UUID id) {
        return repository.findById(id)
                .map(TimelineItemResponse::from)
                .orElseThrow(() -> new TimelineItemNotFoundException(id));
    }
}