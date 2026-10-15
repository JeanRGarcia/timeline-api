package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}