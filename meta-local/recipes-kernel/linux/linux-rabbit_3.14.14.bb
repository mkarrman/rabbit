include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "SolidRun 3.14.14 kernel with patches for rabbit"
DESCRIPTION = "Linux kernel that is based on Linaro's 3.14 releases, \
with full support for the i.MX6 features with added \
patches for rabbit."

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "rabbit-master"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "git:///home/mats/projects/cubox/linux-imx6-3.14;protocol=file;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(rabbit)"
