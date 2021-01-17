SUMMARY = "Linux kernel from Kernel.org stable with ??? patches for Magic Mirror"
DESCRIPTION = "Linux kernel that is based on Kernel.org's stable branch, \
with full support for the i.MX6 features with added patches for Magic Mirror."
PV = "5.9"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel-yocto kernel

DEPENDS += "lzop-native bc-native"

SRCBRANCH = "linux-5.9.y-magicmirror"
SRCREV = "${AUTOREV}"
LOCALVERSION ?= "-${SRCBRANCH}"

# Never mind what y in 5.9.y is since we will be rebasing often
KERNEL_VERSION_SANITY_SKIP="1"

SRC_URI = "https://github.com/mkarrman/linux-kernel.git;branch=${SRCBRANCH} \
           file://defconfig"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(magicmirror)"

# Set kconfig mode to "all defaults + defconfig options"
KCONFIG_MODE="--alldefconfig"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

## Uncomment the following to use local source tree ##
inherit externalsrc
EXTERNALSRC = "/home/mats/project/cubox/linux-rabbit"
