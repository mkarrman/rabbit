SUMMARY = "Firmware for Atheros htc 9271"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${LOCALDIR}/COPYING.MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://htc_9271.fw"

PR = "r0"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${base_libdir}/*"

do_install() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 ${WORKDIR}/htc_9271.fw ${D}${base_libdir}/firmware
}
