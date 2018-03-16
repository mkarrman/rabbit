# Tweak u-boot for rabbit machine

COMPATIBLE_MACHINE = "(rabbit)"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI_append_rabbit = " file://bootscript.txt"
uboot_machine = "${@d.getVar('UBOOT_MACHINE', True).strip()}"

do_compile_append_rabbit() {
    ${B}/${uboot_machine}/tools/mkimage \
        -T script -C none -n 'Rabbit Boot Script' \
        -d ${WORKDIR}/bootscript.txt ${B}/${uboot_machine}/boot.scr
}

do_install_append_rabbit() {
    install -m 0644 ${B}/${uboot_machine}/boot.scr ${D}/boot/
}

do_deploy_append_rabbit() {
    install -m 0644 ${B}/${uboot_machine}/boot.scr ${DEPLOYDIR}
}
