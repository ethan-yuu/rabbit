package org.ethan.rabbit.client.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ethan.rabbit.client.proxy.HttpClientProxy;
import org.springframework.beans.factory.FactoryBean;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/13 10:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpClientFactoryBean<T> implements FactoryBean<T> {

    private Class httpclientClz;


    @Override
    public T getObject() throws Exception {
        return (T) new HttpClientProxy().getInstance(httpclientClz);
    }

    @Override
    public Class<?> getObjectType() {
        return httpclientClz;
    }
}
