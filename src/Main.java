import util.FileUtil;
import util.TransformUtil;
import util.Values;

public class Main {
    public static void main(String[] args) {
        String lineJson = FileUtil.getJson(Values.LINE_NAME);
        TransformUtil.executeLinesToGroups(lineJson);
        String towersJson = FileUtil.getJson(Values.TOWERS_NAME);
        TransformUtil.executeTowersToTargets(towersJson);
        String missionTowersJson = FileUtil.getJson(Values.MISSION_TOWERS_NAME);
        TransformUtil.executeMissionTowersToCollectionInfo(missionTowersJson);
    }
}
