package com.example.kranthi.algotest;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mRun = null;
    TextView mOut = null;
    Spinner mSpin = null;
    String pkgName = null;
    String[] mPkgs = null;

    // current resolution context configured per package, defaults to self
    AssetManager mCurAm = null;
    Resources mCurResources = null;

    public static final String MANIFEST_TAG = "Manifest Explorer";
    public static final String EXTRA_PACKAGE_NAME = "PackageToView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayAdapter<String> spinnerArrayAdapter = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initControls();

        // setup packages list for our spinner
        mPkgs = this.getPackages();
        spinnerArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, mPkgs);
        this.mSpin.setAdapter(spinnerArrayAdapter);

        if (this.getIntent() != null) {
            String name = this.getIntent().getStringExtra(EXTRA_PACKAGE_NAME);
            if (name != null) {
                Log.d(MANIFEST_TAG, "started for pkg: " + name);
                int pos = spinnerArrayAdapter.getPosition(name);
                if (pos > -1)
                    this.mSpin.setSelection(pos);
            }
        }

        this.setPkgName(mSpin.getSelectedItem().toString());
        configForPackage(this.getPkgName());
        //this.updateView();
        this.manifest();
    }

    public void openDb(){
        //this.mOut.setText("");
        ArrayList<String> list ;
        list = manifest();
        int c = list.size();
        int[] featureArray = new int[567];
        DbCreate.DbDbBHelper mDbHelper = new DbCreate.DbDbBHelper(getApplicationContext());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from permissionList ", null);
        int rows = cursor.getCount();
        cursor.moveToFirst();
        Toast.makeText(this,"here"+c,Toast.LENGTH_SHORT).show();
        if(list.isEmpty()){
            Toast.makeText(this,"List is empty",Toast.LENGTH_SHORT).show();
            }
        else {
            if (rows != 567) {
                cursor.close();
                db.close();
                dbPopulate();
                openDb();
            }
            else {
                int i = 0;
                while (!(cursor.isAfterLast())) {
                    String per = (cursor.getString(1)).trim();
                    //Toast.makeText(this,per,Toast.LENGTH_SHORT).show();
                    //this.mOut.append(per);
                    if(list.contains(per)){
                        featureArray[i++]=1;
                        //int test = featureArray[174];

                        //Toast.makeText(this,"Main activity index ="+i+"= 1" ,Toast.LENGTH_LONG).show();
                        //this.mOut.append(cursor.getString(0)+" - "+featureArray[i]+" ");
                        //i++;
                    }
                    else {
                        featureArray[i++]=0;
                    }
                        cursor.moveToNext();
                    }
                cursor.close();
                db.close();
                Intent intent = new Intent(MainActivity.this,Classification.class);
                intent.putExtra("fa",featureArray);
                startActivity(intent);

                }
        }
    }

    public void dbPopulate(){

        AssetManager am = getAssets();
        try {
            InputStream is = am.open("permissions.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            DbCreate.DbDbBHelper mDbHelper = new DbCreate.DbDbBHelper(getApplicationContext());
            SQLiteDatabase db = mDbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            String line =  reader.readLine();
            db.delete("permissionList",null,null);
            while(line != null) {
                values.put("permission", line);
                db.insert("permissionList",null,values);
                line =  reader.readLine();
            }
            //String path = db.getPath();
            is.close();
            Toast.makeText(this,"dbpopulate",Toast.LENGTH_LONG).show();
        } catch (java.io.IOException io){
            io.printStackTrace();
            //Toast.makeText(this,"failed",Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(this,"method called",Toast.LENGTH_LONG).show();

    }


    protected void initControls() {
        this.mRun = (Button) this.findViewById(R.id.run);
        this.mOut = (TextView) this.findViewById(R.id.output);
        this.mSpin = (Spinner) this.findViewById(R.id.toDump);

        mRun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setPkgName(mSpin.getSelectedItem().toString());
                configForPackage(getPkgName());
                //updateView();
               openDb();
            }
        });

    }

    protected boolean configForPackage(String packageName) {
        if (packageName == null || packageName == "")
            packageName = "android";
        AssetManager initAM = mCurAm;
        Resources initRes = mCurResources;
        try {
            mCurAm = createPackageContext(packageName, 0).getAssets();
            mCurResources = new Resources(mCurAm, getResources()
                    .getDisplayMetrics(), null);
        } catch (PackageManager.NameNotFoundException name) {
            Toast.makeText(this, "Error, couldn't create package context: "
                    + name.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            mCurAm = initAM;
            mCurResources = initRes;
            return false;
        } catch (RuntimeException unexpected) {
            Log.e(MANIFEST_TAG, "error configuring for package: " + packageName
                    + " " + unexpected.getMessage());
            mCurAm = initAM;
            mCurResources = initRes;
            return false;
        }
        return true;
    }


    protected String[] getPackages() {
        ArrayList<String> res = new ArrayList<String>();
        List<PackageInfo> l = getPackageManager().getInstalledPackages(
                0xFFFFFFFF);
        for (PackageInfo pi : l)
            res.add(pi.packageName);
        return res.toArray(new String[res.size()]);
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public ArrayList<String> manifest(){
        this.mOut.setText("");
        ArrayList<String> permissionSet = new ArrayList<>();
        try {
            XmlResourceParser manifestfile = mCurAm.openXmlResourceParser("AndroidManifest.xml");
            //Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
            int eventtype = -1;
            while(eventtype != XmlResourceParser.END_DOCUMENT) {

                try {
                    if(manifestfile.getEventType() == XmlResourceParser.START_TAG) {
                        String per = manifestfile.getName();
                        // Toast.makeText(this,per,Toast.LENGTH_SHORT).show();
                        if((per.equals("uses-permission"))||(per.equals("permission"))||(per.equals("meta-data"))||(per.equals("activity"))
                                ||(per.equals("action"))||(per.equals("receiver"))||(per.equals("service"))){
                            for (int i = 0; i < manifestfile.getAttributeCount(); i++) {
                                String permission = manifestfile.getAttributeName(i);
                                if(permission.equals("name")){
                                    String str = manifestfile.getAttributeValue(i);
                                    permissionSet.add(str);
                                    // Toast.makeText(this, "success   " +str, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    }
                } catch (org.xmlpull.v1.XmlPullParserException xpe){
                    xpe.printStackTrace();
                }
                try {
                    eventtype = manifestfile.next();
                }catch (org.xmlpull.v1.XmlPullParserException x){
                    x.printStackTrace();
                }

            }



            // for(int j=0; j < permissionSet.size();j++){
             //   this.mOut.append(permissionSet.get(j));
                //Toast.makeText(this,permissionSet.get(j),Toast.LENGTH_SHORT).show();
            //}
            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }catch (java.io.IOException ioe){
            ioe.printStackTrace();
            Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();
        }

        return permissionSet;
    }


}
