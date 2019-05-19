package net.mlike.chenhui.one.util;

import java.io.IOException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jdiy.json.JsonObject;
import org.jdiy.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTool
{
    private static Logger LOG = LoggerFactory.getLogger(ApiTool.class);
    String surl = "";

    public ApiTool(String url)
    {
        this.surl = url;
    }

    public String getJson(String rstr, String rstrpara)
            throws Exception
    {
        JsonObject jsonobj = (JsonObject)JsonUtil.parse(rstr);
        String jsonstr = "";
        if (jsonobj.get(rstrpara) != null) {
            jsonstr = jsonobj.get(rstrpara).toString();
        }
        return jsonstr;
    }

    public String getToken(String authstr, String accInfo)
            throws Exception
    {
        String token = "";
        PostMethod method = new PostMethod();
        HttpClient client = new HttpClient();
        try
        {
            method.setURI(new URI(this.surl + "collaborationapp/GetRealNameTPlusToken?IsFree=1"));
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            method.addRequestHeader("Authorization", authstr);

            method.addParameter("_args", accInfo);

            client.executeMethod(method);

            return method.getResponseBodyAsString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            method.releaseConnection();
        }
        return token;
    }

    public Object getJson(String methodName, String authstr, String paras)
            throws Exception
    {
        return JSON.fromJSON(getData(methodName, authstr, paras));
    }

    public String getData(String methodName, String authstr, String paras)
            throws Exception
    {
        String retValue = "";
        PostMethod method = new PostMethod();
        try
        {
            HttpClient client = new HttpClient();
            method.setURI(new URI(this.surl + methodName));
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            method.addRequestHeader("Authorization", authstr);

            method.addParameter("_args", paras);
            client.executeMethod(method);


            retValue = method.getResponseBodyAsString();
            if (LOG.isWarnEnabled())
            {
                LOG.warn("----------------------------------------------");
                LOG.warn("Method {}", methodName);
                LOG.warn("_args {}", paras);
                LOG.warn("result {}", retValue);
            }
        }
        catch (IOException e)
        {
            LOG.warn(e.getMessage(), e);
        }
        finally
        {
            method.releaseConnection();
        }
        return retValue;
    }

    public String getData2(String methodName, String authstr, Object paras)
            throws Exception
    {
        String retValue = "";
        PostMethod method = new PostMethod();
        try
        {
            HttpClient client = new HttpClient();
            method.setURI(new URI(this.surl + methodName));
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            method.addRequestHeader("Authorization", authstr);
            method.setRequestBody("_args=" + JSON.toJSON(paras));
            client.executeMethod(method);


            retValue = method.getResponseBodyAsString();
            if (LOG.isWarnEnabled())
            {
                LOG.warn("----------------------------------------------");
                LOG.warn("Method {}", methodName);
              //  LOG.warn("_args {}", JSON.toJSON(new ApiTool.1Args(this, paras)));
                LOG.warn("result {}", retValue);
            }
        }
        catch (IOException e)
        {
            LOG.warn(e.getMessage(), e);
        }
        finally
        {
            method.releaseConnection();
        }
        return retValue;
    }

    public Object getJson2(String methodName, String authstr, Object paras)
            throws Exception
    {
        return JSON.fromJSON(getData2(methodName, authstr, paras));
    }
}
