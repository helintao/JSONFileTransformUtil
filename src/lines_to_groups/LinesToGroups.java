package lines_to_groups;


import bean.Line;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import util.FileUtil;

import java.util.HashMap;
import java.util.List;

public class LinesToGroups {
    public static String executeLinesToGroups(String json) {
        String fileName = "E:\\IdeaProjects\\JSONFileTransformUtil\\json\\groups.json";
        Gson gson = new Gson();
        if (json != null && !json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("activeDataList");
            List<Line> lines = gson.fromJson(jsonArray.toString(), new TypeToken<List<Line>>() {
            }.getType());
            if (lines != null && lines.size() > 0) {
                System.out.println("lines 转换 list 成功");
            }
            JSONObject result = new JSONObject();
            result.put("activeDataList", lines);
            FileUtil.write(fileName, result.toString());
            System.out.println("lines.json 转换 groups.json 成功");
        }
        return null;
    }
}
