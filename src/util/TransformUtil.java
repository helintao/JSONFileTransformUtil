package util;

import bean.collection.CollectionBean;
import bean.groups.Groups;
import bean.groups.GroupsInfo;
import bean.targets.Targets;
import bean.targets.TargetsIdVersion;
import bean.targets.TargetsInfo;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.*;

public class TransformUtil {
    public static HashMap<String, Targets> vpHashMap = new HashMap<>();
    public static List<Targets> vpList = new ArrayList<>();

    public static String executeLinesToGroups(String json) {
        Gson gson = new Gson();
        if (json != null && !json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("activeDataList");
            List<Groups> lines = gson.fromJson(jsonArray.toString(), new TypeToken<List<Groups>>() {
            }.getType());
            //获取visiblePassageway
            if (vpList.size()>0||!vpList.isEmpty()){
                vpList.clear();
            }
            for (int i = 0; i < lines.size(); i++) {
               Groups groups=lines.get(i);
                Targets vpTarget = new Targets();
                TargetsInfo vpTargetsInfo = new TargetsInfo();
                vpTargetsInfo.setGps(null);
                vpTargetsInfo.setTowerHeight(null);
                vpTargetsInfo.setAbsoluteAltitudeInM(null);
                vpTargetsInfo.setIdentifier("passageways");
                vpTargetsInfo.setGroupId(groups.getId());
                vpTargetsInfo.setCreatedBy("xp");
                vpTargetsInfo.setVolLevelsInKv(null);
                vpTargetsInfo.setCategory(null);
                vpTargetsInfo.setCreatedAt(groups.getInfo().createdAt);
                vpTargetsInfo.setDeserted(false);

                TargetsIdVersion targetsIdVersion = new TargetsIdVersion();
                targetsIdVersion.setId(groups.getId() + "_passageMock");
                targetsIdVersion.setVersion("v1");

                vpTarget.setId_version(targetsIdVersion);
                vpTarget.setInfo(vpTargetsInfo);
                vpList.add(vpTarget);
            }
            if (lines != null && lines.size() > 0) {
                System.out.println("lines 转换 list 成功");
            }
            JSONObject result = new JSONObject();
            result.put("activeDataList", lines);
            FileUtil.write(Values.GROUPS_NAME, result.toString());
            System.out.println("lines.json 转换 groups.json 成功");
        }
        return null;
    }

    public static String executeTowersToTargets(String json) {

        Gson gson = new GsonBuilder().serializeNulls().create();
        List<Targets> resultTargets = new ArrayList<>();
        if(vpList!=null&&vpList.size()>0){
            resultTargets.addAll(vpList);
        }
        if (json != null && !json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("activeDataList");
            List<Targets> targets = gson.fromJson(jsonArray.toString(), new TypeToken<List<Targets>>() {
            }.getType());

            for (int i = 0; i < targets.size(); i++) {
                Targets targetsObj = targets.get(i);
                TargetsInfo targetsInfo = targetsObj.getInfo();
                targetsInfo.setGroupId(targetsInfo.getLineId());
                if (targetsInfo.getGps() == null) {
                    targetsObj.setType("visiblePassageway");
                } else {
                    targetsObj.setType("visible");
                }
            }
            if (targets != null && targets.size() > 0) {
                System.out.println("towers 转换 list 成功");
            }
            resultTargets.addAll(targets);
            String result = "{\"activeDateList\":" + gson.toJson(resultTargets) + "}";
            FileUtil.write(Values.TARGETS_NAME, result);
            System.out.println("towers.json 转换 targets.json 成功");
        }
        return null;
    }

    public static String executeMissionTowersToCollectionInfo(String json) {
        //设置要替换的key
        HashMap<String, String> rep = new HashMap<String, String>();
        rep.put("towerId", "targetId");

        Gson gson = new GsonBuilder().serializeNulls().create();
        if (json != null && !json.isEmpty()) {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("activeDataList");
            JsonElement jsonEle = new JsonParser().parse(jsonArray.toString());
            JsonElement replaceKey = replaceKey(jsonEle, rep);
            List<CollectionBean> collections = gson.fromJson(replaceKey.toString(), new TypeToken<List<CollectionBean>>() {
            }.getType());
            if (collections != null && collections.size() > 0) {
                System.out.println("MissionTowers 转换 list 成功");
            }
            String result = "{\"activeDateList\":" + gson.toJson(collections) + "}";
            FileUtil.write(Values.COLLECTIONS_NAME, result);
            System.out.println("MissionTowers.json 转换 CollectionInfo.json 成功");
        }
        return null;
    }

    /**
     * 替换key
     *
     * @param source
     * @param rep
     * @return
     */
    public static JsonElement replaceKey(JsonElement source, Map<String, String> rep) {
        if (source == null || source.isJsonNull()) {
            return JsonNull.INSTANCE;
        }
        if (source.isJsonPrimitive()) {
            return source;
        }
        if (source.isJsonArray()) {
            JsonArray jsonArr = source.getAsJsonArray();
            JsonArray jsonArray = new JsonArray();
            jsonArr.forEach(item -> {
                jsonArray.add(replaceKey(item, rep));
            });
            return jsonArray;
        }
        if (source.isJsonObject()) {
            JsonObject jsonObj = source.getAsJsonObject();
            Iterator<Map.Entry<String, JsonElement>> iterator = jsonObj.entrySet().iterator();
            JsonObject newJsonObj = new JsonObject();
            iterator.forEachRemaining(item -> {
                String key = item.getKey();
                JsonElement value = item.getValue();
                if (rep.containsKey(key)) {
                    String newKey = rep.get(key);
                    key = newKey;
                }
                newJsonObj.add(key, replaceKey(value, rep));
            });

            return newJsonObj;
        }
        return JsonNull.INSTANCE;
    }
}
