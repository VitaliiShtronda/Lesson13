package org.example;

import org.jsoup.Jsoup;

import java.io.IOException;

// к зробити запт на АРІ
public class PrivatApi {
    public static void main(String[] args) throws IOException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        String json = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        System.out.println(json);
    }
}
