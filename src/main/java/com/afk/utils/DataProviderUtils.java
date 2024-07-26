package com.afk.utils;

import com.afk.testdata.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.TestDataReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;

public class DataProviderUtils {

    @DataSupplier(runInParallel = true)
    public StreamEx<TestData> getData() {
        return TestDataReader.use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }
}
