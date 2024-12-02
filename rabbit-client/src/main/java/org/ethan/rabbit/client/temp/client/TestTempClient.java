package org.ethan.rabbit.client.temp.client;

import org.ethan.rabbit.client.annotation.Remote;
import org.ethan.rabbit.client.annotation.RemoteHeader;
import org.ethan.rabbit.client.annotation.RemotePathParam;
import org.ethan.rabbit.client.annotation.RemoteRequestMapping;
import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/12/2 11:30
 */
@Remote(
        url = "http://localhost:8080/origin/test",
        headers = {
                @RemoteHeader(name = "AccessToken", value = "123456")
        })
public interface TestTempClient {

    /**
     * HTTP_CLIENT + POST
     * @param object
     */
    @RemoteRequestMapping(path = "/add", method = RequestMethod.POST)
    void add(@RequestBody Object object);

    /**
     * HTTP_CLIENT + DELETE
     * @param id
     */
    @RemoteRequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, type = HttpClientTypeEnum.HTTP_CLIENT)
    void delete(@RemotePathParam("id") String id);

    /**
     * WEB_CLIENT + PUT
     * @param object
     */
    @RemoteRequestMapping(path = "/update", method = RequestMethod.PUT, type = HttpClientTypeEnum.WEB_CLIENT)
    void update(@RequestBody Object object);

    /**
     * REST_TEMPLATE + GET
     * @param id
     * @return
     */
    @RemoteRequestMapping(path = "/get/{id}", method = RequestMethod.GET, type = HttpClientTypeEnum.REST_TEMPLATE)
    Object get(@RemotePathParam("id") String id);

}
