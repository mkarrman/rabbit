SUMMARY_rabbit = "Connman config for rabbit machine"
DESCRIPTION_rabbit = "This is the ConnMan configuration to set up network \
interfaces for the rabbit machine."

FILESEXTRAPATHS_prepend := "${THISDIR}/connman-conf:"
SRC_URI_append_rabbit = " file://wifi.config"

do_install_append_rabbit() {
    install -d ${D}${localstatedir}/lib/connman
    install -m 0644 ${WORKDIR}/wifi.config ${D}${localstatedir}/lib/connman

    sed -i -e "s/yourssid/${CONNMAN_WIFI_SSID}/" \
           -e "s/yourname/${CONNMAN_WIFI_SSID}/" \
           -e "s/yourpass/${CONNMAN_WIFI_PASS}/" \
        ${D}${localstatedir}/lib/connman/wifi.config
}
