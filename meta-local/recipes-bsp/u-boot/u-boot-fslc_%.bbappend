# Tweak u-boot for rabbit machine

COMPATIBLE_MACHINE = "(rabbit)"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append_rabbit = " file://bootscript.txt"

do_compile_append_rabbit() {
    ${B}/tools/mkimage \
        -T script -C none -n 'Rabbit Boot Script' \
        -d ${WORKDIR}/bootscript.txt ${B}/boot.scr
}

do_install_append_rabbit() {
    install -m 0644 ${B}/boot.scr ${D}/boot/
}

do_deploy_append_rabbit() {
    install -m 0644 ${B}/boot.scr ${DEPLOYDIR}
}
