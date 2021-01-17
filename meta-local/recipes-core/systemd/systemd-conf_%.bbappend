FILESEXTRAPATHS_prepend := "${THISDIR}/systemd-conf:"

SRC_URI += "file://wifi.network"

do_install_append () {

	# Don't use 'less' as pager for utils
	install -d ${D}/${sysconfdir}/profile.d
	echo "export SYSTEMD_PAGER=cat" > ${D}/${sysconfdir}/profile.d/systemd.sh

	# Add wifi network config
	install -d ${D}/${systemd_unitdir}/network
	install -m 0644 ${WORKDIR}/wifi.network ${D}/${systemd_unitdir}/network/80-wifi.network
}

FILES_${PN} += "${sysconfdir}/profile.d/* ${systemd_unitdir}/network/*"

