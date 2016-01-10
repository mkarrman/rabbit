SUMMARY = "An image for the Rabbit Empire Monitoring project"

IMAGE_FEATURES += "tools-profile package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    connman \
    connman-client \
    connman-conf \
    crda \
    dropbear \
    firmware-htc-9271 \
    kernel-module-ath9k-htc \
    wpa-supplicant \
"

# Add some dev stuff
IMAGE_INSTALL += "\
    gdbserver \
    lrzsz \
    lttng-modules \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

