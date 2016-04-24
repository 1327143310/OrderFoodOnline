package com.gongxu.food.util;

import android.os.StrictMode;

import com.gongxu.food.Entity.ShopType;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/24.
 */
public class WebServiceUtil {
    private String SERVICE_NAMESPACE;
    private String SERVICE_URL;
    private String methdName;
    private HttpTransportSE ht;
    private SoapSerializationEnvelope envelope;
    private SoapObject request;
    private SoapObject result;
    public WebServiceUtil(){
        if(android.os.Build.VERSION.SDK_INT > 9 ){

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        SERVICE_NAMESPACE = "http://tempuri.org/";
        SERVICE_URL = "http://192.168.1.101:8080/WebService1.asmx";
        methdName = "getShopTypeList";
        ht = new HttpTransportSE(SERVICE_URL);
        ht.debug = true;
        envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        request = new SoapObject(SERVICE_NAMESPACE,methdName);
    }


    //获取菜系列表
    public List<String> getShopTypeList(){
       // List<ShopType> list = new ArrayList<>();
        List<String>  list = new ArrayList<>();
        envelope.bodyOut = request;
        envelope.dotNet = true;
        String soapAction = "http://tempuri.org/getShopTypeList";
        try {
            ht.call(soapAction,envelope);
            if (envelope.getResponse()!=null){
                SoapObject  body =(SoapObject) envelope.bodyIn;
                if (body!=null) {
                    result = (SoapObject) body.getProperty(0);
                }
            }else{

            }
        } catch (IOException e) {
            e.printStackTrace();

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        //把返回结果转化为List<ShopType>集合
        SoapObject iSoapObject;
        ShopType shopType = null;
        /*if(result!=null){
            for(int i=0;i<result.getPropertyCount();i++){
                iSoapObject =(SoapObject) result.getProperty(i);
                shopType = new ShopType();
                shopType.setShopTypeId(iSoapObject.getProperty("shop_type_id").toString());
                shopType.setShopTypeName(iSoapObject.getProperty("shop_type_name").toString());
                shopType.setBackUp1(iSoapObject.getProperty("backup_1").toString());
                shopType.setBackUp2(iSoapObject.getProperty("backup_2").toString());
                shopType.setBackUp3(iSoapObject.getProperty("backup_3").toString());
                list.add(shopType);
            }
        }*/

        String str = "";
        if(result!=null){
            for(int i=0;i<result.getPropertyCount();i++){
                iSoapObject =(SoapObject) result.getProperty(i);

                str = iSoapObject.getProperty("shop_type_name").toString();
                list.add(str);
            }
        }
        return list;
    }

}
