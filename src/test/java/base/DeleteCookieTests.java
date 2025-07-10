package base;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCookieTests extends baseTests {

    @Test
    public void deleteOptimizelyBucketsCookie() {
        // 1) make sure the cookie is there
        Assert.assertTrue(isCookiePresent("optimizelyBuckets"),
                "‘optimizelyBuckets’ should exist before deletion");

        // 2) delete it
        deleteCookie("optimizelyBuckets");

        // 3) verify it’s gone
        Assert.assertFalse(isCookiePresent("optimizelyBuckets"),
                "‘optimizelyBuckets’ must be deleted");
    }
}
