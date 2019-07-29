package com.stardigitalbikes.samuelhimself.bible1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BLOCKCHAIN {
    String  previousHash,data,hash;
    int blockNumber,accesskey=1;

    String serverKey = "2y10f2Kkl1GRi5si0AAsgvsgJWyqXsUszC3DuvRLwZZ";
    String gearS;
    static JSONObject jObj = null;
    static String json = "", message;
    int availableBikes;

    public BLOCKCHAIN(String data,String previousHash,int blockNumber){
        this.data=data;
        this.previousHash=previousHash;
        this.blockNumber=blockNumber;
    }
//    public void BLOCK (){
//        int blockNo=0;
//        String data="samuel",next,hash,previous_hash;
//    }
//      previuos hash comes from database
//    and current block no
//      which are later uploaded to DB
//
//    public String add(String b){
//        int nt;
//    }
    public /*String*/ void MD5() {
        String md5=data+previousHash+blockNumber;
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            hash=sb.toString();
//            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
//        return null;
    }
    public void add(){

    }

    class backgroundblockadd extends AsyncTask<String, Void,String> {

        AlertDialog dialog;
        Context context;
        public backgroundblockadd(Context context){
            this.context=context;
        }


        @Override
        protected void onPostExecute(String s) {

        }

        @Override
        protected String doInBackground(String... voids) {
            String result="";
            String geary;

//            String acode=voids[0];


            String connstr="http://stardigitalbikes.com/block_chain_add.php";
//            String connstr="http://192.168.43.113/pdobikephp/block_chain_add.php";

            String number=Integer.toString(blockNumber);
            String acckey=Integer.toString(accesskey);

            try {
                URL url =new URL(connstr);
                HttpURLConnection http =(HttpURLConnection) url.openConnection();
                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                OutputStream ops =http.getOutputStream();
                BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
                String data = URLEncoder.encode("accesskey","UTF-8")+"="+URLEncoder.encode(acckey,"UTF-8")
                        +"&&"+ URLEncoder.encode("hash","UTF-8")+"="+URLEncoder.encode(hash,"UTF-8")
//                        +"&&"+ URLEncoder.encode("data","UTF-8")+"="+URLEncoder.encode(data,"UTF-8")
                        +"&&"+ URLEncoder.encode("blocknumber","UTF-8")+"="+URLEncoder.encode(number,"UTF-8");

                writer.write(data);
                writer.flush();
                writer.close();
                ops.close();
                Log.d("JSON Exception","DONE SENDING");

                InputStream ips =http.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
                String line ="";
                while ((line=reader.readLine()) !=null){
                    result +=line;

                }
//#######INTRODICING THE READING OOF THE RETURNED JSON
                ips.close();
                reader.close();
                json = result.toString();

                try {
                    jObj = new JSONObject(json);
                    if(json!=null){
                        int success=jObj.getInt("success");

                        Log.d("JSONStatus", "JSON RETURNED");

                    }else{
                        Log.e("JSON Parser", "RETURNED JSON IS NULL ");
                    }
                } catch (JSONException e) {
                    Log.e("JSON Parser", "Error creating the json object " + e.toString());
                }
//##################################################################33
                http.disconnect();
                return result;

            } catch (MalformedURLException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (ProtocolException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            } catch (IOException e) {
                Log.d("JSON Exception",e.toString());
                result =e.getMessage();
            }
            return result;
        }
    }

}


