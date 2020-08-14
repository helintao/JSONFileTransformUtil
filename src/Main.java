import lines_to_groups.LinesToGroups;
import util.FileUtil;

public class Main {
    public static void main(String[] args) {
        String fileName = "E:\\IdeaProjects\\JSONFileTransformUtil\\json\\lines.json";
        String lineJson= FileUtil.getJson(fileName);
        LinesToGroups.executeLinesToGroups(lineJson);
    }
}
