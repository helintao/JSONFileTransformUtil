package bean.targets;

public class Targets {
    private TargetsIdVersion id_version;
    private String type;
    private TargetsInfo info;

    public TargetsIdVersion getId_version() {
        return id_version;
    }

    public void setId_version(TargetsIdVersion id_version) {
        this.id_version = id_version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TargetsInfo getInfo() {
        return info;
    }

    public void setInfo(TargetsInfo info) {
        this.info = info;
    }

}
