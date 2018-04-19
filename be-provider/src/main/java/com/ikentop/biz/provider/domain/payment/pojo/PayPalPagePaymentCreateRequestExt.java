package com.ikentop.biz.provider.domain.payment.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tac
 * @since 04/01/2018
 */
public class PayPalPagePaymentCreateRequestExt extends PagePaymentCreateRequestExt {
//    public static final String DEFAULT_CURRENCY = "CNY";
    public static final String DEFAULT_CURRENCY = "USD";

    public void setCurrency(String currency) {
        put("currency", currency);
    }

    public String getCurrency() {
        return get("currency").toString();
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public String getDescription() {
        return get("description").toString();
    }

    public void addItem(PayPalTransactionItem item) {
        getItems().add(item);
    }

    public List<PayPalTransactionItem> getItems() {
        return (List<PayPalTransactionItem>) get("item_list");
    }

    @Override
    public void initDefault() {
        setCurrency(DEFAULT_CURRENCY);
        put("item_list", new ArrayList<PayPalTransactionItem>());
    }

    public static class PayPalTransactionItem {
        public PayPalTransactionItem() {
        }

        public PayPalTransactionItem(String name, String quantity, String price) {
            this(name, quantity, price, DEFAULT_CURRENCY);
        }

        public PayPalTransactionItem(String name, String quantity, String price, String currency) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.currency = currency;
        }

        private String name;
        private String quantity;
        private String price;
        private String currency;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }
}
