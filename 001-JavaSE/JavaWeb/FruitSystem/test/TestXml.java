import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

public class TestXml {
    @Test
    public void TestXml() throws ParserConfigurationException, IOException, SAXException {
        // 获取xml文件的输入流对象
        InputStream in = TestXml.class.getClassLoader().getResourceAsStream("students.xml");
        // 创建dom工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 创建documentBuilder对象
        DocumentBuilder builder = factory.newDocumentBuilder();
        // 创建DOM对象
        Document dom = builder.parse(in);
        // 获取元素
        NodeList studentNodeList = dom.getElementsByTagName("student");
        for (int i = 0; i < studentNodeList.getLength(); i++) {
            // 获取NodeList中的每一个元素节点
            Node nodeItem = studentNodeList.item(i);
            // 把Node类型 强转为 Element类型
            Element eleItem = (Element) nodeItem;
            // 使用Element中的方法，获取标签中的属性
            String sid = eleItem.getAttribute("sid");
            String gid = eleItem.getAttribute("gid");
            // 打印
            System.out.println("sid 和 gid 分别是 " + sid + gid);
            // 获取标签内的子标签
            NodeList childNodes = eleItem.getChildNodes();
            // 遍历子标签节点
            for (int j = 0; j < childNodes.getLength(); j++) {
                // 获取子标签内的节点元素
                Node nodeChildItem = childNodes.item(j);
                // 判断子标签内节点类型是否是元素类型
                if (nodeChildItem.getNodeType() == Node.ELEMENT_NODE){
                    // 获取子节点的内的第一个子节点
                    Node firstChild = nodeChildItem.getFirstChild();
                    // 如果第一个子节点的子节点是文本节点则读取值
                    if (firstChild.getNodeType() == Node.TEXT_NODE){
                        String nodeValue = firstChild.getNodeValue();
                        System.out.println("nodeValue = " + nodeValue);
                    }
                }
            }
        }
    }
}
