package com.ikentop.biz.client.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tac
 * @since 26/12/2017
 */
public class EncodeUtilsTest {
    private Logger logger = LoggerFactory.getLogger(EncodeUtilsTest.class);

    @Test
    public void toQueryMap() {
        FooModel model = new FooModel("val1", "val2");
        logger.debug("transfer model to query map");
        Map<String, Object> queryMap = EncodeUtils.toQueryMap(model);
        logger.trace("queryMap: {}", queryMap);
        assertThat(queryMap).containsKeys("bar1", "bar2");
        assertThat(queryMap).containsValues("val1", "val2");
    }

    @Test
    public void toQueryMapWhenContainNullValue() {
        FooModel model = new FooModel("val1", null);
        logger.debug("transfer model to query map");
        Map<String, Object> queryMap = EncodeUtils.toQueryMap(model);
        logger.trace("queryMap: {}", queryMap);
        assertThat(queryMap).doesNotContainKey("bar2");
        assertThat(queryMap).doesNotContainValue("val2");
    }

    @Test
    public void toQueryMapContainParentFields() {
        ChildFooModel model = new ChildFooModel("val1", "val2", "val3");
        logger.debug("transfer model to query map with parent's fields");
        Map<String, Object> queryMap = EncodeUtils.toQueryMap(model);
        logger.trace("queryMap: {}", queryMap);
        assertThat(queryMap).containsKeys("bar1", "bar2", "bar3");
        assertThat(queryMap).containsValues("val1", "val2", "val3");
    }

    @Test
    public void toQueryString() throws Exception {
        FooModel model = new FooModel("val1", "val2");
        logger.debug("transfer model to query string");
        String queryString = EncodeUtils.toQueryString(model);
        logger.trace("queryString: {}", queryString);
        assertThat(queryString).isEqualTo("bar1=val1&bar2=val2");
    }

    @Test
    public void toQueryStringWhenContainNullValue() throws Exception {
        FooModel model = new FooModel("val1", null);
        logger.debug("transfer model to query string");
        String queryString = EncodeUtils.toQueryString(model);
        logger.trace("queryString: {}", queryString);
        assertThat(queryString).isEqualTo("bar1=val1");
    }

    @Test
    public void toQueryStringContainParentFields() {
        ChildFooModel model = new ChildFooModel("val1", "val2", "val3");
        logger.debug("transfer model to query map with parent's fields");
        String queryString = EncodeUtils.toQueryString(model);
        logger.trace("queryString: {}", queryString);
        assertThat(queryString).contains("bar1=val1");
        assertThat(queryString).contains("bar2=val2");
        assertThat(queryString).contains("bar3=val3");
    }

    @Test
    public void initialToUpperCase() throws Exception {
        String fieldName = "bar1";
        assertThat(EncodeUtils.initialToUpperCase(fieldName)).isEqualTo("Bar1");
    }

    public static class FooModel {
        public FooModel(String bar1, String bar2) {
            this.bar1 = bar1;
            this.bar2 = bar2;
        }

        private String bar1;
        private String bar2;

        private String _bar;

        public String getBar1() {
            return bar1;
        }

        public void setBar1(String bar1) {
            this.bar1 = bar1;
        }

        public String getBar2() {
            return bar2;
        }

        public void setBar2(String bar2) {
            this.bar2 = bar2;
        }
    }

    public static class ChildFooModel extends FooModel {
        public ChildFooModel(String bar1, String bar2, String bar3) {
            super(bar1, bar2);
            this.bar3 = bar3;
        }

        private String bar3;

        public String getBar3() {
            return bar3;
        }

        public void setBar3(String bar3) {
            this.bar3 = bar3;
        }
    }
}

