package dev.jeanrgarcia.timeline_api.timeline;

import java.time.LocalDate;
import java.util.UUID;

public record TimelineItemResponse(
        UUID id,
        TimelineItemType type,
        String title,
        String subtitle,
        String description,
        String location,
        String imageUrl,
        LocalDate startDate,
        LocalDate endDate,
        int sortOrder
) {

    public static TimelineItemResponse from(TimelineItem item) {
        return new TimelineItemResponse(
                item.getId(),
                item.getType(),
                item.getTitle(),
                item.getSubtitle(),
                item.getDescription(),
                item.getLocation(),
                item.getImageUrl(),
                item.getStartDate(),
                item.getEndDate(),
                item.getSortOrder()
        );
    }
}