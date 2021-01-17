FILESEXTRAPATHS_prepend := "${THISDIR}/wpa-supplicant:"

WIFI_SSID ??= ""
WIFI_PASS ??= ""
WIFI_PSK ??= ""

DEPENDS_append_class-target = " wpa-supplicant-native"

SRC_URI += "file://usb-wlan.rules"

do_install_append_class-target () {

	# Patch WiFi credentials into config file
	wifi_psk="${WIFI_PSK}"
	if [ -z "$wifi_psk" -a -n "${WIFI_SSID}" -a -n "${WIFI_PASS}" ]; then
		wifi_psk=$(wpa_passphrase "${WIFI_SSID}" "${WIFI_PASS}" \
		           | awk -F'=' '/[^#]psk=/ {print $2}')
	fi

	sed -i -e "s|%ssid%|${WIFI_SSID}|" \
	       -e "s|%psk%|$wifi_psk|" \
	    ${D}${sysconfdir}/wpa_supplicant.conf

	# Add udev rules to trigger systemd service at hotplug
	install -d ${D}${sysconfdir}/udev/rules.d
	install -p -m 0644 ${WORKDIR}/usb-wlan.rules ${D}${sysconfdir}/udev/rules.d/30-usb-wlan.rules

	# Patch systemd device speciffic service file to bind to the device
	# (making it unload wpa_supplicant if device is unplugged) and to
	# use one and same config file for all devices.
	sed -i -e 's|Requires=sys-subsystem-net|BindsTo=sys-subsystem-net|' \
	       -e 's|wpa_supplicant/wpa_supplicant-%I.conf|wpa_supplicant.conf|' \
	    ${D}${systemd_unitdir}/system/wpa_supplicant@.service
}

FILES_${PN} += "${systemd_unitdir}/network/*"

BBCLASSEXTEND = "native"
