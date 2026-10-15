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

    @Transactional
    public TimelineItemResponse create(CreateTimelineItemRequest request) {
        TimelineItem item = new TimelineItem(request.type(), request.title(), request.startDate());
        item.setSubtitle(request.subtitle());
        item.setDescription(request.description());
        item.setLocation(request.location());
        item.setImageUrl(request.imageUrl());
        item.setEndDate(request.endDate());
        item.setSortOrder(nextSortOrder());
        return TimelineItemResponse.from(repository.save(item));
    }

    private int nextSortOrder() {
        return repository.findFirstByOrderBySortOrderDesc()
                .map(last -> last.getSortOrder() + 1)
                .orElse(0);
    }
}