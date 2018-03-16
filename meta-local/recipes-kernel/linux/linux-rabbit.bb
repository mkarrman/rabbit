include recipes-kernel/linux/linux-imx.inc

SUMMARY = "Linux kernel from Kernel.org usb-next with ??? patches for rabbit"
DESCRIPTION = "Linux kernel that is based on Kernel.org's usb-next branch, \
with full support for the i.MX6 features with added patches for rabbit."
PV = "4.16"

DEPENDS += "lzop-native bc-native"
SRCBRANCH = "usb-next-rabbit"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "https://github.com/mkarrman/linux-kernel.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(rabbit)"

## Uncomment the following to use local source tree ##
inherit externalsrc
EXTERNALSRC = "/home/mats/project/cubox/linux-rabbit"
