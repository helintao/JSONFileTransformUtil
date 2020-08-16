package bean.collection;

import java.util.List;

public class CollectionBean {
    public String id;
    public String targetId;
    public double distanceInM;
    public double durationInS;
    public double maxAltInM;
    public long startTimestamp;
    public boolean isDeserted=false;
    public WayPoint waypoint;
    public List<Images> images;
    public String type="visible";
    public long createdAt;
    public String createdBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public double getDistanceInM() {
        return distanceInM;
    }

    public void setDistanceInM(double distanceInM) {
        this.distanceInM = distanceInM;
    }

    public double getDurationInS() {
        return durationInS;
    }

    public void setDurationInS(double durationInS) {
        this.durationInS = durationInS;
    }

    public double getMaxAltInM() {
        return maxAltInM;
    }

    public void setMaxAltInM(double maxAltInM) {
        this.maxAltInM = maxAltInM;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public boolean isDeserted() {
        return isDeserted;
    }

    public void setDeserted(boolean deserted) {
        isDeserted = deserted;
    }

    public WayPoint getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(WayPoint waypoint) {
        this.waypoint = waypoint;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
