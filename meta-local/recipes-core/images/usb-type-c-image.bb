SUMMARY = "An image for testing USB Type-C patches"

#IMAGE_FEATURES += "tools-profile"
IMAGE_FEATURES += "package-management"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    dropbear \
"

# Add some dev stuff
IMAGE_INSTALL += "\
    gdbserver \
    lrzsz \
"

IMAGE_LINGUAS = " "

IMAGE_BOOT_FILES += "\
    boot.scr \
"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

# Uncomment to *not* have the final image gzip'ed
#IMAGE_FSTYPES = "wic"
