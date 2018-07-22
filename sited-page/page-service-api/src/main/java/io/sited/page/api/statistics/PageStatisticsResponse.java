package io.sited.page.api.statistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.OffsetDateTime;

/**
 * @author chi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PageStatisticsResponse {
    @XmlElement(name = "id")
    public String id;
    @XmlElement(name = "categoryId")
    public String categoryId;
    @XmlElement(name = "totalVisited")
    public Integer totalVisited;
    @XmlElement(name = "totalDailyVisited")
    public Integer totalDailyVisited;
    @XmlElement(name = "totalWeeklyVisited")
    public Integer totalWeeklyVisited;
    @XmlElement(name = "totalMonthlyVisited")
    public Integer totalMonthlyVisited;
    @XmlElement(name = "totalCommented")
    public Integer totalCommented;
    @XmlElement(name = "updatedTime")
    public OffsetDateTime updatedTime;
    @XmlElement(name = "updatedBy")
    public String updatedBy;
    @XmlElement(name = "createdTime")
    public OffsetDateTime createdTime;
    @XmlElement(name = "createdBy")
    public String createdBy;
}
