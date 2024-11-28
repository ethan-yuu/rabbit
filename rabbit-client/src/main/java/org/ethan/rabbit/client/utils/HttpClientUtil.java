package org.ethan.rabbit.client.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/19 09:41
 */

@Component
@Slf4j
public class HttpClientUtil {

    @Autowired
    private CloseableHttpClient httpClient;

    /**========================== GET ==========================**/

    public String doGet(String url, Map<String, String> param) {
        return doGet(url, param, null);
    }

    public String doGet(String url, Map<String, String> param, Map<String, String> headers) {
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(buildHttpUri(url, param));
            if (headers != null) {
                headers.entrySet().stream().forEach(entry -> httpGet.addHeader(entry.getKey(), entry.getValue()));
            }
            response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(response);
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**========================== POST ==========================**/

    public String doPost(String url, Map<String, String> param, Object object) {
        return doPost(url, param, null, object);
    }

    public String doPost(String url, Map<String, String> param, Map<String, String> headers, Object object) {
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(buildHttpUri(url, param));
            if (headers != null) {
                headers.entrySet().stream().forEach(entry -> httpPost.addHeader(entry.getKey(), entry.getValue()));
            }
            StringEntity stringEntity = new StringEntity(object.toString(), ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(response);
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**========================== PUT ==========================**/

    public String doPut(String url, Map<String, String> param, Object object) {
        return this.doPut(url, param, null, object);
    }

    public String doPut(String url, Map<String, String> param, Map<String, String> headers, Object object) {
        CloseableHttpResponse response = null;
        try {
            HttpPut httpPut = new HttpPut(buildHttpUri(url, param));
            if (headers != null) {
                headers.entrySet().stream().forEach(entry -> httpPut.setHeader(entry.getKey(), entry.getValue()));
            }
            StringEntity stringEntity = new StringEntity(object.toString(), ContentType.APPLICATION_JSON);
            httpPut.setEntity(stringEntity);
            response = httpClient.execute(httpPut);
            return EntityUtils.toString(response.getEntity(), "UTF_8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(response);
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**========================== DELETE ==========================**/

    public String doDelete(String url, Map<String, String> param) {
        return this.doDelete(url, param, null);
    }

    public String doDelete(String url, Map<String, String> param, Map<String, String> headers) {
        CloseableHttpResponse response = null;
        try {
            HttpDelete httpDelete = new HttpDelete(buildHttpUri(url, param));
            if (headers != null) {
                headers.entrySet().stream().forEach(entry -> httpDelete.addHeader(entry.getKey(), entry.getValue()));
            }
            response = httpClient.execute(httpDelete);
            return EntityUtils.toString(response.getEntity(), "UTF_8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                close(response);
                httpClient.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void close(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @SneakyThrows
    private URI buildHttpUri(String url, Map<String, String> param) {
        if (StringUtils.isBlank(url)){
            throw new RuntimeException("url 参数异常");
        }
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setPath(url);
        if (param != null) {
            param.entrySet().forEach(entry ->
                    uriBuilder.addParameter(entry.getKey(), entry.getValue()));
        }
        uriBuilder.setCharset(Charset.forName("utf-8"));
        return uriBuilder.build();
    }

}
