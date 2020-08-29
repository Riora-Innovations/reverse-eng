package com.futaba.androidmadlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.view.ViewPager;
import android.support.p000v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.futaba.androidmadlink.config.GaugePageSetting;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.constant.ArgumentKey;
import com.futaba.androidmadlink.data.WriteLog;
import com.futaba.androidmadlink.dialog.ItemFragment;
import com.futaba.androidmadlink.fragment.GaugePagerAdapter;
import com.futaba.androidmadlink.fragment.GridFragment;
import com.futaba.androidmadlink.service.ViewDataService;
import com.futaba.androidmadlink.view.DataTypes;
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

public class GaugeActivity extends BaseActivity {
    private static boolean _isWriteLog = false;
    private static String _logFileName;
    public static Intent dataService = null;
    public static int handleFLAG = 1;
    public static int handleNoSignal = 2;
    public static Handler handler;
    public static boolean handlerStatus = false;
    public static GaugePagerAdapter mGaugePagerAdapter;
    public static MediaPlayer mediaPlayer;
    public static Vibrator myVibrator = null;
    GridFragment _currentFragment = null;
    /* access modifiers changed from: private */
    public boolean alertStutas = false;
    private Document document = null;
    int mAlertFlag = 0;
    BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    GaugeActivity.this.startService(GaugeActivity.dataService);
                    GaugeActivity.handlerStatus = true;
                    GaugeActivity.this.ftdiAdapter.Connect();
                    Toast.makeText(context, "USB Attached", 1).show();
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    GaugeActivity.this.ftdiAdapter.Disconnect();
                    Toast.makeText(context, "USB Detached", 1).show();
                    GaugeActivity.this.finish();
                }
            } catch (Exception e) {
            }
        }
    };
    ViewPager mViewPager;
    /* access modifiers changed from: private */
    public Menu menu = null;
    int tpage = 1;
    final String xmlFile = Parameter.rootGaugeFile;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        setContentView(C0112R.layout.gauge);
        mediaPlayer = new MediaPlayer();
        getWindow().setFlags(1024, 1024);
        dataService = new Intent(this, ViewDataService.class);
        myVibrator = (Vibrator) getApplication().getSystemService("vibrator");
        mGaugePagerAdapter = new GaugePagerAdapter(getSupportFragmentManager());
        this.mViewPager = (ViewPager) findViewById(C0112R.C0114id.pager);
        this.mViewPager.setAdapter(mGaugePagerAdapter);
        this.mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            public void onPageSelected(int arg0) {
                GaugeActivity.this._currentFragment = (GridFragment) GaugeActivity.mGaugePagerAdapter.getItem(arg0);
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
        handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                GridFragment fragment = (GridFragment) GaugeActivity.this.getSupportFragmentManager().findFragmentByTag("android:switcher:2131165282:" + GaugeActivity.this.mViewPager.getCurrentItem());
                if (GaugeActivity.handlerStatus && msg.what == GaugeActivity.handleFLAG) {
                    try {
                        Object[] objArr = new Object[2];
                        Object[] msgStutas = (Object[]) msg.obj;
                        GaugeActivity.this.alertStutas = ((Boolean) msgStutas[0]).booleanValue();
                        switch (((Integer) msgStutas[1]).intValue()) {
                            case 1:
                                GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate1);
                                break;
                            case 2:
                                GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate2);
                                break;
                            case 3:
                                GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate3);
                                break;
                            case 4:
                                GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate4);
                                break;
                            default:
                                GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate0);
                                break;
                        }
                        fragment.setViewValue(GaugeActivity.this.alertStutas);
                        if (GaugeActivity.this.alertStutas && GaugeActivity.this.mAlertFlag == 0) {
                            GaugeActivity.this.AlertSoundPlay();
                            GaugeActivity.this.mAlertFlag = 1;
                        } else if (!GaugeActivity.this.alertStutas && GaugeActivity.mediaPlayer.isPlaying()) {
                            GaugeActivity.mediaPlayer.stop();
                            GaugeActivity.this.mAlertFlag = 0;
                        }
                    } catch (Exception e) {
                        Log.d(Parameter.TAG, "GaugeActivity handleMessage :" + e.getMessage());
                    }
                } else if (GaugeActivity.handlerStatus && msg.what == GaugeActivity.handleNoSignal) {
                    if (GaugeActivity.mediaPlayer.isPlaying()) {
                        GaugeActivity.mediaPlayer.stop();
                    }
                    GaugeActivity.this.mAlertFlag = 0;
                    GaugeActivity.this.menu.findItem(C0112R.C0114id.action_Rate).setIcon(C0112R.C0113drawable.rate0);
                    GaugeActivity.this.alertStutas = false;
                    fragment.setViewValue(GaugeActivity.this.alertStutas);
                }
            }
        };
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "GaugeActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(Parameter.TAG, "GaugeActivity.onPause()");
        try {
            handlerStatus = false;
        } catch (Exception e) {
        }
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "GaugeActivity.onStop()");
        try {
            unregisterReceiver(this.mUsbReceiver);
            this.mAlertFlag = 0;
            mediaPlayer.stop();
            if (!Parameter.GPSLocusActivityIsOpen) {
                this.ftdiAdapter.Disconnect();
            }
        } catch (Exception e) {
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        filter.setPriority(500);
        registerReceiver(this.mUsbReceiver, filter);
        if (Parameter.GPSLocusActivityIsOpen) {
            Parameter.GPSLocusActivityIsOpen = false;
            if (!this.ftdiAdapter.isConnected()) {
                finish();
            }
        }
        if (!this.ftdiAdapter.isConnected()) {
            this.ftdiAdapter.Connect();
        }
        if (this.ftdiAdapter.isConnected()) {
            startService(dataService);
            handlerStatus = true;
        }
        Log.d(Parameter.TAG, "GaugeActivity.onResume()");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onResume();
        try {
            handlerStatus = false;
            stopService(dataService);
            _isWriteLog = false;
        } catch (Exception e) {
        }
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        this.menu = menu2;
        getMenuInflater().inflate(C0112R.menu.gauge_main, menu2);
        return true;
    }

    public String getViewData() {
        String viewDataString = "" + "{\"views\":[";
        int count = 0;
        for (GaugePageSetting mPagerSetting : mGaugePagerAdapter.getPageSettingList()) {
            for (GaugeViewSetting mViewSetting : mPagerSetting.getGaugeViewList()) {
                try {
                    if (!(mViewSetting.getDataType() == null || mViewSetting.getDataType() == DataTypes.Servo)) {
                        if (count != 0) {
                            viewDataString = new StringBuilder(String.valueOf(viewDataString)).append(",").toString();
                        }
                        viewDataString = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(viewDataString)).append("{").toString())).append("\"SensorTitle\":\"").append(mViewSetting.getSensorTitle()).append("\"").toString())).append(",\"DataTypes\":\"").append(mViewSetting.getDataType()).append("\"").toString())).append(",\"SensorType\":\"").append(mViewSetting.getSensorType()).append("\"").toString())).append(",\"Attributes\":\"").append(mViewSetting.getAttributes()).append("\"").toString())).append("}").toString();
                        count++;
                    }
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "GaugeActivity WriteLog getViewData Error:" + e.getMessage());
                }
            }
        }
        return new StringBuilder(String.valueOf(viewDataString)).append("]}").toString();
    }

    public static boolean IsWriteLog() {
        return _isWriteLog;
    }

    public static String getLogFileName() {
        return _logFileName;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0112R.C0114id.action_Write /*2131165340*/:
                this.menu.findItem(C0112R.C0114id.action_Write).setVisible(false);
                this.menu.findItem(C0112R.C0114id.action_Stop).setVisible(true);
                _isWriteLog = true;
                _logFileName = WriteLog.setLogName(getViewData());
                break;
            case C0112R.C0114id.action_Stop /*2131165341*/:
                this.menu.findItem(C0112R.C0114id.action_Write).setVisible(true);
                this.menu.findItem(C0112R.C0114id.action_Stop).setVisible(false);
                _isWriteLog = false;
                _logFileName = "";
                break;
            case C0112R.C0114id.action_addpage /*2131165343*/:
                showdialog(mGaugePagerAdapter.getCount() + 1);
                break;
            case C0112R.C0114id.action_delpage /*2131165344*/:
                mGaugePagerAdapter.deletePage(this.mViewPager.getCurrentItem() + 1);
                mGaugePagerAdapter.resetAllSlots();
                mGaugePagerAdapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Refresh() {
        mGaugePagerAdapter.notifyDataSetChanged();
    }

    public void showdialog(int page) {
        DialogFragment prodDialog = ItemFragment.newInstance();
        Bundle bundle = prodDialog.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            prodDialog.setArguments(bundle);
        }
        bundle.putString(ArgumentKey.Key_Page, String.valueOf(page));
        prodDialog.setTargetFragment(getSupportFragmentManager().findFragmentByTag("android:switcher:2131165282:" + this.mViewPager.getCurrentItem()), 1);
        prodDialog.show(getSupportFragmentManager(), ItemFragment.TAG);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        int Rows;
        if (resultCode == -1) {
            switch (requestCode) {
                case 1:
                    GaugePageSetting pageSetting = new GaugePageSetting();
                    String Type = intent.getExtras().getString(ArgumentKey.Key_ItemCode);
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
                    pageSetting.setPageNo(mGaugePagerAdapter.getCount() + 1);
                    pageSetting.setColCount(Cols);
                    pageSetting.setRowCount(Rows);
                    mGaugePagerAdapter.addPage(pageSetting);
                    mGaugePagerAdapter.notifyDataSetChanged();
                    break;
            }
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("android:switcher:2131165282:" + this.mViewPager.getCurrentItem());
            if (fragment != null) {
                fragment.onActivityResult(requestCode, resultCode, intent);
            }
        }
    }

    private void SetXml() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(this.xmlFile));
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
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

    private void AddXml(int rows) {
        try {
            Element root = (Element) this.document.getElementsByTagName("PageSettings");
            Element Node_Page = createContactNode("page", new String[]{"id", "cols", "rows"}, new String[]{String.valueOf(this.tpage), "2", String.valueOf(rows)});
            root.appendChild(Node_Page);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < 2; j++) {
                    Element Node_View = createContactNode("view", new String[]{"ColNo", "RowNo", "ColSpan", "RowSpan"}, new String[]{String.valueOf(i), String.valueOf(j), "1", "1"});
                    Element DataType = this.document.createElement("DataType");
                    DataType.appendChild(this.document.createTextNode("Servo"));
                    Node_View.appendChild(DataType);
                    Element Attributes = this.document.createElement("Attributes");
                    Attributes.appendChild(this.document.createTextNode(" "));
                    Node_View.appendChild(Attributes);
                    Node_Page.appendChild(Node_View);
                }
            }
            this.document.appendChild(root);
            save();
        } catch (Exception e) {
        }
    }

    public Element createContactNode(String NodeName, String[] AttrName, String[] AttrValue) throws Exception {
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

    private void save() throws TransformerException {
        TransformerFactory.newInstance().newTransformer().transform(new DOMSource(this.document), new StreamResult(new File(this.xmlFile)));
    }

    /* access modifiers changed from: private */
    public void AlertSoundPlay() {
        String filePath;
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            String str = "";
            if (Parameter.getAlertSound().equals("")) {
                filePath = Parameter.getDefoulAlertSound();
            } else {
                filePath = Parameter.getAlertSound();
            }
            mediaPlayer.setDataSource(this, Uri.parse(filePath));
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        } catch (Exception e) {
            Log.d(Parameter.TAG, "GaugeActivity Alert Sound Play Error:" + e.getMessage());
        }
    }
}
