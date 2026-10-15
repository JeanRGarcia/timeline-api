package dev.jeanrgarcia.timeline_api.timeline;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateTimelineItemRequest(
        @NotNull TimelineItemType type,
        @NotBlank @Size(max = 200) String title,
        @Size(max = 200) String subtitle,
        String description,
        @Size(max = 200) String location,
        @Size(max = 500) String imageUrl,
        @NotNull LocalDate startDate,
        LocalDate endDate
) {

    @AssertTrue(message = "endDate must not be before startDate")
    boolean isEndDateValid() {
        return endDate == null || startDate == null || !endDate.isBefore(startDate);
    }
}