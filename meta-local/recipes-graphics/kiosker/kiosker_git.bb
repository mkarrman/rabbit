SUMMARY = "Kiosk mode web browser with UDS command interface"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=181da7710307abb197198151142ab101"

DEPENDS = "systemd webkitgtk"

SRC_URI = "\
    git://github.com/mkarrman/kiosker.git;branch=master;protocol=https \
    file://72-kiosker-drm.rules \
    file://kiosker.service \
    file://kiosker.socket \
"
SRCREV = "e4960fbdaa31b06ef3d48ca8bdc77388834c4609"

S = "${WORKDIR}/git"

inherit cmake pkgconfig systemd

do_install () {
	install -d ${D}${bindir}
	install -p -m 0755 ${B}/src/kiosker/kiosker ${D}${bindir}/
	install -p -m 0755 ${B}/src/kioskcmd/kioskcmd ${D}${bindir}/
	install -d ${D}${sysconfdir}/udev/rules.d
	install -p -m 0644 ${WORKDIR}/72-kiosker-drm.rules ${D}${sysconfdir}/udev/rules.d/
	install -d ${D}${systemd_system_unitdir}
	install -p -m 0644 ${WORKDIR}/kiosker.service ${D}${systemd_system_unitdir}/
	install -p -m 0644 ${WORKDIR}/kiosker.socket ${D}${systemd_system_unitdir}/
}

FILES_${PN} = "\
    ${bindir}/kiosker \
    ${bindir}/kioskcmd \
    ${sysconfdir}/udev/rules.d/72-kiosker-drm.rules \
    ${systemd_system_unitdir}/kiosker.service \
    ${systemd_system_unitdir}/kiosker.socket \
"

# The kiosker.service is triggered by udev event
SYSTEMD_SERVICE_${PN} = "kiosker.service kiosker.socket"
SYSTEMD_AUTO_ENABLE = "disable"

RDEPENDS_${PN} += "libsystemd webkitgtk gtk+3 glib-2.0"

