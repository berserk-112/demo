package com.example.fastJSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class TestFastJson {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.nowcoder.com/api/questiontraining/coding/getQuestionTopic");
        URLConnection uc = url.openConnection();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        JSONArray jsonArray = JSONObject.parseObject(sb.toString()).getJSONObject("data").getJSONArray("menu");
        Map<String, String> map = (Map<String, String>) jsonArray.get(0);
        System.out.println(map.get("name"));
        jsonArray = JSONObject.parseObject(sb.toString()).getJSONArray("data");
        System.out.println(jsonArray.size());
    }
}
