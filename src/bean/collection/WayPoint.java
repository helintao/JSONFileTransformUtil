package bean.collection;

import java.util.List;

public class WayPoint {
    public StartAndEndPosition startPosition;
    public StartAndEndPosition endPosition;
    public List<Gps> gpsList;
    public String version="v2";

    public StartAndEndPosition getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(StartAndEndPosition startPosition) {
        this.startPosition = startPosition;
    }

    public StartAndEndPosition getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(StartAndEndPosition endPosition) {
        this.endPosition = endPosition;
    }

    public List<Gps> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<Gps> gpsList) {
        this.gpsList = gpsList;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
