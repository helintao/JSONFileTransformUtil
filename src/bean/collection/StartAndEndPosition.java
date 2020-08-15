package bean.collection;

public class StartAndEndPosition {
    public double absoluteAltitude;
    public double absoluteBottomAltitude;
    public double absoluteTopAltitude;
    public double lat;
    public double lon;
    public double yaw;
    public double gimbalPitch;

    public double getAbsoluteAltitude() {
        return absoluteAltitude;
    }

    public void setAbsoluteAltitude(double absoluteAltitude) {
        this.absoluteAltitude = absoluteAltitude;
    }

    public double getAbsoluteBottomAltitude() {
        return absoluteBottomAltitude;
    }

    public void setAbsoluteBottomAltitude(double absoluteBottomAltitude) {
        this.absoluteBottomAltitude = absoluteBottomAltitude;
    }

    public double getAbsoluteTopAltitude() {
        return absoluteTopAltitude;
    }

    public void setAbsoluteTopAltitude(double absoluteTopAltitude) {
        this.absoluteTopAltitude = absoluteTopAltitude;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getYaw() {
        return yaw;
    }

    public void setYaw(double yaw) {
        this.yaw = yaw;
    }

    public double getGimbalPitch() {
        return gimbalPitch;
    }

    public void setGimbalPitch(double gimbalPitch) {
        this.gimbalPitch = gimbalPitch;
    }
}
