package com.futaba.androidmadlink.config;

import android.util.Log;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateSettingsXml {
    private static Document document = null;
    private static String xmlFile = Parameter.rootGaugeFile;

    public static void CreateXmlSettings() {
        if (!IsFileExist()) {
            CreateXml();
        }
    }

    private static boolean IsFileExist() {
        if (!new File(xmlFile).exists()) {
            return false;
        }
        return true;
    }

    private static void CreateXml() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = document.createElement("PageSettings");
            Element Node_Set = document.createElement(Parameter.FILE_EXT_SETTING);
            Node_Set.appendChild(document.createElement("AlertSound"));
            Element ScreenMode = document.createElement("ScreenMode");
            ScreenMode.setTextContent(String.valueOf(Parameter.getScreenMode()).trim());
            Node_Set.appendChild(ScreenMode);
            root.appendChild(Node_Set);
            Element Node_Page = createContactNode("page", new String[]{"id", "cols", "rows", "title"}, new String[]{"1", "2", "3", "Page1"});
            root.appendChild(Node_Page);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    Node_Page.appendChild(getEmptyElement(j, i));
                }
            }
            document.appendChild(root);
            save();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "CreateSettingsXml Create Xml Error:" + e.getMessage());
        }
    }

    private static Element createContactNode(String NodeName, String[] AttrName, String[] AttrValue) throws Exception {
        if (AttrName.length != AttrValue.length) {
            throw new Exception("Node的Attribute Name長度跟Attribute Value長度不一致");
        }
        Element contact = document.createElement(NodeName);
        for (int i = 0; i < AttrName.length; i++) {
            Attr genderAttribute = document.createAttribute(AttrName[i]);
            genderAttribute.setValue(AttrValue[i]);
            contact.setAttributeNode(genderAttribute);
        }
        return contact;
    }

    private static Element getEmptyElement(int ColNo, int RowNo) throws Exception {
        Element Node_View = createContactNode("view", new String[]{"ColNo", "RowNo", "ColSpan", "RowSpan"}, new String[]{String.valueOf(ColNo), String.valueOf(RowNo), "1", "1"});
        Node_View.appendChild(document.createElement("DataType"));
        Node_View.appendChild(document.createElement("SensorType"));
        Node_View.appendChild(document.createElement("SensorTitle"));
        Node_View.appendChild(document.createElement("Attributes"));
        return Node_View;
    }

    private static void save() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(new File(xmlFile)));
    }
}
