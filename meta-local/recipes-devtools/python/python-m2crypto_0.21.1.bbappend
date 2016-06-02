# crda depends on python-m2crypto-native (x86) but openssl is buildt without SSLv2 support
SWIG_FEATURES_x86-64 += "-DOPENSSL_NO_SSL2"
