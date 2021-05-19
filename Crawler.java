import java.io.*;
import java.util.Scanner;

public class Crawler {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner c = new Scanner(System.in);
        System.out.println("Глубина");
        int depth = c.nextInt();
        c = new Scanner(System.in);
        System.out.println("Ссылка");
        String httpPage = c.nextLine();
        System.out.println("Кол-во потоков");
        int threads = c.nextInt();
        URLPool pool = new URLPool(httpPage, depth, threads);
        for (int i = 0; i < threads; i++) {
            CrawlerTask crawler = new CrawlerTask(pool);
            new Thread(crawler).start();
        }
    }
}