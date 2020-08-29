package com.futaba.androidmadlink.file;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import java.io.File;

public class FileDialog extends Dialog implements OnClickListener {
    public String FileName = null;
    private CellArrayAdapter mAdapter;
    private Context mContext;
    /* access modifiers changed from: private */
    public String mCurrentPath;
    private String mExtName;
    private String mFolderName;
    private OnItemClickListener mItemClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String filename = ((TextView) view.findViewById(C0112R.C0114id.listViewText)).getText().toString();
            if (new File(new StringBuilder(String.valueOf(FileDialog.this.mCurrentPath)).append("//").append(filename).toString()).isDirectory()) {
                FileDialog fileDialog = FileDialog.this;
                fileDialog.mCurrentPath = fileDialog.mCurrentPath + "/" + filename;
                FileDialog.this.updateList();
                return;
            }
            FileDialog.this.FileName = new StringBuilder(String.valueOf(FileDialog.this.mCurrentPath)).append("/").append(filename).toString();
            FileDialog.this.mOnFileOkListener.onFileDialog_FileOk();
            FileDialog.this.dismiss();
        }
    };
    private ListView mListView;
    /* access modifiers changed from: private */
    public OnFileOkListener mOnFileOkListener;
    private TextView mTxtPath;

    public FileDialog(Context context, String folderName, String extName) {
        super(context, 16973840);
        this.mContext = context;
        this.mFolderName = folderName;
        this.mExtName = extName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(4, 4);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(C0112R.layout.filedialog);
        this.mListView = (ListView) findViewById(C0112R.C0114id.lstDir_fileDialog);
        this.mTxtPath = (TextView) findViewById(C0112R.C0114id.txtPath_fileDialog);
        this.mAdapter = new CellArrayAdapter(this.mContext, C0112R.layout.listview_item);
        this.mCurrentPath = Parameter.rootPath + "/" + this.mFolderName + "/";
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mListView.setAdapter(this.mAdapter);
        ((Button) findViewById(C0112R.C0114id.btnBack)).setOnClickListener(this);
        updateList();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void setOnFileOkListener(OnFileOkListener l) {
        this.mOnFileOkListener = l;
    }

    /* access modifiers changed from: private */
    public void updateList() {
        int iconId;
        this.mAdapter.clear();
        File[] files = new File(this.mCurrentPath).listFiles();
        if (files != null && files.length != 0) {
            for (File currentFile : files) {
                if (currentFile.getName().endsWith(this.mExtName)) {
                    if (currentFile.isDirectory()) {
                        iconId = C0112R.C0113drawable.folder;
                    } else {
                        iconId = C0112R.C0113drawable.file;
                    }
                    this.mAdapter.add(new Cell(currentFile.getName(), iconId));
                }
            }
            this.mTxtPath.setText(this.mCurrentPath);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0112R.C0114id.btnBack /*2131165277*/:
                dismiss();
                return;
            default:
                return;
        }
    }
}
