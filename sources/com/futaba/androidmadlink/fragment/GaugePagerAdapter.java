package com.futaba.androidmadlink.fragment;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.FragmentPagerAdapter;
import android.util.Log;
import com.futaba.androidmadlink.config.CreateSettingsXml;
import com.futaba.androidmadlink.config.GaugePageSetting;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.util.XMLHelper;
import com.futaba.androidmadlink.view.DataTypes;
import com.futaba.androidmadlink.view.SensorTypes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GaugePagerAdapter extends FragmentPagerAdapter {
    private static GaugePagerAdapter _instance = null;
    private static List<GaugePageSetting> _listPageSettings;
    private boolean[] _allSlots = new boolean[32];
    private String[] _allSlotsSensorName = new String[32];
    private Document document = null;
    final String xmlFile = Parameter.rootGaugeFile;

    public GaugePagerAdapter(FragmentManager fm) {
        super(fm);
        loadSettingsFromXml();
    }

    public static GaugePagerAdapter getInstance(FragmentManager fm) {
        _instance = new GaugePagerAdapter(fm);
        return _instance;
    }

    public List<GaugePageSetting> getPageSettingList() {
        return _listPageSettings;
    }

    public GaugePageSetting getGaugePageSetting(int pageNo) {
        for (GaugePageSetting mPageSetting : _listPageSettings) {
            if (mPageSetting.getPageNo() == pageNo) {
                return mPageSetting;
            }
        }
        return null;
    }

    public void setAllSlots(boolean[] allSlots) {
        this._allSlots = allSlots;
    }

    public boolean[] getAllSlots() {
        return this._allSlots;
    }

    public String[] getAllSlotsSenserName() {
        return this._allSlotsSensorName;
    }

    public void resetAllSlots() {
        this._allSlots = new boolean[32];
        this._allSlotsSensorName = new String[32];
        for (GaugePageSetting mPageSetting : getPageSettingList()) {
            for (GaugeViewSetting mViewSetting : mPageSetting.getGaugeViewList()) {
                if (mViewSetting.getDataType() != DataTypes.Servo) {
                    int slot = mViewSetting.getSlot();
                    int slotCount = -1;
                    if (mViewSetting.getSensorType() == SensorTypes.Receiver || mViewSetting.getSensorType() == SensorTypes.Temperature || mViewSetting.getSensorType() == SensorTypes.RPM) {
                        slotCount = 1;
                    } else if (mViewSetting.getSensorType() == SensorTypes.Voltage) {
                        slotCount = 2;
                    } else if (mViewSetting.getSensorType() == SensorTypes.Altitude) {
                        slotCount = 3;
                    } else if (mViewSetting.getSensorType() == SensorTypes.GPS || mViewSetting.getSensorType() == SensorTypes.GPSLocus) {
                        slotCount = 8;
                    }
                    for (int i = 0; i < slotCount; i++) {
                        this._allSlots[slot + i] = true;
                        if (mViewSetting.getSensorType() != SensorTypes.GPSLocus || this._allSlotsSensorName[slot + i] == null || !this._allSlotsSensorName[slot + i].equals("GPS")) {
                            this._allSlotsSensorName[slot + i] = mViewSetting.getSensorType().toString();
                        }
                    }
                }
            }
        }
    }

    public Fragment getItem(int position) {
        GridFragment fragment = new GridFragment();
        Bundle args = new Bundle();
        args.putInt("section_number", position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    public int getCount() {
        return _listPageSettings.size();
    }

    public CharSequence getPageTitle(int position) {
        String title = "Page";
        for (GaugePageSetting pageSetting : _listPageSettings) {
            if (pageSetting.getPageNo() == position + 1) {
                title = pageSetting.getTitle();
            }
        }
        return title;
    }

    public void addPage(GaugePageSetting pageSetting) {
        for (int colNo = 0; colNo < pageSetting.getColCount(); colNo++) {
            for (int rowNo = 0; rowNo < pageSetting.getRowCount(); rowNo++) {
                GaugeViewSetting newViewSetting = new GaugeViewSetting();
                newViewSetting.setColNo(colNo);
                newViewSetting.setRowNo(rowNo);
                pageSetting.addView(newViewSetting);
            }
        }
        _listPageSettings.add(pageSetting);
        AddPageToXml(pageSetting);
    }

    public void deletePage(int pageNo) {
        GaugePageSetting delPageSetting = null;
        for (GaugePageSetting pageSetting : _listPageSettings) {
            if (pageSetting.getPageNo() == pageNo) {
                delPageSetting = pageSetting;
            }
            if (pageSetting.getPageNo() > pageNo) {
                pageSetting.setPageNo(pageSetting.getPageNo() - 1);
            }
        }
        _listPageSettings.remove(delPageSetting);
        DeletePageToXml(delPageSetting);
        if (_listPageSettings.size() == 0) {
            addPage(new GaugePageSetting());
        }
    }

    public void updateView(GaugeViewSetting viewSetting) {
        GaugePageSetting page = null;
        Iterator it = _listPageSettings.iterator();
        while (true) {
            if (it.hasNext()) {
                GaugePageSetting ps = (GaugePageSetting) it.next();
                if (ps.getPageNo() == viewSetting.getPageNo()) {
                    page = ps;
                    break;
                }
            } else {
                break;
            }
        }
        for (GaugeViewSetting vs : page.getGaugeViewList()) {
            if (vs.getColNo() == viewSetting.getColNo() && vs.getRowNo() == viewSetting.getRowNo()) {
                UpdateViewToXml(viewSetting);
                return;
            }
        }
    }

    public int getItemPosition(Object object) {
        return -2;
    }

    public void loadSettingsFromXml() {
        if (_listPageSettings == null) {
            _listPageSettings = new ArrayList();
        }
        _listPageSettings.clear();
        CreateSettingsXml.CreateXmlSettings();
        ReadPageFromXml();
        resetAllSlots();
    }

    private boolean IsFileExist() {
        if (!new File(this.xmlFile).exists()) {
            return false;
        }
        return true;
    }

    private void CreateXml() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = this.document.createElement("PageSettings");
            Element Node_Set = this.document.createElement(Parameter.FILE_EXT_SETTING);
            Element AlertSound = this.document.createElement("AlertSound");
            AlertSound.setTextContent(Parameter.getAlertSound());
            Node_Set.appendChild(AlertSound);
            Element ScreenMode = this.document.createElement("ScreenMode");
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
            this.document.appendChild(root);
            save();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Create Xml Error:" + e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void ReadPageFromXml() {
        NodeList pageNodes = XMLHelper.getNodeLists("page");
        for (int pageIndex = 0; pageIndex < pageNodes.getLength(); pageIndex++) {
            int PageNo = pageIndex + 1;
            GaugePageSetting pageSetting = new GaugePageSetting();
            Node pageNode = XMLHelper.getParentNodeByName("page", "id", String.valueOf(PageNo));
            if (pageNode != null) {
                pageSetting.setPageNo(PageNo);
                String cols = XMLHelper.getNodeAttr(pageNode, "cols");
                String rows = XMLHelper.getNodeAttr(pageNode, "rows");
                if (!cols.equals("")) {
                    pageSetting.setColCount(Integer.valueOf(cols).intValue());
                }
                if (!rows.equals("")) {
                    pageSetting.setRowCount(Integer.valueOf(rows).intValue());
                }
                pageSetting.setTitle(XMLHelper.getNodeAttr(pageNode, "title"));
                for (int colIndex = 0; colIndex < pageSetting.getColCount(); colIndex++) {
                    for (int rowIndex = 0; rowIndex < pageSetting.getRowCount(); rowIndex++) {
                        Node viewNode = null;
                        try {
                            viewNode = XMLHelper.getKeyNode(String.valueOf(PageNo), String.valueOf(colIndex), String.valueOf(rowIndex));
                        } catch (IOException | ParserConfigurationException | SAXException e) {
                        }
                        if (viewNode != null) {
                            GaugeViewSetting viewSetting = new GaugeViewSetting();
                            String DataTypeString = XMLHelper.Help_getNodeValueByName(viewNode, "DataType");
                            DataTypes dataType = null;
                            if (DataTypeString.equalsIgnoreCase("Servo")) {
                                dataType = DataTypes.Servo;
                            } else if (DataTypeString.equalsIgnoreCase("Sensor")) {
                                dataType = DataTypes.Sensor;
                            }
                            viewSetting.setDataType(dataType);
                            viewSetting.setPageNo(PageNo);
                            viewSetting.setColNo(colIndex);
                            viewSetting.setRowNo(rowIndex);
                            viewSetting.setColSpan(Integer.valueOf(XMLHelper.getNodeAttr(viewNode, "ColSpan")).intValue());
                            viewSetting.setRowSpan(Integer.valueOf(XMLHelper.getNodeAttr(viewNode, "RowSpan")).intValue());
                            viewSetting.setSensorTitle(XMLHelper.Help_getNodeValueByName(viewNode, "SensorTitle"));
                            String sensorType = XMLHelper.Help_getNodeValueByName(viewNode, "SensorType");
                            SensorTypes sensorTypes = null;
                            if (sensorType.equals("Voltage")) {
                                sensorTypes = SensorTypes.Voltage;
                            } else if (sensorType.equals("Receiver")) {
                                sensorTypes = SensorTypes.Receiver;
                            } else if (sensorType.equals("Temperature")) {
                                sensorTypes = SensorTypes.Temperature;
                            } else if (sensorType.equals("RPM")) {
                                sensorTypes = SensorTypes.RPM;
                            } else if (sensorType.equals("Altitude")) {
                                sensorTypes = SensorTypes.Altitude;
                            } else if (sensorType.equals("GPS")) {
                                sensorTypes = SensorTypes.GPS;
                            } else if (sensorType.equals("GPSLocus")) {
                                sensorTypes = SensorTypes.GPSLocus;
                            }
                            viewSetting.setSensorType(sensorTypes);
                            viewSetting.setAttributes(XMLHelper.Help_getNodeValueByName(viewNode, "Attributes"));
                            pageSetting.addView(viewSetting);
                        }
                    }
                }
                _listPageSettings.add(pageSetting);
            }
        }
    }

    private void AddPageToXml(GaugePageSetting pageSetting) {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(this.xmlFile));
            Node root = this.document.getDocumentElement();
            Element Node_Page = createContactNode("page", new String[]{"id", "cols", "rows", "title"}, new String[]{String.valueOf(pageSetting.getPageNo()), String.valueOf(pageSetting.getColCount()), String.valueOf(pageSetting.getRowCount()), String.valueOf(pageSetting.getTitle())});
            root.appendChild(Node_Page);
            for (int i = 0; i < pageSetting.getRowCount(); i++) {
                for (int j = 0; j < pageSetting.getColCount(); j++) {
                    Node_Page.appendChild(getEmptyElement(j, i));
                }
            }
            save();
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Add Page Error:" + e.getMessage());
        }
    }

    private void DeletePageToXml(GaugePageSetting pageSetting) {
        try {
            if (XMLHelper.DelPage(pageSetting.getPageNo())) {
                XMLHelper.save();
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Delete Page Error:" + e.getMessage());
        }
    }

    private void UpdateViewToXml(GaugeViewSetting viewSetting) {
        String dataTypes;
        String sensorTypes;
        try {
            Node view = XMLHelper.getKeyNode(String.valueOf(viewSetting.getPageNo()), String.valueOf(viewSetting.getColNo()), String.valueOf(viewSetting.getRowNo()));
            if (view != null) {
                NodeList nodeList = view.getChildNodes();
                if (nodeList != null) {
                    String str = "DataType";
                    if (viewSetting.getDataType() == null) {
                        dataTypes = "";
                    } else {
                        dataTypes = viewSetting.getDataType().toString();
                    }
                    XMLHelper.updateNode(nodeList, str, dataTypes);
                    if (viewSetting.getDataType() == DataTypes.Servo) {
                        XMLHelper.save();
                        return;
                    }
                    String str2 = "SensorType";
                    if (viewSetting.getSensorType() == null) {
                        sensorTypes = "";
                    } else {
                        sensorTypes = viewSetting.getSensorType().toString();
                    }
                    XMLHelper.updateNode(nodeList, str2, sensorTypes);
                    XMLHelper.updateNode(nodeList, "SensorTitle", viewSetting.getSensorTitle());
                    XMLHelper.updateNode(nodeList, "Attributes", viewSetting.getAttributes());
                    XMLHelper.save();
                }
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Add Page Error:" + e.getMessage());
        }
    }

    private Element createContactNode(String NodeName, String[] AttrName, String[] AttrValue) throws Exception {
        if (AttrName.length != AttrValue.length) {
            throw new Exception("Node的Attribute Name長度跟Attribute Value長度不一致");
        }
        Element contact = this.document.createElement(NodeName);
        for (int i = 0; i < AttrName.length; i++) {
            Attr genderAttribute = this.document.createAttribute(AttrName[i]);
            genderAttribute.setValue(AttrValue[i]);
            contact.setAttributeNode(genderAttribute);
        }
        return contact;
    }

    private Element getEmptyElement(int ColNo, int RowNo) throws Exception {
        Element Node_View = createContactNode("view", new String[]{"ColNo", "RowNo", "ColSpan", "RowSpan"}, new String[]{String.valueOf(ColNo), String.valueOf(RowNo), "1", "1"});
        Node_View.appendChild(this.document.createElement("DataType"));
        Node_View.appendChild(this.document.createElement("SensorType"));
        Node_View.appendChild(this.document.createElement("SensorTitle"));
        Node_View.appendChild(this.document.createElement("Attributes"));
        return Node_View;
    }

    private void save() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(this.document), new StreamResult(new File(this.xmlFile)));
    }
}
