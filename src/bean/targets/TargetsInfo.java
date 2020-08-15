package bean.targets;

public class TargetsInfo {
    public Integer volLevelsInKv = null;
    public GPS gps;
    public Integer towerHeight = 100;
    public Integer absoluteAltitudeInM = 140;
    public String identifier;
    public String createdBy;
    public String category;
    public Long createdAt;
    public boolean isDeserted = false;
    public String lineId;
    public String groupId;

    public Integer getVolLevelsInKv() {
        return volLevelsInKv;
    }

    public void setVolLevelsInKv(Integer volLevelsInKv) {
        this.volLevelsInKv = volLevelsInKv;
    }

    public GPS getGps() {
        return gps;
    }

    public void setGps(GPS gps) {
        this.gps = gps;
    }

    public Integer getTowerHeight() {
        return towerHeight;
    }

    public void setTowerHeight(Integer towerHeight) {
        this.towerHeight = towerHeight;
    }

    public Integer getAbsoluteAltitudeInM() {
        return absoluteAltitudeInM;
    }

    public void setAbsoluteAltitudeInM(Integer absoluteAltitudeInM) {
        this.absoluteAltitudeInM = absoluteAltitudeInM;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeserted() {
        return isDeserted;
    }

    public void setDeserted(boolean deserted) {
        isDeserted = deserted;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

}
