package com.barclays.authorization.Authservice.configuration.uaaProperties;

public class UaaProperties {

    private KeyStore keyStore = new KeyStore();

    public KeyStore getKeyStore() {
        return keyStore;
    }
    /**
     * Keystore configuration for signing and verifying JWT tokens.
     */
    public static class KeyStore {
        //name of the keystore in the classpath
        private String name = "KeyStore.jks";
        //password used to access the key
        private String password = "Barclays@2017";
        //name of the alias to fetch
        private String alias = "authServer";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }
}
