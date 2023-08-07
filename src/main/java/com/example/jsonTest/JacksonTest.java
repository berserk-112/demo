/*
 * Copyright (C) 2014 - 2034 万帮星星充电科技有限公司 <starcharge@wanbangauto.com>
 *
 * ====================================================================
 * 代码版权归【万帮星星充电科技有限公司】所有，盗版必究
 * 【万帮星星充电科技有限公司】保留最终解释权
 * ====================================================================
 */

package com.example.jsonTest;

import com.example.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

/**
 * @author SC9621
 * Date: 2023/8/7 9:46
 **/
public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"name\":\"sun\", \"age\":19}";

        //Tree Model
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String name = jsonNode.get("name").asText();
        System.out.println(name);

        //json里的字段在类中必须有个对应的get or set方法,jsonString to a object
        Person person = objectMapper.readValue(jsonString, Person.class);
        System.out.println(person.toString());
        System.out.println(name);

        //object to jsonString
        Person xMan = new Person("xx", 12);
        String xManJson = objectMapper.writeValueAsString(xMan);
        System.out.println(xManJson);
    }
}
