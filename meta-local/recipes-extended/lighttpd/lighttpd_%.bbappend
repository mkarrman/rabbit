FILESEXTRAPATHS_prepend := "${THISDIR}/lighttpd:"

#PACKAGECONFIG = "..."

do_install_append() {
	rm -f ${D}/www/pages/index.html
}
