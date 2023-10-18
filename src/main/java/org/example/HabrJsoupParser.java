package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrJsoupParser {

    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/amp/publications/483202/";

        Document doc = Jsoup.connect(url).get();

        Element body = doc.body();

        String text = body.text();
        Element head = doc.getElementsByTag("head").first();
        Element title = head.getElementsByTag("title").first();

        Element element = doc.selectFirst("div.tm-article__tags");

        System.out.println("element.text() = " + element.text());
        System.out.println("title.text() = " + title.text());

        Elements subArtHeaders = doc.getElementsByTag("h3");
        Elements mainArtHeaders = doc.getElementsByTag("h2");

        System.out.println("main article header is: " + mainArtHeaders.text());

        for (Element el: subArtHeaders) {

            System.out.println("el.text() = " + el.text());
        }

    }
}
