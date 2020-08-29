package com.futaba.androidmadlink.util;

import com.futaba.androidmadlink.config.Parameter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLHelper {
    public static final String TAG = "XMLHelper";
    public static Document document = null;
    private static String xmlPath = Parameter.rootGaugeFile;

    public static void ReLoadXml() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
        } catch (Exception e) {
        }
    }

    public static Node getKeyNode(String Page, String Col, String Row) throws ParserConfigurationException, SAXException, IOException {
        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
        return Help_getChildNodes("view", Help_getChildNodes("page", document.getDocumentElement(), new String[]{"id"}, new String[]{Page}), new String[]{"ColNo", "RowNo"}, new String[]{Col, Row});
    }

    private static Node Help_getChildNodes(String tagName, Node Node, String[] Attr, String[] AttrVal) {
        NodeList ls = ((Element) Node).getElementsByTagName(tagName);
        if (ls == null) {
            return null;
        }
        for (int i = 0; i < ls.getLength(); i++) {
            boolean pass = true;
            for (int j = 0; j < Attr.length; j++) {
                if (!Help_getNodeAttr(ls.item(i), Attr[j]).equals(AttrVal[j])) {
                    pass = false;
                }
            }
            if (pass) {
                return ls.item(i);
            }
        }
        return null;
    }

    public static NodeList getNodeLists(String TagName) {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
        } catch (Exception e) {
        }
        return document.getElementsByTagName(TagName);
    }

    public static String Help_getNodeAttr(Node Node, String Attr) {
        if (Node == null) {
            return null;
        }
        List<String> attr = Help_ListAllAtributeByElement(Node);
        for (int i = 0; i < attr.size(); i++) {
            String[] va = ((String) attr.get(i)).split("~");
            String name = va[0].trim();
            String str = va[1];
            if (name.equals(Attr.trim())) {
                return str;
            }
        }
        return null;
    }

    private static List<String> Help_ListAllAtributeByElement(Node element) {
        List<String> ls = new ArrayList<>();
        try {
            NamedNodeMap attributes = element.getAttributes();
            int numAttrs = attributes.getLength();
            for (int i = 0; i < numAttrs; i++) {
                Attr attr = (Attr) attributes.item(i);
                String attrName = attr.getNodeName();
                ls.add(new StringBuilder(String.valueOf(attrName)).append("~").append(attr.getNodeValue()).toString());
            }
        } catch (Exception e) {
        }
        return ls;
    }

    public static String Help_getNodeValueByName(Node node, String NodeName) {
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node element = nodes.item(i);
            if (NodeName.equals(element.getNodeName())) {
                return element.getTextContent();
            }
        }
        return "";
    }

    public static String GetValue(String Attributes, String Name) {
        String Value = "";
        String[] ls = Attributes.replace("{", "").replace("}", "").split(",");
        for (String replace : ls) {
            String[] Data = replace.replace("'", "").split(":");
            if (Data.length == 2 && Data[0].contains(Name)) {
                Value = Data[1];
            }
        }
        return Value;
    }

    public static String GetUpdateStr(String[] Names, String[] Values) {
        boolean z;
        String msg = "{";
        if (Names.length != Values.length) {
            return "";
        }
        int i = 0;
        while (i < Values.length) {
            msg = new StringBuilder(String.valueOf(msg)).append(dotStr(Names[i])).append(":").append(dotStr(Values[i])).toString();
            if (Values.length != 1) {
                z = true;
            } else {
                z = false;
            }
            if (z && (i != Values.length + -1)) {
                msg = new StringBuilder(String.valueOf(msg)).append(",").toString();
            }
            i++;
        }
        return new StringBuilder(String.valueOf(msg)).append("}").toString();
    }

    public static String dotStr(String str) {
        return "'" + str + "'";
    }

    public static NodeList updateNode(NodeList nodes, String NodeName, String Value) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node element = nodes.item(i);
            if (NodeName.equals(element.getNodeName())) {
                element.setTextContent(Value);
            }
        }
        return nodes;
    }

    public static void save() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(new File(xmlPath)));
    }

    public static boolean DelPage(int page) {
        boolean isok = true;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
            Node root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node element = nodes.item(i);
                if (element != null && element.getNodeName().equals("page")) {
                    String id = Help_getNodeAttr(element, "id").trim();
                    int ids = 0;
                    if (!id.equals("")) {
                        ids = Integer.valueOf(id).intValue();
                    }
                    if (ids == page) {
                        root.removeChild(element);
                    } else if (ids > page) {
                        if (!Help_setNodeAttr(element, new String[]{"id"}, new String[]{String.valueOf(ids - 1)})) {
                            isok = false;
                        }
                    }
                }
            }
            return isok;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Help_setNodeAttr(Node element, String[] AttrName, String[] AttrValue) {
        try {
            if (AttrName.length != AttrValue.length) {
                throw new Exception("Node的Attribute Name長度跟Attribute Value長度不一致");
            }
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < AttrName.length; i++) {
                Node nodeAttr = attributes.getNamedItem(AttrName[i]);
                if (nodeAttr != null) {
                    nodeAttr.setTextContent(AttrValue[i]);
                } else {
                    Attr genderAttribute = document.createAttribute(AttrName[i]);
                    genderAttribute.setValue(AttrValue[i]);
                    ((Element) element).setAttributeNode(genderAttribute);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Node getParentNodeByName(String NodeName, String Attr, String AttrVal) {
        NodeList ls = document.getElementsByTagName(NodeName);
        for (int i = 0; i < ls.getLength(); i++) {
            if (getNodeAttr(ls.item(i), Attr).equals(AttrVal)) {
                return ls.item(i);
            }
        }
        return null;
    }

    public static String getNodeAttr(Node Node, String Attr) {
        if (Node == null) {
            return null;
        }
        List<String> attr = ListAllAtributeByElement(Node);
        for (int i = 0; i < attr.size(); i++) {
            String[] va = ((String) attr.get(i)).split("~");
            String name = va[0];
            String str = va[1];
            if (name.equals(Attr)) {
                return str;
            }
        }
        return null;
    }

    private static List<String> ListAllAtributeByElement(Node element) {
        List<String> ls = new ArrayList<>();
        try {
            NamedNodeMap attributes = element.getAttributes();
            int numAttrs = attributes.getLength();
            for (int i = 0; i < numAttrs; i++) {
                Attr attr = (Attr) attributes.item(i);
                String attrName = attr.getNodeName();
                ls.add(new StringBuilder(String.valueOf(attrName)).append("~").append(attr.getNodeValue()).toString());
            }
        } catch (Exception e) {
        }
        return ls;
    }
}
