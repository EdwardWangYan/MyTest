package com.ikentop.biz.provider.domain.payment;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tac
 * @since 04/01/2018
 */
@ConfigurationProperties(prefix = "payment")
public class PaymentProperties {
    private String domain;
    private Boolean sandbox = false;
    private AliPay aliPay = new AliPay();
    private WxPay wxPay = new WxPay();
    private PayPal payPal = new PayPal();

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Boolean getSandbox() {
        return sandbox;
    }

    public void setSandbox(Boolean sandbox) {
        this.sandbox = sandbox;
    }

    public AliPay getAliPay() {
        return aliPay;
    }

    public void setAliPay(AliPay aliPay) {
        this.aliPay = aliPay;
    }

    public WxPay getWxPay() {
        return wxPay;
    }

    public void setWxPay(WxPay wxPay) {
        this.wxPay = wxPay;
    }

    public PayPal getPayPal() {
        return payPal;
    }

    public void setPayPal(PayPal payPal) {
        this.payPal = payPal;
    }

    public static class AliPay {
        private String appId;
        private String privateKey;
        private String alipayPublicKey;
        private Sandbox sandbox = new Sandbox();

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String privateKey) {
            this.privateKey = privateKey;
        }

        public String getAlipayPublicKey() {
            return alipayPublicKey;
        }

        public void setAlipayPublicKey(String alipayPublicKey) {
            this.alipayPublicKey = alipayPublicKey;
        }

        public Sandbox getSandbox() {
            return sandbox;
        }

        public void setSandbox(Sandbox sandbox) {
            this.sandbox = sandbox;
        }

        public static class Sandbox {
            private String appId;
            private String privateKey;
            private String alipayPublicKey;

            public String getAppId() {
                return appId;
            }

            public void setAppId(String appId) {
                this.appId = appId;
            }

            public String getPrivateKey() {
                return privateKey;
            }

            public void setPrivateKey(String privateKey) {
                this.privateKey = privateKey;
            }

            public String getAlipayPublicKey() {
                return alipayPublicKey;
            }

            public void setAlipayPublicKey(String alipayPublicKey) {
                this.alipayPublicKey = alipayPublicKey;
            }
        }
    }

    public static class WxPay {
        private String appId;
        private String mchId;
        private String appSecret;
        private String certPath;

        public String getAppId() {
            return appId;
        }

        public void setAppId(String appId) {
            this.appId = appId;
        }

        public String getMchId() {
            return mchId;
        }

        public void setMchId(String mchId) {
            this.mchId = mchId;
        }

        public String getAppSecret() {
            return appSecret;
        }

        public void setAppSecret(String appSecret) {
            this.appSecret = appSecret;
        }

        public String getCertPath() {
            return certPath;
        }

        public void setCertPath(String certPath) {
            this.certPath = certPath;
        }
    }

    public static class PayPal {
        private Client client = new Client();
        private Sandbox sandbox = new Sandbox();

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
        }

        public Sandbox getSandbox() {
            return sandbox;
        }

        public void setSandbox(Sandbox sandbox) {
            this.sandbox = sandbox;
        }

        public static class Client {
            private String id;
            private String secret;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }
        }

        public static class Sandbox {
            private Client client;

            public Client getClient() {
                return client;
            }

            public void setClient(Client client) {
                this.client = client;
            }
        }
    }
}
