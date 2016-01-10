SUMMARY = "A console image with tools to test debugging features."

IMAGE_FEATURES += "tools-profile package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    dropbear \
    gdbserver \
    lrzsz \
    lttng-modules \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

