import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {

    private LinkedList<String> urls = new LinkedList<>();

    private class UrlIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < urls.size();
        }

        @Override
        public String next() {
            StringBuilder sb = new StringBuilder();
            try {
                URL url = new URL(urls.get(index));

                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }

                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
            return sb.toString();
        }

        @Override
        public void remove() {
            urls.remove(index);
        }
    }

    public UrlLibrary() {
        urls.add("https://facebook.com");
        urls.add("https://google.com");
        urls.add("https://onet.pl");
    }

    @NotNull
    @Override
    public Iterator<String> iterator() {
        return new UrlIterator();
    }
}
