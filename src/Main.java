import util.FileUtil;
import util.TransformUtil;

public class Main {
    public static void main(String[] args) {
        String lineName = "E:\\IdeaProjects\\JSONFileTransformUtil\\json\\lines.json";
        String towersName = "E:\\IdeaProjects\\JSONFileTransformUtil\\json\\towers.json";
        String missionTowersName = "E:\\IdeaProjects\\JSONFileTransformUtil\\json\\missionTowers.json";
//        String lineJson = FileUtil.getJson(lineName);
//        TransformUtil.executeLinesToGroups(lineJson);
//        String towersJson = FileUtil.getJson(towersName);
//        TransformUtil.executeTowersToTargets(towersJson);
        String missionTowersJson = FileUtil.getJson(missionTowersName);
        TransformUtil.executeMissionTowersToCollectionInfo(missionTowersJson);
    }
}
