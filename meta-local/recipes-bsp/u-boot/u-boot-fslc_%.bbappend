# Tweak u-boot for rabbit and magicmirror machines

COMPATIBLE_MACHINE = "(rabbit|magicmirror)"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append = " file://bootscript.txt"

do_compile_append() {
    ${B}/tools/mkimage \
        -T script -C none -n 'Rabbit Boot Script' \
        -d ${WORKDIR}/bootscript.txt ${B}/boot.scr
}

do_install_append() {
    install -m 0644 ${B}/boot.scr ${D}/boot/
}

do_deploy_append() {
    install -m 0644 ${B}/boot.scr ${DEPLOYDIR}
}
