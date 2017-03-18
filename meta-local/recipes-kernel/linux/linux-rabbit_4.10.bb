include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux 4.10.y kernel from Kernel.org stable with ??? patches for rabbit"
DESCRIPTION = "Linux kernel that is based on Kernel.org's 4.10.y stable branch, \
with full support for the i.MX6 features with added patches for rabbit."

DEPENDS += "lzop-native bc-native"
SRCBRANCH = "linux-4.10.y-rabbit"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "git:///home/mats/projects/cubox/linux-rabbit;protocol=file;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(rabbit)"
