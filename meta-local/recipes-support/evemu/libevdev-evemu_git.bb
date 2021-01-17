SUMMARY = "Kernel evdev device emulation"
DESCRIPTION = "The evemu library and tools are used to describe devices, \
record data, create devices and replay data from kernel evdev devices. \
This implementation comes from the Freedesktop libevdev project."
HOMEPAGE = "https://www.freedesktop.org/wiki/Evemu/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

DEPENDS = "libevdev (>= 1.2.99.902)"

EXTRA_OECONF = "--disable-python-bindings --disable-tests"

inherit autotools pkgconfig

SRC_URI = "git://gitlab.freedesktop.org/libevdev/evemu.git;protocol=https"

SRCREV = "86a5627dbeac8d9d9bc34326a758d6a477e876e4"

PV = "2.7.0+git${SRCPV}"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""
