CREATE TABLE timeline_item (
                               id          UUID PRIMARY KEY,
                               type        VARCHAR(20)  NOT NULL,
                               title       VARCHAR(200) NOT NULL,
                               subtitle    VARCHAR(200),
                               description TEXT,
                               location    VARCHAR(200),
                               image_url   VARCHAR(500),
                               start_date  DATE         NOT NULL,
                               end_date    DATE,
                               sort_order  INTEGER      NOT NULL DEFAULT 0,
                               created_at  TIMESTAMPTZ  NOT NULL DEFAULT now(),
                               updated_at  TIMESTAMPTZ  NOT NULL DEFAULT now(),

                               CONSTRAINT ck_timeline_item_type
                                   CHECK (type IN ('EXPERIENCE', 'EDUCATION', 'PROJECT', 'CERTIFICATION', 'OTHER'))
);

CREATE INDEX idx_timeline_item_start_date ON timeline_item (start_date);