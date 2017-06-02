package com.jh352160.xml;

import com.jh352160.json.JsonUtil;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by pcdalao on 2017/4/27.
 */
public class xmlCompareMain {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File f = new File("C:\\Users\\pcdalao\\Desktop\\strings.xml");
        Document doc = builder.parse(f);
        Element root = doc.getDocumentElement();
        NodeList stringsList = root.getElementsByTagName("string");

        f = new File("C:\\Users\\pcdalao\\Desktop\\strings1.xml");
        doc = builder.parse(f);
        root = doc.getDocumentElement();
        NodeList packageList = root.getElementsByTagName("string");

        for (int i = 0; i < stringsList.getLength(); i++) {
            Element n = (Element) stringsList.item(i);
            NamedNodeMap node = n.getAttributes();
            Node nn = node.item(0);

            if (!findNodeIsHave(packageList,nn)){
                System.out.println(nn.getNodeName() + ": " + nn.getNodeValue()+"       "+nn.getFirstChild().toString());
            }
        }
    }

    private static boolean findNodeIsHave(NodeList packageList, Node nn){
        for (int j = 0; j < packageList.getLength(); j++){
            Element n1 = (Element) packageList.item(j);
            NamedNodeMap node1 = n1.getAttributes();
            Node nn1 = node1.item(0);
            if (nn.getNodeValue().equals(nn1.getNodeValue())){
                return true;
            }
        }
        return false;
    }
}
