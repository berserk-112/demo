package com.example.testJsoup;

import org.apache.http.client.utils.URLEncodedUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.util.UriBuilder;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class TestJsoup {
    public static void main(String[] args) throws IOException, URISyntaxException {
/*
        Document doc = Jsoup.connect("https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca").get();
        log(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            log("%s\n\t%s",
                    headline.attr("title"), headline.absUrl("href"));
        }
*/
        URI uri = new URI("sss");
        URIBuilder uriBuilder = new URIBuilder(uri);
        uriBuilder.addParameter("pageSize", null);
        System.out.println(uriBuilder);
        System.out.println(URLEncoder.encode("sjj kjk", StandardCharsets.UTF_8.toString()));

    }
    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
