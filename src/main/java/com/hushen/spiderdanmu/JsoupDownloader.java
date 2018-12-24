package com.hushen.spiderdanmu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDownloader {
	 public static final String DEFAULT_SAVE_DIR = "c:/download/";
	    private static JsoupDownloader downloader;

	    private JsoupDownloader() {
	    }

	    public static JsoupDownloader getInstance() {
	        if (downloader == null) {
	            synchronized (JsoupDownloader.class) {
	                if (downloader == null) {
	                    downloader = new JsoupDownloader();
	                }
	            }
	        }
	        return downloader;
	    }

	    public Document downloadPage(String url) {
	        try {
	            System.out.println("正在下载" + url);
	            return Jsoup.connect(url).get();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    public Set<String> parsePage(Document doc, String regex) {
	        Set<String> urlSet = new HashSet<String>();
	        if (doc != null) {
	            Elements elements = doc.select("a[href]");
	            for (Element element : elements) {
	                String url = element.attr("href");
	                if (url.length() > 6 && !urlSet.contains(url)) {
	                    if (regex != null && !url.matches(regex)) {
	                        continue;
	                    }
	                    urlSet.add(url);
	                }
	            }
	        }
	        return urlSet;
	    }

	    public void savePage(Document doc, String saveDir, String saveName, String regex) {
	        if (doc == null) {
	            return;
	        }
	        if (regex != null && doc.baseUri() != null && !doc.baseUri().matches(regex)) {
	            return;
	        }
	        saveDir = saveDir == null ? DEFAULT_SAVE_DIR : saveDir;
	        saveName = saveName == null ? doc.title().trim().replaceAll("[\\?/:\\*|<>\" ]", "_") + System.nanoTime() + ".html" : saveName;
	        File file = new File(saveDir + "/" + saveName);
	        File dir = file.getParentFile();
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        PrintWriter printWriter;
	        try {
	            printWriter = new PrintWriter(file);
	            printWriter.write(doc.toString());
	            printWriter.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
}
