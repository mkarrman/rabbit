SUMMARY = "A Wayland based image for the Magic Mirror project"

IMAGE_FEATURES += "package-management"
##IMAGE_FEATURES += "tools-profile"

LICENSE = "MIT"

inherit image features_check

REQUIRED_DISTRO_FEATURES = "systemd wayland"

# base system
IMAGE_INSTALL = "\
    base-files \
    base-passwd \
    dropbear \
    module-init-tools \
    netbase \
    ${VIRTUAL-RUNTIME_base-utils} \
    ${VIRTUAL-RUNTIME_base-utils-syslog} \
    ${VIRTUAL-RUNTIME_dev_manager} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_update-alternatives} \
"

# packages requested by distribution
IMAGE_INSTALL += "\
    ${DISTRO_EXTRA_RDEPENDS} \
"
#    ${DISTRO_EXTRA_RRECOMMENDS} \
#

# packages requested by machine config
IMAGE_INSTALL += "\
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    ${MACHINE_EXTRA_RDEPENDS} \
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
"

# ALSA sound support
IMAGE_INSTALL += "\
    alsa-utils-alsactl \
    alsa-utils-alsamixer \
    ${VIRTUAL-RUNTIME_alsa-state} \
"
#    kernel-module-snd-mixer-oss \
#    kernel-module-snd-pcm-oss"
#

# USB host support
IMAGE_INSTALL += "\
    usbutils \
"
#    kernel-module-uhci-hcd \
#    kernel-module-ohci-hcd \
#    kernel-module-ehci-hcd \
#    kernel-module-usbcore \
#    kernel-module-usbhid \
#    kernel-module-usbnet \
#    kernel-module-sd-mod \
#    kernel-module-scsi-mod \
#    kernel-module-usbmouse \
#    kernel-module-mousedev \
#    kernel-module-usbserial \
#    kernel-module-usb-storage \
#

# FAT filesystem support
IMAGE_INSTALL += "\
    dosfstools \
"
#    kernel-module-msdos \
#    kernel-module-vfat \
#    kernel-module-nls-iso8859-1 \
#    kernel-module-nls-cp437 \
#

# WiFi support
IMAGE_INSTALL += "\
    crda \
    iw \
    wpa-supplicant \
    linux-firmware-ath9k \
"
#    wireless-regdb-static \
#    kernel-module-ath9k-htc \
#    kernel-module-zd1211rw \
#    kernel-module-ieee80211-crypt \
#    kernel-module-ieee80211-crypt-ccmp \
#    kernel-module-ieee80211-crypt-tkip \
#    kernel-module-ieee80211-crypt-wep \
#    kernel-module-ecb \
#    kernel-module-arc4 \
#    kernel-module-crypto_algapi \
#    kernel-module-cryptomgr \
#    kernel-module-michael-mic \
#    kernel-module-aes-generic \
#    kernel-module-aes"
#

# Connectivity support
IMAGE_INSTALL += "\
    avahi-daemon \
    libnss-mdns \
"
#    connman \
#    connman-client \
#    connman-conf \
#

# UI services
IMAGE_INSTALL += "\
    kiosker \
    libevdev-evemu \
    lighttpd \
    lighttpd-module-proxy \
    python3 \
    python3-evdev \
    python3-flask \
    python3-waitress \
    webkitgtk \
    weston \
    weston-init \
"

# UI
IMAGE_INSTALL += "\
    mmweb \
"

# Graphics examples
#IMAGE_INSTALL += "\
#    clutter-1.0-examples \
#    gtk+3-demo \
#    matchbox-terminal \
#    weston-examples \
#    weston-xwayland \
#"

# Dev tools
IMAGE_INSTALL += "\
    gdbserver \
    i2c-tools \
    lrzsz \
    systemd-analyze \
    tcpdump \
"
#    lttng-modules \
#

IMAGE_LINGUAS = " "

IMAGE_BOOT_FILES += "\
    boot.scr \
"

# Qemu Boot tweak
QB_MEM = "-m 512"

IMAGE_ROOTFS_SIZE ?= "8192"

# Uncomment to *not* have the final image gzip'ed
IMAGE_FSTYPES = "wic"

