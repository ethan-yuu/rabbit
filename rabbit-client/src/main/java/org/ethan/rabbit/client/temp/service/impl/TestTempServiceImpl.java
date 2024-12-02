package org.ethan.rabbit.client.temp.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ethan.rabbit.client.temp.client.TestTempClient;
import org.ethan.rabbit.client.temp.service.TestTempService;
import org.springframework.stereotype.Service;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/12/2 13:51
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TestTempServiceImpl implements TestTempService {

    private final TestTempClient testTempClient;

    @Override
    public void add(Object object) {
        testTempClient.add(object);
    }

    @Override
    public Object get(String id) {
        return testTempClient.get(id);
    }

    @Override
    public void delete(String id) {
        testTempClient.delete(id);
    }

    @Override
    public void update(Object object) {
        testTempClient.update(object);
    }

}
