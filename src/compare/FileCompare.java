package compare;

import bean.collection.CollectionBean;
import bean.collection.Gps;
import bean.collection.StartAndEndPosition;
import bean.collection.WayPoint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * @anthor: Banana
 * @function:
 * @date: 2020/8/17
 */
public class FileCompare {
    public static String compare(String file_1, String file_2) {
        StringBuffer result = new StringBuffer();
        Gson gson = new GsonBuilder().serializeNulls().create();
        JSONObject jsonObject_1 = new JSONObject(file_1);
        JSONArray jsonArray_1 = jsonObject_1.getJSONArray("activeDataList");
        List<CollectionBean> collectionBeans_1 = gson.fromJson(jsonArray_1.toString(),
                new TypeToken<List<CollectionBean>>() {
                }.getType());

        JSONObject jsonObject_2 = new JSONObject(file_2);
        JSONArray jsonArray_2 = jsonObject_2.getJSONArray("activeDataList");
        List<CollectionBean> collectionBeans_2 = gson.fromJson(jsonArray_2.toString(),
                new TypeToken<List<CollectionBean>>() {
                }.getType());

        for (int i = 0; i < collectionBeans_1.size(); i++) {
            try {
                CollectionBean collectionBean_1 = collectionBeans_1.get(i);
                WayPoint wayPoint_1 = collectionBean_1.getWayPoint();
                List<Gps> gpsList_1 = wayPoint_1.getGpsList();
                StartAndEndPosition startPosition_1 = wayPoint_1.getStartPosition();
                StartAndEndPosition endPosition_1 = wayPoint_1.getEndPosition();
                for (int j = 0; j < collectionBeans_2.size(); j++) {
                    CollectionBean collectionBean_2 = collectionBeans_2.get(j);
                    boolean isSame = true;
                    if (collectionBean_1.getTargetId().equals(collectionBean_2.getTargetId())) {
                        WayPoint wayPoint_2 = collectionBeans_2.get(j).getWayPoint();
                        List<Gps> gpsList_2 = wayPoint_2.getGpsList();
                        StartAndEndPosition startPosition_2 = wayPoint_2.getStartPosition();
                        StartAndEndPosition endPosition_2 = wayPoint_2.getEndPosition();

                        isSame = startPosition_1.getLat() == startPosition_2.getLat()
                                && startPosition_1.getLon() == startPosition_2.getLon()
                                || endPosition_1.getLat() == endPosition_2.getLat()
                                && endPosition_1.getLon() == endPosition_2.getLon();
                        if (!isSame) {
                            result.append("targetId:" + collectionBean_1.getTargetId() + "---开始或结束GPS数据不对\n");
                            continue;
                        }
                        if (gpsList_1.size() != gpsList_2.size()) {
                            result.append("targetId:" + collectionBean_1.getTargetId() + "---GPS数据不对\n");
                            continue;
                        }
                        for (int k = 0; k < gpsList_1.size(); k++) {
                            isSame = gpsList_1.get(k).getLat() == gpsList_2.get(k).getLat()
                                    && gpsList_1.get(k).getLon() == gpsList_2.get(k).getLon();
                            if (!isSame) {
                                result.append("targetId:" + collectionBean_1.getTargetId() + "---GPS数据不对\n");
                                break;
                            }
                        }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return result.toString();
    }
}
