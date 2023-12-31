package com.clinic.configuration;

import org.testng.annotations.DataProvider;

import com.clinic.pageelement.Common;

public class DataProviderFactory {

    @DataProvider(name = "dp_login")
    public Object[][] dataLogin() throws Exception {
        Common common = Common.getInstant();
        Object[][] data = common.getDataInSheet("Sign_In");
        Log.debug("Get data from excel: " + data.length);
        return data;
    }

}
