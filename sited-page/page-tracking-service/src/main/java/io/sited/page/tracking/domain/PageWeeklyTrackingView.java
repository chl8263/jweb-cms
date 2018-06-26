package io.sited.page.tracking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author chi
 */
@Entity
public class PageWeeklyTrackingView {
    @Column(name = "total")
    public Integer total;
    @Column(name = "timestamp")
    public String timestamp;

    public PageWeeklyTrackingView(Long total, String timestamp) {
        this.total = total.intValue();
        this.timestamp = timestamp;
    }
}
