SUMMARY = "An image for the Rabbit Empire Monitoring project"

#IMAGE_FEATURES += "tools-profile"
IMAGE_FEATURES += "package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    connman \
    connman-client \
    connman-conf \
    crda \
    dropbear \
    firmware-htc-9271 \
    iw \
    kernel-module-ath9k-htc \
    wpa-supplicant \
"

# Add some dev stuff
IMAGE_INSTALL += "\
    gdbserver \
    lrzsz \
    lttng-modules \
    wireless-tools \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

# Uncomment to *not* have the final image gzip'ed
IMAGE_FSTYPES = "sdcard"
