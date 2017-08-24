include recipes-kernel/linux/linux-imx.inc
include recipes-kernel/linux/linux-dtb.inc

SUMMARY = "Linux 4.13 kernel from Kernel.org stable with ??? patches for rabbit"
DESCRIPTION = "Linux kernel that is based on Kernel.org's 4.13.y stable branch, \
with full support for the i.MX6 features with added patches for rabbit."
 
DEPENDS += "lzop-native bc-native"
SRCBRANCH = "linux-4.13.y-rabbit"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

SRC_URI = "https://github.com/mkarrman/linux-kernel.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(rabbit)"

## Uncomment the following to use local source tree ##
#inherit externalsrc
#EXTERNALSRC = "/home/...../linux-rabbit"
