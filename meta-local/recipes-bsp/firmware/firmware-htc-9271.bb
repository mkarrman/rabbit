SUMMARY = "Firmware for Atheros htc 9271"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE.atheros_firmware;md5=30a14c7823beedac9fa39c64fdd01a13"

SRC_URI = "file://htc_9271.fw \
           file://htc_9271-1.4.0.fw \
           file://LICENCE.atheros_firmware"

PR = "r1"

S = "${WORKDIR}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${base_libdir}/*"

do_install() {
    install -d ${D}${base_libdir}/firmware
    install -m 0644 ${WORKDIR}/htc_9271*.fw ${D}${base_libdir}/firmware
}
