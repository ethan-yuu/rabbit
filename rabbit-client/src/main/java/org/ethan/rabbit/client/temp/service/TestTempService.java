package org.ethan.rabbit.client.temp.service;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/12/2 13:51
 */
public interface TestTempService {

    void add(Object object);

    Object get(String id);

    void delete(String id);

    void update(Object object);

}
