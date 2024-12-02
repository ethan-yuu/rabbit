package org.ethan.rabbit.client.temp.controller;

import lombok.RequiredArgsConstructor;
import org.ethan.rabbit.client.common.model.Result;
import org.ethan.rabbit.client.temp.service.TestTempService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/22 10:54
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestTempController {

    private final TestTempService testTempService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Object object) {
        Result<Object> result = new Result<>();
        testTempService.add(object);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id) {
        Result<Object> result = new Result<>();
        testTempService.delete(id);
        return result;
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Result update(@RequestBody Object object) {
        Result<Object> result = new Result<>();
        testTempService.update(object);
        return result;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        Result<Object> result = new Result<>();
        result.setData(testTempService.get(id));
        return result;
    }

}
