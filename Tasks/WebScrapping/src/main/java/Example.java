import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;

public class Example {
    public static void main(String[] args) {
        Crawler c = new Crawler();
        for(int i=1;i<=10;i++) {
            c.crawler("https://www.bbc.com/urdu/topics/cjgn7n9zzq7t/page/"+i,"pakistan");
        }
        for(int i=1;i<=10;i++){
            c.crawler("https://www.bbc.com/urdu/topics/cw57v2pmll9t/page/"+i,"world");
        }
        for(int i=1;i<=10;i++){
            c.crawler("https://www.bbc.com/urdu/topics/c340q0p2585t/page/"+i,"khel");
        }
        for(int i=1;i<=10;i++){
            c.crawler("https://www.bbc.com/urdu/topics/ckdxnx900n5t/page/"+i,"Fun Fankar");
        }
        for(int i=1;i<=10;i++){
            c.crawler("https://www.bbc.com/urdu/topics/c40379e2ymxt/page/"+i,"science");
        }
        c.write();
    }
}
