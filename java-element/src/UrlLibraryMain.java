public class UrlLibraryMain {

    public static void main(String[] args) {

        UrlLibrary urlLibrary = new UrlLibrary();

        for (String html: urlLibrary){
            System.out.println(html);
        }
    }
}
