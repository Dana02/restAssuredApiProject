package org.example.utils;

public class XmlUtils {


//    @SneakyThrows
//    public static List<Map<String, String>> readXML(String fileName) {
//        SAXBuilder builder = new SAXBuilder();
//        File file = new File(fileName);
//        Document document = (Document) builder.build(file);
//        Element rootNode = document.getRootElement();
//        List<Map<String, String>> data = new ArrayList<>();
//        List<Element> userList = rootNode.getChildren("user");
//        for (Element user : userList) {
//            Map<String, String> row = new HashMap<>();
//            row.put("Name", user.getChildText("name"));
//            row.put("Age", user.getChildText("age"));
//            row.put("Email", user.getChildText("email"));
//            data.add(row);
//        }
//        return data;
//    }
}
