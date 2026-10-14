package dev.jeanrgarcia.timeline_api.timeline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TimelineItemRepository extends JpaRepository<TimelineItem, UUID> {

    List<TimelineItem> findAllByOrderBySortOrderAscStartDateAsc();
}