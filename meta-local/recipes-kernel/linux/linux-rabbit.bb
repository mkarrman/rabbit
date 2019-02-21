include recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel from Kernel.org usb-next with ??? patches for rabbit"
DESCRIPTION = "Linux kernel that is based on Kernel.org's usb-next branch, \
with full support for the i.MX6 features with added patches for rabbit."
PV = "5.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

DEPENDS += "lzop-native bc-native"
SRCBRANCH = "usb-next"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "https://github.com/mkarrman/linux-kernel.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(rabbit)"

## Uncomment the following to use local source tree ##
inherit externalsrc
EXTERNALSRC = "/home/mats/project/cubox/linux-rabbit"
