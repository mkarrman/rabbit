SUMMARY = "Magic Mirror web source files"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=929b8a717e3f46ce261558d5d24e5c5b"

RDEPENDS_${PN} = "python3-core python3-flask python3-waitress"

SRC_URI = "\
    git://git.karrman.nu/mmweb;branch=master \
"
SRCREV = "7dcce9e1b9dbd2be198c19abd36e71eba7d09063"

S = "${WORKDIR}/git"

inherit systemd

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/www/pages
	install -p -m 0755 ${S}/pages/* ${D}/www/pages/
	
	install -d ${D}/www/application
	install -p -m 0755 ${S}/application/*.py ${D}/www/application/
	ln -s ../pages ${D}/www/application/static

	install -d ${D}${systemd_system_unitdir}
	install -p -m 0644 ${S}/systemd/mmweb.service ${D}${systemd_system_unitdir}/
}

FILES_${PN} = "\
    /www/pages/* \
    /www/application/* \
    ${systemd_system_unitdir}/mmweb.service \
"

SYSTEMD_SERVICE_${PN} = "mmweb.service"
SYSTEMD_AUTO_ENABLE = "enable"
