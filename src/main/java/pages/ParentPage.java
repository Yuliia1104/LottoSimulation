package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class ParentPage extends CommonActionWithElements {
    protected String base_url;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        base_url = configProperties.base_url();
    }

    protected abstract String getRelativeUrl();

    public void checkURL() {
        Assert.assertEquals("Invalid URL", base_url + getRelativeUrl(), webDriver.getCurrentUrl());
        logger.info("URL is equal " + base_url+getRelativeUrl());
    }

}

