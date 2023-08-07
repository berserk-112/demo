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
import com.google.gson.*;

/**
 * @author SC9621
 * Date: 2023/8/7 10:34
 **/
public class GsonTest {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"sun\", \"age\":19}";
        //jsonString to object
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        Person person = gson.fromJson(jsonString, Person.class);
        System.out.println(person.toString());

        //object to json
        jsonString = gson.toJson(person);
        System.out.println(jsonString);

        //json tree model
        JsonElement rootNode = JsonParser.parseString(jsonString);
        JsonObject details = rootNode.getAsJsonObject();
        String name = details.get("name").getAsString();
        int age = details.get("age").getAsInt();
        System.out.println("name: " + name + ", age" + age);
    }
}
