// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostHttp
{

    private PostHttp()
    {
    }

    public static String func_52008_a(Map p_52008_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = p_52008_0_.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }
            try
            {
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch(UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }
            if(entry.getValue() != null)
            {
                stringbuilder.append('=');
                try
                {
                    stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
                catch(UnsupportedEncodingException unsupportedencodingexception1)
                {
                    unsupportedencodingexception1.printStackTrace();
                }
            }
        } while(true);
        return stringbuilder.toString();
    }

    public static String func_52010_a(URL p_52010_0_, Map p_52010_1_, boolean p_52010_2_)
    {
        return func_52009_a(p_52010_0_, func_52008_a(p_52010_1_), p_52010_2_);
    }

    public static String func_52009_a(URL p_52009_0_, String p_52009_1_, boolean p_52009_2_)
    {
        try
        {
            String s = p_52009_1_;
            HttpURLConnection httpurlconnection = (HttpURLConnection)p_52009_0_.openConnection();
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append("").append(s.getBytes().length).toString());
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
            dataoutputstream.writeBytes(s);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();
            String s1;
            while((s1 = bufferedreader.readLine()) != null) 
            {
                stringbuffer.append(s1);
                stringbuffer.append('\r');
            }
            bufferedreader.close();
            return stringbuffer.toString();
        }
        catch(Exception exception)
        {
            if(!p_52009_2_)
            {
                Logger.getLogger("Minecraft").log(Level.SEVERE, (new StringBuilder()).append("Could not post to ").append(p_52009_0_).toString(), exception);
            }
        }
        return "";
    }
}
