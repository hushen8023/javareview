package com.hushen.spiderdanmu.cnblogs;

import java.util.Set;

import org.jsoup.nodes.Document;

public class Main {
	public static void main(String[] args) {
        UrlQueue urlQueue = new UrlQueue(new String[] { "http://www.cnblogs.com/artech/" });
        JsoupDownloader downloader = JsoupDownloader.getInstance();
        long start = System.currentTimeMillis();
        while (urlQueue.getVisitedCount() < 1000) {
            String url = urlQueue.deQueue();
            if (url == null) {
                break;
            }
            Document doc = downloader.downloadPage(url);
            if (doc == null) {
                continue;
            }
            Set<String> urlSet = downloader.parsePage(doc, "(https://www.cnblogs.com/artech/p|https://www.cnblogs.com/artech/default|https://www.cnblogs.com/artech/archive/\\d{4}/\\d{2}/\\d{2}/).*");
            urlQueue.enQueue(urlSet);
            downloader.savePage(doc, "C:/Users/Sonny/Desktop/test", null, "(https://www.cnblogs.com/artech/p|https://www.cnblogs.com/artech/archive/\\d{4}/\\d{2}/\\d{2}/).*");
            System.out.println("已请求" + urlQueue.getVisitedCount() + "个页面");
        }
        long end = System.currentTimeMillis();
        System.out.println(">>>>>>>>>>抓去完成，共抓取" + urlQueue.getVisitedCount() + "到个页面，用时" + ((end - start) / 1000) + "s<<<<<<<<<<<<");
    }
}
