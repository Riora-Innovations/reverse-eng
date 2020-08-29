package com.futaba.androidmadlink.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p003v7.widget.GridLayout;
import android.support.p003v7.widget.GridLayout.LayoutParams;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.GPSLocusActivity;
import com.futaba.androidmadlink.GaugeActivity;
import com.futaba.androidmadlink.config.GaugePageSetting;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.constant.ArgumentKey;
import com.futaba.androidmadlink.dialog.ItemFragment;
import com.futaba.androidmadlink.dialog.SettingsFragment;
import com.futaba.androidmadlink.dialog.SubMenuFragment;
import com.futaba.androidmadlink.util.XMLHelper;
import com.futaba.androidmadlink.view.AltitudeView;
import com.futaba.androidmadlink.view.DataTypes;
import com.futaba.androidmadlink.view.DummyView;
import com.futaba.androidmadlink.view.GPSLocusView;
import com.futaba.androidmadlink.view.GPSView;
import com.futaba.androidmadlink.view.ISBusView;
import com.futaba.androidmadlink.view.RPMView;
import com.futaba.androidmadlink.view.RPMView.LabelConverter;
import com.futaba.androidmadlink.view.SensorTypes;
import com.futaba.androidmadlink.view.ServoView;
import com.futaba.androidmadlink.view.TemperatureView;
import com.futaba.androidmadlink.view.VoltageView;
import com.google.android.gms.maps.model.LatLng;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@SuppressLint({"NewApi"})
public class GridFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";
    int Page = 0;
    int _colCount = 2;
    int _rowCount = 2;

    /* renamed from: bd */
    private Bundle f12bd = null;
    private Object[] data2Value = new Object[32];
    private List<Integer> dataValue;
    private Document document = null;
    int flag = 0;

    /* renamed from: fm */
    private FragmentManager f13fm = null;
    private int height = 0;

    /* renamed from: lo */
    GridLayout f14lo = null;
    /* access modifiers changed from: private */
    public int mAlertFlag = 0;
    /* access modifiers changed from: private */
    public Runnable mAlertLoop = new Runnable() {
        public void run() {
            while (GridFragment.this.mAlertStutas) {
                try {
                    GridFragment.this.setAleart();
                    GridFragment.this.mAlertFlag = 1;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Log.e(Parameter.TAG, "Service mAlertLoop Error :" + e.getMessage());
                    return;
                }
            }
            GridFragment.this.mAlertFlag = 0;
            GridFragment.this.mHandler.post(new Runnable() {
                public void run() {
                    GridFragment.this.f14lo.setBackgroundColor(-16777216);
                }
            });
        }
    };
    /* access modifiers changed from: private */
    public boolean mAlertStutas = false;
    int mColor = -1;
    GaugePageSetting mGaugePageSetting = null;
    protected Handler mHandler = new Handler();
    private View[][] views = null;
    private int width = 0;
    final String xmlFile = Parameter.rootGaugeFile;

    class AleartEnableTask extends AsyncTask<String, Long, String> {
        AleartEnableTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... arg0) {
            try {
                new Thread(GridFragment.this.mAlertLoop).start();
            } catch (Exception e) {
                Log.e(Parameter.TAG, e.getMessage(), e);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0112R.layout.fragment_gauge, container, false);
        super.onCreate(savedInstanceState);
        this.f12bd = savedInstanceState;
        this.Page = getArguments().getInt("section_number");
        this.f14lo = (GridLayout) rootView.findViewById(C0112R.C0114id.Grid1);
        this.f14lo.removeAllViewsInLayout();
        FragmentActivity activity = getActivity();
        getActivity();
        Display display = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int actionBarHeight = getActivity().getActionBar().getHeight();
        TypedValue tv = new TypedValue();
        if (getActivity().getTheme().resolveAttribute(16843499, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        this.width = size.x;
        this.height = ((size.y - actionBarHeight) - dip2px(container.getContext(), (float) getStatusBarHeight())) - 50;
        this.mGaugePageSetting = GaugeActivity.mGaugePagerAdapter.getGaugePageSetting(this.Page);
        if (this.mGaugePageSetting != null) {
            this._colCount = this.mGaugePageSetting.getColCount();
            this._rowCount = this.mGaugePageSetting.getRowCount();
        }
        this.views = (View[][]) Array.newInstance(View.class, new int[]{this._rowCount, this._colCount});
        new LayoutParams().width = (this.width - (this._colCount * 10)) / this._colCount;
        for (int i = 0; i < this._rowCount; i++) {
            for (int j = 0; j < this._colCount; j++) {
                LayoutParams gridLayoutParam = new LayoutParams(GridLayout.spec(i), GridLayout.spec(j));
                gridLayoutParam.width = (this.width - (this._colCount * 10)) / this._colCount;
                gridLayoutParam.height = (this.height - (this._rowCount * 10)) / this._rowCount;
                try {
                    DummyView dummyView = new DummyView(getActivity());
                    try {
                        dummyView.setId((i * 10) + j);
                        C01482 r0 = new OnLongClickListener() {
                            public boolean onLongClick(View v) {
                                int Id = ((DummyView) v).getId();
                                int tj = Id % 10;
                                GridFragment.this.showSubMenudialog(tj, Id / 10);
                                return true;
                            }
                        };
                        dummyView.setOnLongClickListener(r0);
                        this.f14lo.addView(dummyView, gridLayoutParam);
                        this.views[i][j] = dummyView;
                    } catch (Exception e) {
                        DummyView dummyView2 = dummyView;
                    }
                } catch (Exception e2) {
                }
            }
        }
        for (GaugeViewSetting mGaugeViewSetting : this.mGaugePageSetting.getGaugeViewList()) {
            try {
                updateView(mGaugeViewSetting);
            } catch (Exception e3) {
                Log.e(Parameter.TAG, e3.getMessage());
            }
        }
        return rootView;
    }

    public String getViewData() {
        String viewDataString = "" + "{\"views\":[";
        int count = 0;
        for (int rowNum = 0; rowNum < this.views.length; rowNum++) {
            for (int colNum = 0; colNum < 2; colNum++) {
                try {
                    ISBusView sBusView = (ISBusView) this.views[rowNum][colNum];
                    if (!(sBusView.getDataType() == null || sBusView.getDataType() == DataTypes.Servo)) {
                        if (count != 0) {
                            viewDataString = new StringBuilder(String.valueOf(viewDataString)).append(",").toString();
                        }
                        viewDataString = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(viewDataString)).append("{").toString())).append("\"SensorTitle\":\"").append(sBusView.getSensorTitle()).append("\"").toString())).append(",\"DataTypes\":\"").append(sBusView.getDataType()).append("\"").toString())).append(",\"SensorType\":\"").append(sBusView.getSensorType()).append("\"").toString())).append(",\"Attributes\":\"").append(sBusView.getAttributes()).append("\"").toString())).append("}").toString();
                        count++;
                    }
                } catch (Exception e) {
                    Log.e("GridFragment", e.getMessage());
                }
            }
        }
        return new StringBuilder(String.valueOf(viewDataString)).append("]}").toString();
    }

    public void setViewValue(boolean alertStutas) {
        this.mAlertStutas = alertStutas;
        if (this.mAlertStutas && this.mAlertFlag == 0) {
            try {
                GaugeActivity.myVibrator.vibrate(3000);
            } catch (Exception e) {
                Log.e(Parameter.TAG, "GridFragment Vibrator Error " + e.getMessage());
            }
            new AleartEnableTask().execute(new String[0]);
        }
        for (GaugeViewSetting mViewSetting : this.mGaugePageSetting.getGaugeViewList()) {
            ((ISBusView) this.views[mViewSetting.getRowNo()][mViewSetting.getColNo()]).setSensorValue(mViewSetting.getSersorValueList());
        }
    }

    /* access modifiers changed from: private */
    public void setAleart() {
        this.mHandler.post(new Runnable() {
            public void run() {
                try {
                    switch (GridFragment.this.flag) {
                        case 0:
                            GridFragment.this.mColor = -1;
                            GridFragment.this.flag = 1;
                            break;
                        default:
                            GridFragment.this.mColor = SupportMenu.CATEGORY_MASK;
                            GridFragment.this.flag = 0;
                            break;
                    }
                    GridFragment.this.mHandler.post(new Runnable() {
                        public void run() {
                            GridFragment.this.f14lo.setBackgroundColor(GridFragment.this.mColor);
                        }
                    });
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "Service setAleart Error :" + e.getMessage());
                }
            }
        });
    }

    public void setGPSLocusResult(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            int _rowNo = bundle.getInt("RowNo");
            int _colNo = bundle.getInt("ColNo");
            String _attributes = bundle.getString("Attributes");
            List<LatLng> _mapLists = bundle.getParcelableArrayList("MapLists");
            if (_mapLists == null) {
                _mapLists = new ArrayList<>();
            }
            try {
                GPSLocusView gpsLocusView = (GPSLocusView) this.views[_rowNo][_colNo];
                if (gpsLocusView.getDataType() == DataTypes.Sensor && gpsLocusView.getSensorType() == SensorTypes.GPSLocus && gpsLocusView.getAttributes().equals(_attributes)) {
                    gpsLocusView.setMapLists(_mapLists);
                }
            } catch (Exception e) {
                Log.e("GridFragment", e.getMessage());
            }
        }
    }

    public static int dip2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public void showSettingdialog(int Col, int Row) {
        Fragment fragment = getFragmentManager().findFragmentByTag(SettingsFragment.TAG);
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
        DialogFragment prodDialog = SettingsFragment.newInstance();
        Bundle bundle = prodDialog.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            prodDialog.setArguments(bundle);
        }
        bundle.putInt(ArgumentKey.Key_Page, this.Page);
        bundle.putInt(ArgumentKey.Key_Row, Row);
        bundle.putInt(ArgumentKey.Key_Col, Col);
        String strSensorType = "";
        if (this.mGaugePageSetting.getGaugeViewSetting(Col, Row).getSensorType() != null) {
            SensorTypes _sensorType = this.mGaugePageSetting.getGaugeViewSetting(Col, Row).getSensorType();
            if (_sensorType == SensorTypes.Receiver) {
                strSensorType = "Receiver";
            } else if (_sensorType == SensorTypes.Voltage) {
                strSensorType = "Voltage";
            } else if (_sensorType == SensorTypes.Temperature) {
                strSensorType = "Temperature";
            } else if (_sensorType == SensorTypes.RPM) {
                strSensorType = "RPM";
            } else if (_sensorType == SensorTypes.Altitude) {
                strSensorType = "Altitude";
            } else if (_sensorType == SensorTypes.GPS) {
                strSensorType = "GPS";
            } else if (_sensorType == SensorTypes.GPSLocus) {
                strSensorType = "GPSLocus";
            }
        }
        bundle.putString(ArgumentKey.Key_SensorType, strSensorType);
        String strDataType = "Sensor";
        if (this.mGaugePageSetting.getGaugeViewSetting(Col, Row).getDataType() != null) {
            DataTypes _dataTypes = this.mGaugePageSetting.getGaugeViewSetting(Col, Row).getDataType();
            if (_dataTypes == DataTypes.Servo) {
                strDataType = "Servo";
            } else if (_dataTypes == DataTypes.Sensor) {
                strDataType = "Sensor";
            }
        }
        bundle.putString(ArgumentKey.Key_DataType, strDataType);
        bundle.putString(ArgumentKey.Key_Attributes, this.mGaugePageSetting.getGaugeViewSetting(Col, Row).getAttributes());
        prodDialog.setTargetFragment(this, 3);
        prodDialog.show(getFragmentManager().beginTransaction(), SettingsFragment.TAG);
    }

    public void showSubMenudialog(int Col, int Row) {
        Fragment fragment = getFragmentManager().findFragmentByTag(SubMenuFragment.TAG);
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
        DialogFragment prodDialog = SubMenuFragment.newInstance();
        String viewName = ((ISBusView) this.views[Row][Col]).getClass().getSimpleName();
        Bundle bundle = prodDialog.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            prodDialog.setArguments(bundle);
        }
        bundle.putInt(ArgumentKey.Key_Page, this.Page);
        bundle.putInt(ArgumentKey.Key_Row, Row);
        bundle.putInt(ArgumentKey.Key_Col, Col);
        bundle.putString(ArgumentKey.Key_ViewName, viewName);
        prodDialog.setTargetFragment(this, 2);
        prodDialog.show(getFragmentManager().beginTransaction(), SubMenuFragment.TAG);
    }

    public void showdialog(View v) {
        Fragment fragment = getFragmentManager().findFragmentByTag(ItemFragment.TAG);
        if (fragment != null) {
            getFragmentManager().beginTransaction().remove(fragment).commit();
        }
        DialogFragment prodDialog = ItemFragment.newInstance();
        if (prodDialog.getArguments() == null) {
            prodDialog.setArguments(new Bundle());
        }
        prodDialog.setTargetFragment(this, 1);
        prodDialog.show(getFragmentManager().beginTransaction(), ItemFragment.TAG);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int Rows;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != 0) {
            switch (requestCode) {
                case 1:
                    GaugePageSetting pageSetting = new GaugePageSetting();
                    String pageTitle = data.getExtras().getString("Key_PageTile");
                    String Type = data.getExtras().getString(ArgumentKey.Key_ItemCode);
                    int Cols = 2;
                    if (Type.equals("1X1")) {
                        Cols = 1;
                        Rows = 1;
                    } else if (Type.equals("1X2")) {
                        Cols = 1;
                        Rows = 2;
                    } else if (Type.equals("2X2")) {
                        Rows = 2;
                    } else if (Type.equals("2X3")) {
                        Rows = 3;
                    } else if (Type.equals("2X4")) {
                        Rows = 4;
                    } else {
                        Rows = 3;
                    }
                    pageSetting.setPageNo(GaugeActivity.mGaugePagerAdapter.getCount() + 1);
                    pageSetting.setTitle(pageTitle);
                    pageSetting.setColCount(Cols);
                    pageSetting.setRowCount(Rows);
                    GaugeActivity.mGaugePagerAdapter.addPage(pageSetting);
                    GaugeActivity.mGaugePagerAdapter.loadSettingsFromXml();
                    GaugeActivity.mGaugePagerAdapter.notifyDataSetChanged();
                    return;
                case 2:
                    String Key_ItemCode = data.getExtras().getString(ArgumentKey.Key_ItemCode);
                    int Col = data.getExtras().getInt(ArgumentKey.Key_Col);
                    int Row = data.getExtras().getInt(ArgumentKey.Key_Row);
                    if (Key_ItemCode.equals(getString(C0112R.string.action_remove))) {
                        try {
                            GaugeViewSetting mGaugeViewSetting = this.mGaugePageSetting.getGaugeViewSetting(Col, Row);
                            mGaugeViewSetting.setDataType(null);
                            mGaugeViewSetting.setSensorType(null);
                            mGaugeViewSetting.setSensorTitle("");
                            mGaugeViewSetting.setAttributes("");
                            GaugeActivity.mGaugePagerAdapter.updateView(mGaugeViewSetting);
                            GaugeActivity.mGaugePagerAdapter.resetAllSlots();
                            updateView(mGaugeViewSetting);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } else if (Key_ItemCode.equals(getString(C0112R.string.btnReset))) {
                        GaugeViewSetting mGaugeViewSetting2 = this.mGaugePageSetting.getGaugeViewSetting(Col, Row);
                        if (mGaugeViewSetting2.getSensorType() == SensorTypes.Altitude) {
                            ArrayList arrayList = new ArrayList();
                            if (mGaugeViewSetting2.getSersorValueList().size() != 0) {
                                arrayList.add(mGaugeViewSetting2.getSersorValueList().get(3));
                                mGaugeViewSetting2.setRegulateValue((List<Object>) arrayList);
                                float regulateValue = ((Float) arrayList.get(0)).floatValue();
                                try {
                                    Node view = XMLHelper.getKeyNode(String.valueOf(mGaugeViewSetting2.getPageNo()), String.valueOf(mGaugeViewSetting2.getColNo()), String.valueOf(mGaugeViewSetting2.getRowNo()));
                                    if (view != null) {
                                        NodeList nodeList = view.getChildNodes();
                                        if (nodeList != null) {
                                            JSONObject jsonResponse = new JSONObject(mGaugeViewSetting2.getAttributes());
                                            jsonResponse.put("RegulateValue", String.valueOf(regulateValue));
                                            XMLHelper.updateNode(nodeList, "Attributes", jsonResponse.toString().replace('\"', '\''));
                                            XMLHelper.save();
                                            mGaugeViewSetting2.setAttributes(jsonResponse.toString().replace('\"', '\''));
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (JSONException e2) {
                                    Log.d(Parameter.TAG, "GridFragment Reset Json Value Set Error :" + e2.getMessage());
                                } catch (IOException | ParserConfigurationException | TransformerException | SAXException e3) {
                                }
                            } else {
                                return;
                            }
                        }
                        ((ISBusView) this.views[Row][Col]).reset();
                        return;
                    } else {
                        showSettingdialog(Col, Row);
                        GaugeActivity.mGaugePagerAdapter.resetAllSlots();
                        return;
                    }
                case 3:
                    try {
                        int i = data.getExtras().getInt(ArgumentKey.Key_Row);
                        ArrayList vlist = data.getExtras().getParcelableArrayList(ArgumentKey.Key_ViewSetting);
                        if (vlist.size() != 0) {
                            GaugeViewSetting mGaugeViewSetting3 = (GaugeViewSetting) vlist.get(0);
                            GaugeActivity.mGaugePagerAdapter.updateView(mGaugeViewSetting3);
                            updateView(mGaugeViewSetting3);
                            GaugeActivity.mGaugePagerAdapter.loadSettingsFromXml();
                            this.mGaugePageSetting = GaugeActivity.mGaugePagerAdapter.getGaugePageSetting(this.Page);
                            return;
                        }
                        return;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        return;
                    }
                case 4:
                    setGPSLocusResult(data);
                    return;
                default:
                    return;
            }
        }
    }

    private void RemoveNode(int Page2, int Col, int Row) throws TransformerException {
        NodeList nodes = getChildNodes(getParentNodeByName("page", "id", String.valueOf(Page2)), new String[]{"ColNo", "RowNo"}, new String[]{String.valueOf(Col), String.valueOf(Row)}).getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            nodes.item(i).setTextContent("");
        }
        save();
    }

    public void ReFresh() {
        ((GaugeActivity) getActivity()).Refresh();
    }

    public static ViewGroup getParent(View view) {
        return (ViewGroup) view.getParent();
    }

    public static void removeView(View view) {
        ViewGroup parent = getParent(view);
        if (parent != null) {
            parent.removeView(view);
        }
    }

    public static void replaceView(View currentView, View newView) {
        ViewGroup parent = getParent(currentView);
        if (parent != null) {
            int index = parent.indexOfChild(currentView);
            removeView(currentView);
            removeView(newView);
            parent.addView(newView, index);
        }
    }

    private Node getParentNodeByName(String NodeName, String Attr, String AttrVal) {
        NodeList ls = this.document.getElementsByTagName(NodeName);
        for (int i = 0; i < ls.getLength(); i++) {
            if (getNodeAttr(ls.item(i), Attr).equals(AttrVal)) {
                return ls.item(i);
            }
        }
        return null;
    }

    private String getNodeAttr(Node Node, String Attr) {
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

    private List<String> ListAllAtributeByElement(Node element) {
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

    private Node getChildNodes(Node Node, String[] Attr, String[] AttrVal) {
        NodeList ls = ((Element) Node).getElementsByTagName("view");
        for (int i = 0; i < ls.getLength(); i++) {
            boolean pass = true;
            List ListAllAtributeByElement = ListAllAtributeByElement(ls.item(i));
            for (int j = 0; j < Attr.length; j++) {
                if (!getNodeAttr(ls.item(i), Attr[j]).equals(AttrVal[j])) {
                    pass = false;
                }
            }
            if (pass) {
                return ls.item(i);
            }
        }
        return null;
    }

    private void save() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(this.document), new StreamResult(new File(this.xmlFile)));
    }

    public View updateView(GaugeViewSetting mViewSetting) throws ParserConfigurationException, SAXException, IOException {
        int pPage = mViewSetting.getPageNo();
        int pRow = mViewSetting.getRowNo();
        int pCol = mViewSetting.getColNo();
        View v = this.views[pRow][pCol];
        String vAttributes = mViewSetting.getAttributes();
        SensorTypes vSensorType = mViewSetting.getSensorType();
        String vSensorTitle = mViewSetting.getSensorTitle();
        DataTypes vDataType = mViewSetting.getDataType();
        LayoutParams LayoutParam = new LayoutParams(GridLayout.spec(pRow), GridLayout.spec(pCol));
        LayoutParam.width = (this.width - (this._colCount * 10)) / this._colCount;
        LayoutParam.height = (this.height - (this._rowCount * 10)) / this._rowCount;
        LayoutParam.setMargins(5, 5, 5, 5);
        LayoutParam.setGravity(17);
        if (vDataType == DataTypes.Servo) {
            ServoView servoView = new ServoView(getActivity());
            servoView.setChValues(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            servoView.setId((pRow * 10) + pCol);
            servoView.setContentDescription("SBUSView");
            servoView.setLayoutParams(LayoutParam);
            servoView.setSensorTitle(vSensorTitle);
            servoView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((ServoView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = servoView;
            replaceView(v, servoView);
        } else if (vSensorType == SensorTypes.Temperature) {
            TemperatureView temperatureView = new TemperatureView(getActivity());
            temperatureView.setValue(0.0f);
            temperatureView.setContentDescription("SBUSView");
            temperatureView.setAttributes(vAttributes);
            temperatureView.setId((pRow * 10) + pCol);
            temperatureView.setSensorType(vSensorType);
            temperatureView.setSensorTitle(vSensorTitle);
            temperatureView.setLayoutParams(LayoutParam);
            temperatureView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((TemperatureView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = temperatureView;
            replaceView(v, temperatureView);
        } else if (vSensorType == SensorTypes.RPM) {
            RPMView rPMView = new RPMView(getActivity());
            rPMView.setAttributes(vAttributes);
            rPMView.setContentDescription("SBUSView");
            rPMView.setId((pRow * 10) + pCol);
            rPMView.setLayoutParams(LayoutParam);
            rPMView.setSensorType(vSensorType);
            rPMView.setSensorTitle(vSensorTitle);
            rPMView.setLabelConverter(new LabelConverter() {
                public String getLabelFor(double progress, double maxProgress) {
                    return String.valueOf((int) Math.round(progress));
                }
            });
            rPMView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((RPMView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = rPMView;
            replaceView(v, rPMView);
        } else if (vSensorType == SensorTypes.Altitude) {
            AltitudeView altitudeView = new AltitudeView(getActivity());
            altitudeView.setMax(10);
            altitudeView.setMin(-10);
            altitudeView.setContentDescription("SBUSView");
            altitudeView.setAttributes(vAttributes);
            altitudeView.setId((pRow * 10) + pCol);
            altitudeView.setSensorType(vSensorType);
            altitudeView.setSensorTitle(vSensorTitle);
            altitudeView.setLayoutParams(LayoutParam);
            altitudeView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((AltitudeView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = altitudeView;
            replaceView(v, altitudeView);
        } else if (vSensorType == SensorTypes.GPSLocus) {
            final GPSLocusView gpsLocusView = new GPSLocusView(getActivity());
            final int _pPage = pPage;
            final int _pRow = pRow;
            final int _pCol = pCol;
            gpsLocusView.setContentDescription("SBUSView");
            gpsLocusView.setAttributes(vAttributes);
            gpsLocusView.setId((pRow * 10) + pCol);
            gpsLocusView.setSensorType(vSensorType);
            gpsLocusView.setSensorTitle(vSensorTitle);
            gpsLocusView.setLayoutParams(LayoutParam);
            gpsLocusView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((GPSLocusView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            gpsLocusView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Parameter.GPSLocusActivityIsOpen = true;
                    Intent intent = new Intent();
                    intent.setClass(GridFragment.this.getActivity(), GPSLocusActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Attributes", gpsLocusView.getAttributes());
                    bundle.putString("Title", gpsLocusView.getSensorTitle());
                    bundle.putInt("PageNo", _pPage);
                    bundle.putInt("RowNo", _pRow);
                    bundle.putInt("ColNo", _pCol);
                    bundle.putString("LogFileName", gpsLocusView.getLogFileName());
                    bundle.putBoolean("ISWriteLog", gpsLocusView.getISWriteLog());
                    ArrayList<LatLng> list = new ArrayList<>();
                    list.addAll(gpsLocusView.getMapLists());
                    bundle.putParcelableArrayList("MapLists", list);
                    intent.putExtras(bundle);
                    GridFragment.this.getActivity().startActivityForResult(intent, 4);
                }
            });
            this.views[pRow][pCol] = gpsLocusView;
            replaceView(v, gpsLocusView);
        } else if (vSensorType == SensorTypes.GPS) {
            GPSView gpsView = new GPSView(getActivity());
            gpsView.setContentDescription("SBUSView");
            gpsView.setAttributes(vAttributes);
            gpsView.setId((pRow * 10) + pCol);
            gpsView.setSensorType(vSensorType);
            gpsView.setSensorTitle(vSensorTitle);
            gpsView.setLayoutParams(LayoutParam);
            gpsView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((GPSView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = gpsView;
            replaceView(v, gpsView);
        } else if (vSensorType == SensorTypes.Receiver || vSensorType == SensorTypes.Voltage) {
            VoltageView voltageView = new VoltageView(getActivity());
            voltageView.setId((pRow * 10) + pCol);
            voltageView.setAttributes(vAttributes);
            voltageView.setContentDescription("SBUSView");
            voltageView.setLayoutParams(LayoutParam);
            voltageView.setSensorTitle(vSensorTitle);
            voltageView.setSensorType(vSensorType);
            voltageView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((VoltageView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = voltageView;
            replaceView(v, voltageView);
        } else {
            DummyView dummyView = new DummyView(getActivity());
            dummyView.setId((pRow * 10) + pCol);
            dummyView.setAttributes(vAttributes);
            dummyView.setContentDescription("SBUSView");
            dummyView.setLayoutParams(LayoutParam);
            dummyView.setSensorTitle(vSensorTitle);
            dummyView.setSensorType(vSensorType);
            dummyView.setOnLongClickListener(new OnLongClickListener() {
                public boolean onLongClick(View v) {
                    int Id = ((DummyView) v).getId();
                    int tj = Id % 10;
                    GridFragment.this.showSubMenudialog(tj, Id / 10);
                    return true;
                }
            });
            this.views[pRow][pCol] = dummyView;
            replaceView(v, dummyView);
        }
        return v;
    }
}
