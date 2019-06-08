package lib;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class UrlCompleteTest extends TestCase {

    @Test
    public void testShouldCompleteUrlWithHttp() {
        String url = UrlComplete.complete("www.google.com.br");
        System.out.println(url);
        assertEquals("http://www.google.com.br/", url);
    }
    
    @Test
    public void testShouldCompleteUrlWithWWW() {
        String url = UrlComplete.complete("google.com.br");
        System.out.println(url);
        assertEquals("http://www.google.com.br/", url);
    }
            
}
