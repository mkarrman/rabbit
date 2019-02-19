SUMMARY = "An image for the Rabbit Empire Monitoring project"

#IMAGE_FEATURES += "tools-profile"
IMAGE_FEATURES += "package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
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
"
#    lttng-modules \
#       - v2.10.7 is not compatible with kernel 5.0 due to access_ok() macro change

IMAGE_LINGUAS = " "

IMAGE_BOOT_FILES += "\
    boot.scr \
"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

# Uncomment to *not* have the final image gzip'ed
#IMAGE_FSTYPES = "wic"
