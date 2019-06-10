package lib.util;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class CoalesceTest extends TestCase {

    @Test
    public void testShouldReturnFirstNotNull() {
        int result = Coalesce.get(null, null, 1, null, 2, null);
        assertEquals(1, result);
    }
}

