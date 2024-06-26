import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonComparator {

    public static boolean compareJsonStrings(String json1, String json2) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode tree1 = mapper.readTree(json1);
            JsonNode tree2 = mapper.readTree(json2);

            return compareJsonNodes(tree1, tree2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean compareJsonNodes(JsonNode node1, JsonNode node2) {
        if (node1.getNodeType() != node2.getNodeType()) {
            return false;
        }

        if (node1.isObject()) {
            ObjectNode obj1 = (ObjectNode) node1;
            ObjectNode obj2 = (ObjectNode) node2;
            return obj1.equals(obj2);
        } else if (node1.isArray()) {
            if (node1.size() != node2.size()) {
                return false;
            }
            for (int i = 0; i < node1.size(); i++) {
                if (!compareJsonNodes(node1.get(i), node2.get(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return node1.equals(node2);
        }
    }
}