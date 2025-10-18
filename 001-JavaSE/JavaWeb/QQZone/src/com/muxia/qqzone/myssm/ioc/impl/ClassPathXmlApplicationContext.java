package com.muxia.qqzone.myssm.ioc.impl;

import com.muxia.qqzone.myssm.ioc.BeanFactory;
import com.muxia.qqzone.myssm.utils.ClassUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ClassPathXmlApplicationContext implements BeanFactory {

    // 创建一个Map集合，键值对集合，每一个键值，键为String类型的接口类型，值为接口的实现类实例。
    // 这些实例中根据xml的配置，有的有属性且指向另一个实例对象，有的没有属性
    // {{"fruitDao":@xxcc},{"fruiService":@xxzz}}
    /*
    * @xxcc: new FruitDaoImpl 实例
    * @xxzz: new FruitServiceImpl 实例，且包含 @xxzz.fruitDao = @xxcc 属性
    * */
    private Map<String,Object> beanMap = new HashMap<>();

    @Override
    public Object getBean(String id) {
        // 获取map集合中的键的值
        return beanMap.get(id);
    }

    // 无参构造中调用 bean.xml
    public ClassPathXmlApplicationContext() {
        this("bean.xml");
    }

    // 在构造方法中解析xml文件配置
    public ClassPathXmlApplicationContext(String configName){
        try {
            // 加载xml
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(configName);
            // 如果为空则抛异常
            if (in == null){
                throw new RuntimeException(configName + "找不到，或者非法！");
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 获取doc对象
            Document doc = builder.parse(in);
            // 解析doc对象，每个Node标签节点称为一个bean
            NodeList beanNodeList = doc.getElementsByTagName("bean");
            // 获取bean节点
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                // 获取bean节点
                Node beanNode = beanNodeList.item(i);
                // 判断如果是元素节点
                if (beanNode.getNodeType() == Node.ELEMENT_NODE){
                    // 强制转为元素节点
                    Element beanElement = (Element) beanNode;
                    // 获取bean元素上属性
                    String id = beanElement.getAttribute("id"); // fruitDao
                    String className = beanElement.getAttribute("class"); // com.yuluo.dao.impl.FruitDaoImpl
                    // 通过反射获取实现类的实例，bean，种子
                    Object beanInstance = ClassUtil.createInstance(className); // new FruitDaoImpl @xxcc
                    // 把这个实例对象存放在map集合中
                    beanMap.put(id,beanInstance); // {{"fruitDao": @xxcc},{"fruiService":@xxzz}}
                    /*
                     *  {{"fruitDao":@xxcc},{"fruiService":@xxzz}}
                     *
                     * */

                }
            }
            // 手写 IoC 容器中的“自动注入依赖”核心逻辑
            // 重新遍历 beanNodeList 节点
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE){
                    Element beanElement = (Element) beanNode;
                    // 获取beanEle标签上的id的值
                    String id = beanElement.getAttribute("id"); // fruitService
                    // 从Map集合中取出 bean实例
                    Object bean = beanMap.get(id); // @xxzz

                    // 解析Xml中的子标签中的属性
                    NodeList beanChildNodeList = beanElement.getChildNodes();
                    for (int j = 0; j < beanChildNodeList.getLength(); j++) {
                        Node beanChildNode = beanChildNodeList.item(j);
                        // 判断子节点的元素的标签名称是否是property元素节点
                        // 没有则直接跳过，表示当前类中没有属性需要工厂类的需求
                        if (beanChildNode.getNodeType() == Node.ELEMENT_NODE && "property".equalsIgnoreCase(beanChildNode.getNodeName())){
                            // 强转为Element元素
                            Element propertyElement = (Element) beanChildNode;
                            // 获取属性名和属性值
                            String propertyName = propertyElement.getAttribute("name"); // fruitDao
                            // 这里的Ref指向id，也就是属性名
                            String propertyRef = propertyElement.getAttribute("ref"); // fruitDao
                            // 将propertyRef对应的实例取出来
                            Object refObj = beanMap.get(propertyRef); // 这里取出来的是 @xxcc 实例
                            // 将refObj赋值给bean的 propertyName 属性
                            // 给fruitService实例（@xxzz）中添加了 fruitDao 属性，并指定属性的指向为 FruitDao的实例（@xxcc）
                            ClassUtil.setProperty(bean,propertyName,refObj);
                            // 相当于在FruitService类中执行了 FruitDao fruitDao = new FruitDaoImpl()
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
