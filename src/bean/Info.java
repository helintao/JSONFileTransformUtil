package bean;

public class Info {
    /**
     * "name":"220KV池塘",
     * "volLevelInKV":220,
     * "managementTeam":"班组一",
     * "createdAt":1589766115976,
     * "createdBy":"dyadmin",
     * "isDeserted":false
     */
    public String name;
    public int volLevelInKV;
    public String managementTeam;
    public long createdAt;
    public String createdBy;
    public boolean isDeserted = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolLevelInKV() {
        return volLevelInKV;
    }

    public void setVolLevelInKV(int volLevelInKV) {
        this.volLevelInKV = volLevelInKV;
    }

    public String getManagementTeam() {
        return managementTeam;
    }

    public void setManagementTeam(String managementTeam) {
        this.managementTeam = managementTeam;
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

    public boolean isDeserted() {
        return isDeserted;
    }

    public void setDeserted(boolean deserted) {
        isDeserted = deserted;
    }
}
